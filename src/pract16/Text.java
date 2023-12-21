package pract16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Text extends JFrame {

    private final JTextArea textArea;

    public Text() {
        setTitle("Text Editor");
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        createMenus();

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createMenus() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu colorMenu = new JMenu("Color");
        JMenu fontMenu = new JMenu("Font");

        JMenuItem blueItem = new JMenuItem("Blue");
        blueItem.addActionListener(new ColorMenuItemListener(Color.BLUE));

        JMenuItem redItem = new JMenuItem("Red");
        redItem.addActionListener(new ColorMenuItemListener(Color.RED));

        JMenuItem blackItem = new JMenuItem("Black");
        blackItem.addActionListener(new ColorMenuItemListener(Color.BLACK));

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        JMenuItem timesNewRomanItem = new JMenuItem("Times New Roman");
        timesNewRomanItem.addActionListener(new FontMenuItemListener(new Font("Times New Roman", Font.PLAIN, 12)));

        JMenuItem msSansSerifItem = new JMenuItem("MS Sans Serif");
        msSansSerifItem.addActionListener(new FontMenuItemListener(new Font("MS Sans Serif", Font.PLAIN, 12)));

        JMenuItem courierNewItem = new JMenuItem("Courier New");
        courierNewItem.addActionListener(new FontMenuItemListener(new Font("Courier New", Font.PLAIN, 12)));

        fontMenu.add(timesNewRomanItem);
        fontMenu.add(msSansSerifItem);
        fontMenu.add(courierNewItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
    }

    private class ColorMenuItemListener implements ActionListener {
        private final Color color;

        public ColorMenuItemListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setForeground(color);
        }
    }

    private class FontMenuItemListener implements ActionListener {
        private final Font font;

        public FontMenuItemListener(Font font) {
            this.font = font;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setFont(font);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Text::new);
    }
}
