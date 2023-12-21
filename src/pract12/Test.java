package pract12;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

class RectangleTest {
    public int width;
    public int height;
    public int x;
    public int y;
    public boolean isAddedToFrame = false;
    public Color color = new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));;

    public RectangleTest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

class CircleTest {
    public int width;
    public int height;
    public int x;
    public int y;
    public boolean isAddedToFrame = false;
    public Color color = new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));;

    public CircleTest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}

class RectanglesApp {
    public int shapesAmount;
    public ArrayList<RectangleTest> rectangles = new ArrayList<>();
    public ArrayList<ArrayList<RectangleTest>> lines = new ArrayList<>();
    public int boardWidth;
    public int boardHeight;

    public RectanglesApp(int boardHeight, int boardWidth, int shapesAmount) {
        this.shapesAmount = shapesAmount;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    public void createShapes() {
        Random random = new Random();

        for (int i = 0; i < this.shapesAmount; i++) {
            int width = random.nextInt(5, 100);
            int height = random.nextInt(5,100);
            this.rectangles.add(new RectangleTest(width, height));
        }
    }

    public void sortByHeight() {
        this.rectangles.sort(new Comparator<RectangleTest>() {
            @Override
            public int compare(RectangleTest o1, RectangleTest o2) {
                return o2.height - o1.height;
            }
        });
    }

    public void packRectangles() {
        int horizontalDistanceLeft = this.boardWidth - this.rectangles.get(0).width;
        int verticalDistanceLeft = this.boardHeight - this.rectangles.get(0).height;
        this.createNewLine(this.rectangles.get(0));
        this.addShapeToFrame(this.rectangles.get(0), horizontalDistanceLeft, verticalDistanceLeft);
        int lineIndex = 0;
        int rectanglesIndex = 1;
        while (rectanglesIndex < this.rectangles.size()) {
            ArrayList<RectangleTest> currentLine = this.lines.get(lineIndex);
            while (rectanglesIndex < this.rectangles.size()) {
                RectangleTest currentRect = this.rectangles.get(rectanglesIndex);
                if (horizontalDistanceLeft - currentRect.width > 0) {
                    currentLine.add(currentRect);
                    horizontalDistanceLeft -= currentRect.width;
                    rectanglesIndex++;
                    this.addShapeToFrame(currentRect, horizontalDistanceLeft, verticalDistanceLeft);
                }
                else break;
            }

            if (rectanglesIndex == this.rectangles.size()) return;
            RectangleTest currentRect = this.rectangles.get(rectanglesIndex);
            if (verticalDistanceLeft - currentRect.height > 0) {
                this.createNewLine(currentRect);
                horizontalDistanceLeft = this.boardWidth - currentRect.width;
                verticalDistanceLeft -= currentRect.height;
                this.addShapeToFrame(currentRect, horizontalDistanceLeft, verticalDistanceLeft);
                rectanglesIndex++;
                lineIndex++;
            }
            else {
                break;
            }
        }
    }

    public void addShapeToFrame(RectangleTest rectangle, int x, int y) {
        rectangle.x = this.boardWidth - x - rectangle.width;
        rectangle.y = this.boardHeight - y - rectangle.height + 30;
        rectangle.isAddedToFrame = true;
    }

    public void createNewLine(RectangleTest firstInLine) {
        ArrayList<RectangleTest> newLine = new ArrayList<>();
        newLine.add(firstInLine);
        this.lines.add(newLine);
    }

    public void printLines() {
        for (ArrayList<RectangleTest> line : this.lines) {
            for (RectangleTest rect : line) {
                System.out.print("x: " + rect.x + " y: " + (rect.y - 30) + " width: " + rect.width + " height: " + rect.height + " ### ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (RectangleTest rect : this.rectangles) {
            result.append("height: ").append(rect.height).append(" width: ").append(rect.width).append("\n");
        }

        return result.toString();
    }
}

public class Test extends JFrame {
    RectanglesApp app = new RectanglesApp(800, 800, 200);

    public Test() {
        setTitle("Random Shapes");
        setSize(app.boardWidth, app.boardHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        app.createShapes();
        app.sortByHeight();
        System.out.println(app);
        System.out.println("\n=====================================\n");
        app.packRectangles();
        app.printLines();
    }

    public static void main(String[] args) {
        Test board = new Test();
        board.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for (RectangleTest shape : this.app.rectangles) {
            if (shape.isAddedToFrame)
                shape.draw(g);
        }
    }
}
