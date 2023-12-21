package pract8;

public class Ex7 {
    public static void main(String[] args) {
        int n = 714;
        printPrimeFactors(n);
    }

    public static void printPrimeFactors(int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                printPrimeFactors(n / i);
                return;
            }
        }

        System.out.print(n + " ");
    }
}
