package pract19.inn;

import java.util.ArrayList;
import java.util.Scanner;

class InvalidITN extends Exception {
    public InvalidITN(String errorMessage) {
        super(errorMessage);
    }
}

class ITNChecker {
    public static boolean checkTenDigitITN(String itn) throws InvalidITN {
        String[] itnChars = itn.split("");
        ArrayList<Integer> itnNumbers = new ArrayList<>();
        int[] checkNumbers = { 2, 4, 10, 3, 5, 9, 4, 6, 8 };
        for (String character : itnChars) {
            itnNumbers.add(Integer.parseInt(character));
        }

        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += itnNumbers.get(i) * checkNumbers[i];
        }

        if ((result % 11) == itnNumbers.get(9)) {
            return true;
        } else {
            throw new InvalidITN("invalid itn");
        }
    }
}

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String itn = scanner.nextLine();

        try {
            System.out.println(ITNChecker.checkTenDigitITN(itn));
        } catch (InvalidITN e) {
            System.out.println(e.getMessage());
        }
    }


}
