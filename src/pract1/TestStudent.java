package pract1;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("Billy", 17);
        Student student2 = new Student("Charlie", 23);
        Student student3 = new Student("Poppy", 19);
        student3.setAge(20);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        student1.psychologicalAge();
    }
}
