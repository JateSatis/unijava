package pract1;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void psychologicalAge() {
        System.out.println(this.name + " is " + this.age * 2 + " psychologically");
    }

    @Override
    public String toString() {
        return "Student's name is " + this.name + ". And I'm " + this.age + " years old.";
    }
}
