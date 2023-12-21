package pract12.artem;

import java.awt.*;

public class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(Color color, Point position, int width, int height) {
        super(color, position);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(position.x  - width / 2, position.y -  height / 2, width, height); //влево и вверх к углу описывающего прямоугольника
    }

    @Override
    public boolean contains(int x, int y) {
        return x >= position.x - width / 2 && x <= position.x + width / 2 &&
                y >= position.y - height / 2 && y <= position.y + height / 2;
    }
}
