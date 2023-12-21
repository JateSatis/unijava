package pract12;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;

abstract class Shape {
    protected Color color = new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
    protected int x;
    protected int y;
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    public int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }
}

class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class RandomShapesComponent extends JComponent {

    public BufferedImage image;

    @Override
    protected void paintComponent(Graphics g) {
        setSize(800, 800);

        this.image = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            Shape shape;
            if (random.nextBoolean()) {
                shape = new Rectangle(random.nextInt(750), random.nextInt(750), random.nextInt(50, 200), random.nextInt(200));
            }
            else {
                shape = new Circle(random.nextInt(750), random.nextInt(750), random.nextInt(50, 200));
            }
            while (isOverlapping(shape) || isBeyondEdges(shape)) {
                shape.x = random.nextInt(800); shape.y = random.nextInt(800);
            }
            shape.draw(g2);
        }

        g.drawImage(image, 0, 0, null);
    }

    public boolean isOverlapping(Shape shape) {
        for (int x = 0; x < 800; x++) {
            for (int y = 0; y < 800; y++) {
                if (this.image.getRGB(x, y) != 0 && containsPixel(shape, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsPixel(Shape shape, int x, int y) {
        if (shape instanceof Rectangle) {
            return (
                (x > shape.x)
                && (x < shape.x + ((Rectangle) shape).width)
                && (y > shape.y)
                && (y < shape.y + ((Rectangle) shape).height)
            );
        } else if (shape instanceof Circle) {
            return (
                (x > shape.x)
                && (x < shape.x + ((Circle) shape).radius)
                && (y > shape.y)
                && (y < shape.y + ((Circle) shape).radius)
            );
        }
        return true;
    }

    public boolean isBeyondEdges(Shape shape) {
        if (shape instanceof Rectangle)
            return ((shape.x + ((Rectangle) shape).width) > 750 || (shape.y + ((Rectangle) shape).height) > 750);
        else if (shape instanceof Circle)
            return (shape.x + ((Circle) shape).radius) > 800 || (shape.y + ((Circle) shape).radius) > 800;
        return false;
    }
}

public class RandomShapesFrame extends JFrame {
    public RandomShapesFrame() {
        setTitle("Random Shapes");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        RandomShapesFrame frame = new RandomShapesFrame();
        RandomShapesComponent component = new RandomShapesComponent();
        frame.add(component);
        frame.setVisible(true);
    }
}


