package pract24.Ex_3;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    String name = "Application";
    private IDocument document; //TextDocument
    private ICreateDocument factory; //CreateTextDocument
    private JTextArea textArea;

    public Application(ICreateDocument factory) {
        super("Безымянный - Application");

        this.factory = factory;

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        createMenu();


        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> newDocument());

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> openDocument());

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> factory.saveNew(textArea));

        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
    }

    private void newDocument() {
        setTitle("Безымянный - Application");
        document = factory.createNew(textArea);
    }

    private void openDocument() {
        document = factory.createOpen(textArea);
        setTitle(document.getName() + " - " + name);
    }
}

class TestApp {
    public static void main(String[] args) {
        new Application(new CreateTextDocument());
    }
}
