package pract8;

public class Ex9 {
    public static int countSequences(int a, int b) {
        if (a > b + 1) return 0;
        if (a == 0 || b == 0) return 1;
        // Так как ряд R(a, b) может быть получен либо из R(a, b - 1) приписываением 1
        // или из R(a - 1, b - 1) приписыванием 10
        return countSequences(a, b - 1) + countSequences(a - 1, b - 1);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int result = countSequences(a, b);
        System.out.println("Количество последовательностей из " + a + " нулей и " + b + " единиц: " + result);
    }
}
