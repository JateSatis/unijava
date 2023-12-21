package pract6;

public class Monitor implements Customizable{

    private String resolution;
    private boolean matte;

    public Monitor() {
        this.resolution = this.getValueFromUser("Напишите разрешение экрана:");
        this.matte = this.getValueFromUser("Экран с матовым прокрытием?").equals("Да");
    }

    public String getResolution() {
        return resolution;
    }

    public boolean isMatte() {
        return matte;
    }
}
