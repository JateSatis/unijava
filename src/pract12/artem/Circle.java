package pract12.artem;

import java.awt.*;

public class Circle extends Shape {
    int radius;

    public Circle(Color color, Point position, int radius) {
        super(color, position);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.x - radius, position.y - radius, radius*2, radius*2); //влево и вверх к углу описывающего прямоугольника
    }

    @Override
    public boolean contains(int x, int y) {
        int dx = x - position.x;
        int dy = y - position.y;
        return dx*dx + dy*dy <= radius*radius;
    }
}
