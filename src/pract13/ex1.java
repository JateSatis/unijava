package pract13;

public class ex1 {
    public static void stringManipulations(String str) {
        System.out.println("Последний символ строки: " + str.charAt(str.length() - 1));
        System.out.println("Заканчивается ли строка на \"!!!\"? - " + str.endsWith("!!!"));
        System.out.println("Начинается ли строка на \"I like\"? - " + str.startsWith("I like"));
        System.out.println("Содержит ли подстроку \"Java\"? - " + str.contains("Java"));
        System.out.println("Слово \"Java\" находится на позиции " + str.indexOf("Java"));
        System.out.println("Строка с замененнными символами: " + str.replace('a', 'o'));
        System.out.println("Строка в верхнем регистре: " + str.toUpperCase());
        System.out.println("Строка в нижнем регистре: " + str.toLowerCase());
    }

    public static void main(String[] args) {
        stringManipulations("I like Java!!!");
    }
}
