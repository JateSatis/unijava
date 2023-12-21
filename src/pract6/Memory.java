package pract6;

public class Memory implements Customizable {
    private int capacity;

    public Memory() {
        this.capacity = Integer.parseInt(this.getValueFromUser("Введите размер жесткого диска в ГБ:"));
    }

    public int getCapacity() {
        return capacity;
    }
}
