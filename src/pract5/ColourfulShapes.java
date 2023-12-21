package pract5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }
}

public class ColourfulShapes extends JFrame {

    private Shape[] shapes;

    public ColourfulShapes() {
        setTitle("Random Shapes");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.shapes = new Shape[20];
        Random random = new Random();

        for (int i = 0; i < this.shapes.length; i++) {
            int x = random.nextInt(400);
            int y = random.nextInt(400);
            int size = random.nextInt(50, 100);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

            if (random.nextBoolean()) {
                this.shapes[i] = new Circle(color, x, y, size / 2);
            } else {
                this.shapes[i] = new Rectangle(color, x, y, size, size / 2);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        for (Shape shape : this.shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        ColourfulShapes colourfulShapes = new ColourfulShapes();
        colourfulShapes.setVisible(true);
    }
}