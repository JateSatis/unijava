package pract22;

import java.util.Scanner;
import java.util.Stack;

import java.util.Stack;

 class PostfixCalculator {

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
                throw new IllegalArgumentException("Недостаточно операторов для выражения: " + token);
            }

            double operand2 = stack.pop();
            double operand1 = stack.pop();

            double result = performOperation(token.charAt(0), operand1, operand2);
            stack.push(result);
        } else {
            throw new IllegalArgumentException("Ошибка вычисления: " + token);
        }
    }

    public double getResult() {
        if (stack.size() != 1) {
            throw new IllegalStateException("Неверное выражение или операция");
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
                    throw new ArithmeticException("Деление на ноль");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Оператор не поддерживается: " + operator);
        };
    }
}




public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String postfixExpression = scanner.nextLine();

        PostfixCalculator calculator = new PostfixCalculator();
        String[] tokens = postfixExpression.split(" ");

        try {
            for (String token : tokens) {
                calculator.processToken(token);
            }

            double result = calculator.getResult();
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}
