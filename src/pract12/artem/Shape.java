package pract12.artem;

import java.awt.*;


public abstract class Shape {
    protected Color color;
    protected Point position;
    public Shape() {}
    public Shape(Color color, Point position) {
        this.color = color;
        this.position = position;
    }
    public abstract void draw(Graphics g);
    public abstract boolean contains(int x, int y);
}
