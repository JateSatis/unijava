package pract6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop implements Customizable {
    private ArrayList<Computer> computers = new ArrayList<>();

    public void addComputer() {
        this.computers.add(new Computer());
    }

    public void deleteComputer() {
        int index = Integer.parseInt(this.getValueFromUser("Введите индекс компьютера, который вы хотите удалить: "));
        this.computers.remove(index);
    }

    public void printAllComputer() {
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }

    public void searchComputer() {
        for (Computer computer : computers) {
            if (computer.brand.name().equals(this.getValueFromUser("Введите бренд компьютера: "))) {
                System.out.println(computer);
            }
        }
    }
}
