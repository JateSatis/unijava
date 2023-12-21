package pract5;

import javax.swing.*;

public class CLineImage extends JFrame {

    public CLineImage(String imagePath) {
        setTitle("Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 901);
        setLocationRelativeTo(null);
        JLabel clineImage = new JLabel();
        add(clineImage);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        clineImage.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        CLineImage imageDisplay = new CLineImage(args[0]);
        imageDisplay.setVisible(true);
    }
}