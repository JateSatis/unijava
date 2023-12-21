package pract23;

import java.util.*;

abstract class Expression {
    abstract int evaluate(int x);
}

class Const extends Expression {
    private final int value;

    Const(int value) {
        this.value = value;
    }

    @Override
    int evaluate(int x) {
        return value;
    }
}

class Variable extends Expression {
    @Override
    int evaluate(int x) {
        return x;
    }
}

abstract class BinaryOperation extends Expression {
    final Expression left;
    final Expression right;

    BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

class Add extends BinaryOperation {
    Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x) {
        return left.evaluate(x) + right.evaluate(x);
    }
}

class Subtract extends BinaryOperation {
    Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x) {
        return left.evaluate(x) - right.evaluate(x);
    }
}

class Multiply extends BinaryOperation {
    Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x) {
        return left.evaluate(x) * right.evaluate(x);
    }
}

class Divide extends BinaryOperation {
    Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x) {
        return left.evaluate(x) / right.evaluate(x);
    }
}

public class ExpressionsTest {
    public static void main(String[] args) {
        Expression expr = new Subtract(
                new Multiply(
                        new Const(2),
                        new Variable()
                ),
                new Const(3)
        );
        System.out.println(expr.evaluate(5)); // Выводит 7

        Expression expr2 = new Subtract(
                new Multiply(
                        new Variable(),
                        new Variable()
                ),
                new Add(
                        new Multiply(
                                new Const(2),
                                new Variable()
                        ),
                        new Const(1)
                )
        );
        System.out.println(expr2.evaluate(5)); // Выводит 14
    }
}
















/*abstract class Expression {
    abstract int evaluate(int x, int y, int z);
}

class Const extends Expression {
    private final int value;

    Const(int value) {
        this.value = value;
    }

    @Override
    int evaluate(int x, int y, int z) {
        return value;
    }
}

class Variable extends Expression {
    private final String name;

    Variable(String name) {
        this.name = name;
    }

    @Override
    int evaluate(int x, int y, int z) {
        switch (name) {
            case "x":
                return x;
            case "y":
                return y;
            case "z":
                return z;
            default:
                throw new AssertionError("Unknown variable " + name);
        }
    }
}

abstract class BinaryOperation extends Expression {
    final Expression left;
    final Expression right;

    BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}

class Add extends BinaryOperation {
    Add(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) + right.evaluate(x, y, z);
    }
}

class Subtract extends BinaryOperation {
    Subtract(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) - right.evaluate(x, y, z);
    }
}

class Multiply extends BinaryOperation {
    Multiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) * right.evaluate(x, y, z);
    }
}

class Divide extends BinaryOperation {
    Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int evaluate(int x, int y, int z) {
        return left.evaluate(x, y, z) / right.evaluate(x, y, z);
    }
}

class ExpressionParser {
    private final String expression;
    private int index;

    ExpressionParser(String expression) {
        this.expression = expression;
        this.index = 0;
    }

    Expression parse() {
        return parseExpression();
    }

    private Expression parseExpression() {
        Expression result = parseTerm();
        while (true) {
            if (match('+')) {
                result = new Add(result, parseTerm());
            } else if (match('-')) {
                result = new Subtract(result, parseTerm());
            } else {
                return result;
            }
        }
    }

    private Expression parseTerm() {
        Expression result = parseFactor();
        while (true) {
            if (match('*')) {
                result = new Multiply(result, parseFactor());
            } else if (match('/')) {
                result = new Divide(result, parseFactor());
            } else {
                return result;
            }
        }
    }

    private Expression parseFactor() {
        if (match('-')) {
            return new Subtract(new Const(0), parseFactor());
        } else if (match('(')) {
            Expression result = parseExpression();
            match(')');
            return result;
        } else if (Character.isDigit(peek())) {
            return parseConst();
        } else {
            return parseVariable();
        }
    }

    private Const parseConst() {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(peek())) {
            char digit = next();
            sb.append(digit);
        }
        return new Const(Integer.parseInt(sb.toString()));
    }

    private Variable parseVariable() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(peek())) {
            char letter = next();
            sb.append(letter);
        }
        return new Variable(sb.toString());
    }

    private boolean match(char ch) {
        while (Character.isWhitespace(peek())) {
            next();
        }
        if (peek() == ch) {
            next();
            return true;
        }
        return false;
    }

    private char peek() {
        return index < expression.length() ? expression.charAt(index) : '\0';
    }

    private char next() {
        return expression.charAt(index++);
    }
}


public class ExpressionsTest {
    public static void main(String[] args) {
        String expr = "x * (y - 2)*z + 1";
        ExpressionParser parser = new ExpressionParser(expr);
        Expression expression = parser.parse();
        for (int x = 0; x <= 10; x++) {
            for (int y = 0; y <= 10; y++) {
                for (int z = 0; z <= 10; z++) {
                    System.out.println(expression.evaluate(x, y, z));
                }
            }
        }
    }
}*/


