package pract18;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner( System.in);
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println( 2/i );
        } catch (NumberFormatException e) {
            System.out.println("Arithmetic exception");
        } catch (ArithmeticException e) {
            System.out.println("Exception occurred");
        }

    }
}
