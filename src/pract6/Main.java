package pract6;

public class Main {
    public static void main(String[] args) {
        Printable[] pieces = {new Book("Harry Potter", "Joanne Rowling"),
                new Book("A Song of Ice and Fire", "George R. R. Martin"),
                new Magazine("Vogue", 3), new Magazine("Fashion Week", 84)};
        for (Printable piece : pieces) {
            piece.print();
        }
    }
}
