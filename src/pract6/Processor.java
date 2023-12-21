package pract6;

public class Processor implements Customizable {
    private int coreCount;
    private int frequencyInHertz;

    public Processor() {
        this.coreCount = Integer.parseInt(this.getValueFromUser("Введите количество ядер процессора:"));
        this.coreCount = Integer.parseInt(this.getValueFromUser("Введите частоту процессора:"));
    }

    public int getCoreCount() {
        return coreCount;
    }

    public int getFrequencyInHertz() {
        return frequencyInHertz;
    }
}
