package pract22.CalculatorMVC;

import java.util.Stack;

public class PostfixCalculator {

    private final Stack<Double> stack;

    public PostfixCalculator() {
        this.stack = new Stack<>();
    }

    public void processToken(String token) {
        if (isNumeric(token)) {
            double value = Double.parseDouble(token);
            stack.push(value);
        } else if (isOperator(token)) {
            if (stack.size() < 2) {
                throw new IllegalArgumentException("Insufficient operands for operator: " + token);
            }

            double operand2 = stack.pop();
            double operand1 = stack.pop();

            double result = performOperation(token.charAt(0), operand1, operand2);
            stack.push(result);
        } else {
            throw new IllegalArgumentException("Invalid token: " + token);
        }
    }

    public double getResult() {
        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid expression or operation");
        }

        return stack.pop();
    }

    private boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && (token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*' || token.charAt(0) == '/');
    }

    private double performOperation(char operator, double operand1, double operand2) {
        return switch (operator) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

