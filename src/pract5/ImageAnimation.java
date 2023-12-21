package pract5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageAnimation extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private Timer timer;
    private int currentIndex = 1;

    public ImageAnimation() {
        setTitle("Image Slider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null);

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String imagePath = "image" + currentIndex + ".jpg";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        imageLabel.setIcon(imageIcon);

        currentIndex++;
        if (currentIndex > 3) {
            currentIndex = 1;
        }
    }

    public static void main(String[] args) {
        new ImageAnimation().setVisible(true);
    }
}