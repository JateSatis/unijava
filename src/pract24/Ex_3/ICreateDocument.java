package pract24.Ex_3;

//ФАБРИКА

import javax.swing.*;

public interface ICreateDocument {
    IDocument createNew(JTextArea textArea);
    void saveNew(JTextArea textArea);
    IDocument createOpen(JTextArea textArea);
}
