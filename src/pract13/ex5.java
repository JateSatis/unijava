package pract13;

class PhoneNumberFormatter {
    public String formattedPhone;

    public PhoneNumberFormatter(String phoneNumber) {
        StringBuilder result = new StringBuilder();
        if (phoneNumber.charAt(0) == '8') {
            result.append("+7-");
            result.append(phoneNumber, 1, 4).append("-");
            result.append(phoneNumber, 4, 7).append("-");
            result.append(phoneNumber, 7, 10);
            this.formattedPhone = result.toString();
        }
        else {
            result.append("+7-");
            result.append(phoneNumber, 2, 5).append("-");
            result.append(phoneNumber, 5, 8).append("-");
            result.append(phoneNumber, 8, 11);
            this.formattedPhone = result.toString();
        }
    }

    @Override
    public String toString() {
        return this.formattedPhone;
    }
}

public class ex5 {
    public static void main(String[] args) {
        System.out.println(new PhoneNumberFormatter("+79175655655"));
        System.out.println(new PhoneNumberFormatter("89175655655"));
    }
}
