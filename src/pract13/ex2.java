package pract13;

class Person {
    public String name;
    public String surname;
    public String fathers_name;

    public Person(String name, String surname, String fathers_name) {
        this.name = name;
        this.surname = surname;
        this.fathers_name = fathers_name;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getFullName() {
        StringBuilder result = new StringBuilder(this.name);
        if (this.surname != null && this.fathers_name != null) {
            result.append(" ").append(this.surname).append(" ").append(this.fathers_name);
            return result.toString();
        }
        return result.toString();
    }
}

public class ex2 {
    public static void main(String[] args) {
        System.out.println(new Person("Maxim").getFullName());
    }
}
