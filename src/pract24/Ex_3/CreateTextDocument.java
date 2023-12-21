package pract24.Ex_3;

import javax.swing.*;
import java.io.*;

public class CreateTextDocument implements ICreateDocument{
    @Override
    public IDocument createNew(JTextArea textArea) {
        textArea.setText("");
        return new TextDocument();
    }

    @Override
    public void saveNew(JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public IDocument createOpen(JTextArea textArea) {
        TextDocument textDocument = new TextDocument();
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String fileName = fileChooser.getSelectedFile().getName();
                BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                String line;
                while ((line = reader.readLine()) != null) {
                    textDocument.addLine(line);
                }
                textDocument.name = fileName;
                textArea.setText(textDocument.getText().toString());

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return textDocument;
    }
}
