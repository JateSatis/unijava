package pract13;

class Shirt {
    public String id;
    public String name;
    public String color;
    public String size;

    public Shirt(String description) {
        String[] parameters = description.split(",");
        this.id = parameters[0];
        this.name = parameters[1];
        this.color = parameters[2];
        this.size = parameters[3];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("--------------------------").append("\n");
        result.append("Идентификационный номер футболки: ").append(this.id).append("\n");
        result.append("Название футболки: ").append(this.name).append("\n");
        result.append("Цвет футболки: ").append(this.color).append("\n");
        result.append("Размер футболки: ").append(this.size).append("\n");
        return result.toString();
    }
}

public class ex4 {
    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        for (String shirt : shirts) {
            System.out.println(new Shirt(shirt));
        }
    }
}
