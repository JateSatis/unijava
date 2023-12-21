package pract6;

public class Book implements Printable {

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public void print() {
        System.out.println("The \"" + this.name + "\" is written by " + this.author);
    }

    public void printBooks(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Book) System.out.println(printable);
        }
    }
}
