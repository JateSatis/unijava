package pract6;

public class Computer implements Customizable {
    public Memory memory = new Memory();
    public Processor processor = new Processor();
    public Monitor monitor = new Monitor();
    public Brands brand = Brands.valueOf(this.getValueFromUser("Введите предпочитаемую операционную систему: "));

    public Computer() {}

    @Override
    public String toString() {
        return "Brand: " + this.brand.name() + ", Proccesor cores: " + this.processor.getCoreCount() +
                ", Memory cap: " + this.memory.getCapacity() + ", Monitor: " + this.monitor.getResolution();
    }
}
