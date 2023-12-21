package pract14;

public class ex1 {
    public static void main(String[] args) {
        String input = "Hello how are you?";

        String[] words = input.split("\\s");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
