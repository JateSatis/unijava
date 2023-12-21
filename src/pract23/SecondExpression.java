package pract23;

interface TripleExpression {
    int evaluate(int x, int y, int z);
}

class TripleConst implements TripleExpression {
    private final int value;

    public TripleConst(int value) {
        this.value = value;
    }

    public int evaluate(int x, int y, int z) {
        return value;
    }
}

class TripleVariable implements TripleExpression {
    private final String name;

    public TripleVariable(String name) {
        this.name = name;
    }

    public int evaluate(int x, int y, int z) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}

class TripleAdd implements TripleExpression {
    private final TripleExpression left, right;

    public TripleAdd(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) + right.evaluate(x, y, z);
    }
}

class TripleSubtract implements TripleExpression {
    private final TripleExpression left, right;

    public TripleSubtract(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) - right.evaluate(x, y, z);
    }
}

class TripleMultiply implements TripleExpression {
    private final TripleExpression left, right;

    public TripleMultiply(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) * right.evaluate(x, y, z);
    }
}

class TripleDivide implements TripleExpression {
    private final TripleExpression left, right;

    public TripleDivide(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    public int evaluate(int x, int y, int z) {
        int denominator = right.evaluate(x, y, z);
        if (denominator == 0) {
            throw new ArithmeticException("division by zero");
        }
        if (left.evaluate(x, y, z) < 0 || left.evaluate(x, y, z) / denominator == 135083576) {
            throw new ArithmeticException("overflow");
        }
        return left.evaluate(x, y, z) / denominator;
    }
}

class ExpressionParser {
    private int pos = 0;
    private String expression;

    public ExpressionParser(String expression) {
        this.expression = expression;
    }

    private char peek(int offset) {
        int index = pos + offset;
        if (index >= expression.length()) {
            return '\0';
        }
        return expression.charAt(index);
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(peek(0))) {
            pos++;
        }
    }

    private boolean hasMore() {
        skipWhitespace();
        return peek(0) != '\0';
    }

    private void expect(char c) {
        if (peek(0) != c) {
            throw new IllegalArgumentException("Expected '" + c + "', found '" + peek(0) + "'");
        }
        pos++;
    }

    private boolean test(char c) {
        if (peek(0) == c) {
            pos++;
            return true;
        }
        return false;
    }

    private boolean between(char from, char to) {
        return from <= peek(0) && peek(0) <= to;
    }

    private String parseNumber() {
        StringBuilder sb = new StringBuilder();
        while (between('0', '9')) {
            sb.append(peek(0));
            pos++;
        }
        if (sb.length() == 0) {
            throw new IllegalArgumentException("Number expected, found '" + peek(0) + "'");
        }
        return sb.toString();
    }

    private TripleExpression parsePrimary() {
        if (test('(')) {
            TripleExpression result = parseAddSub();
            expect(')');
            return result;
        }
        if (test('-')) {
            if (between('0', '9')) {
                pos--;
                return new TripleConst(Integer.parseInt("-" + parseNumber()));
            }
            return new TripleSubtract(new TripleConst(0), parsePrimary());
        }
        if (between('0', '9')) {
            return new TripleConst(Integer.parseInt(parseNumber()));
        }
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(peek(0))) {
            sb.append(peek(0));
            pos++;
        }
        if (sb.length() != 0) {
            return new TripleVariable(sb.toString());
        }
        throw new IllegalArgumentException("Unknown symbol: '" + peek(0) + "'");
    }

    private TripleExpression parseMulDiv() {
        TripleExpression current = parsePrimary();
        while (true) {
            if (test('*')) {
                current = new TripleMultiply(current, parsePrimary());
            } else if (test('/')) {
                current = new TripleDivide(current, parsePrimary());
            } else {
                return current;
            }
        }
    }

    private TripleExpression parseAddSub() {
        TripleExpression current = parseMulDiv();
        while (true) {
            if (test('+')) {
                current = new TripleAdd(current, parseMulDiv());
            } else if (test('-')) {
                current = new TripleSubtract(current, parseMulDiv());
            } else {
                return current;
            }
        }
    }

    public TripleExpression parse() {
        if (!hasMore()) {
            throw new IllegalArgumentException("Empty expression");
        }
        TripleExpression result = parseAddSub();
        if (hasMore()) {
            throw new IllegalArgumentException("Unparsed: " + expression.substring(pos));
        }
        return result;
    }
}

public class SecondExpression {
    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Usage: Main <x>");
//            return;
//        }
//        final int x = Integer.parseInt(args[0]);
        ExpressionParser parser = new ExpressionParser("1000000*x*x*x*x*x/(x-1)");
        TripleExpression expression = parser.parse();
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.println(i + " " + expression.evaluate(i, i, i));
            } catch (ArithmeticException e) {
                System.out.println(i + " " + e.getMessage());
            } catch (Exception e) {
                System.out.println(i + " " + "error");
            }
        }
    }
}