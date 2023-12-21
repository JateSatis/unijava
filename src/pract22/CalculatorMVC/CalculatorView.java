package pract22.CalculatorMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView {

    public JFrame frame;
    public JTextField textField;
    public JButton[] numberButtons;
    public JButton[] functionButtons;
    public JButton addButton, subtractButton, multiplyButton, divideButton;
    public JButton decimalButton, equalsButton, deleteButton, clearButton, spaceButton;
    public JPanel panel;

    public CalculatorView() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 25, 340, 50);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        functionButtons = new JButton[9];
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("Del");
        clearButton = new JButton("C");
        spaceButton  = new JButton("Space");

        functionButtons[0] = addButton;
        functionButtons[1] = subtractButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = spaceButton;

        panel = new JPanel();
        panel.setBounds(30, 100, 340, 340);
        panel.setLayout(new GridLayout(4, 5, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(clearButton);
        panel.add(deleteButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(spaceButton);

        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void addNumberButtonListener(ActionListener listener) {
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(listener);
        }
    }

    public void addFunctionButtonListener(ActionListener listener) {
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(listener);
        }
    }

    public String getTextFieldText() {
        return textField.getText();
    }

    public void setTextFieldText(String text) {
        textField.setText(text);
    }
}
