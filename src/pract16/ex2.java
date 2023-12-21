package pract16;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ex2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(null);

        JTextArea text = new JTextArea("Приветствуем!");
        text.setBounds(100, 50, 200, 50);

        JButton center = new JButton("CENTER");
        JButton west = new JButton("WEST");
        JButton east = new JButton("EAST");
        JButton south = new JButton("SOUTH");
        JButton north = new JButton("NORTH");


        center.setBounds(200, 200, 100, 50);
        west.setBounds(100, 200, 100, 50);
        east.setBounds(300, 200, 100, 50);
        south.setBounds(200, 150, 100, 50);
        north.setBounds(200, 250, 100, 50);

        center.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                text.setText("Добро пожаловать в ЦАО");
            }
            public void mouseExited(MouseEvent e) {}
        });

        west.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                text.setText("Добро пожаловать в ЗАО");
            }
            public void mouseExited(MouseEvent e) {}
        });

        east.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                text.setText("Добро пожаловать в ВАО");
            }
            public void mouseExited(MouseEvent e) {}
        });

        south.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                text.setText("Добро пожаловать в ЮАО");
            }
            public void mouseExited(MouseEvent e) {}
        });

        north.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                text.setText("Добро пожаловать в САО");
            }
            public void mouseExited(MouseEvent e) {}
        });

        frame.add(center);
        frame.add(west);
        frame.add(east);
        frame.add(south);
        frame.add(north);
        frame.add(text);
        frame.validate();
        frame.repaint();
    }
}
