package pract22.CalculatorMVC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorView view;
    private PostfixCalculator model;

    public CalculatorController(CalculatorView view, PostfixCalculator model) {
        this.view = view;
        this.model = model;

        view.addNumberButtonListener(new NumberButtonListener());
        view.addFunctionButtonListener(new FunctionButtonListener());
    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == view.numberButtons[i]) {
                    view.setTextFieldText(view.getTextFieldText() + i);
                }
            }
        }
    }

    private class FunctionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.addButton ||
                    e.getSource() == view.subtractButton ||
                    e.getSource() == view.multiplyButton ||
                    e.getSource() == view.divideButton) {
                String currentText = view.getTextFieldText();
                view.setTextFieldText(currentText + String.valueOf(((JButton) e.getSource()).getText()));
            } else if (e.getSource() == view.equalsButton) {
                String[] expression = view.getTextFieldText().split(" ");
                for (String token : expression) {
                    model.processToken(token);
                }
                double result = model.getResult();
                view.setTextFieldText(String.valueOf(result));
            } else if (e.getSource() == view.clearButton) {
                view.setTextFieldText("");
            } else if (e.getSource() == view.deleteButton) {
                String currentText = view.getTextFieldText();
                if (!currentText.isEmpty()) {
                    view.setTextFieldText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (e.getSource() == view.decimalButton) {
                String currentText = view.getTextFieldText();
                if (currentText.matches(".*\\d+$")) {
                    String[] tokens = view.getTextFieldText().split(" ");
                    String cuurentToken = tokens[tokens.length - 1];
                    if (!cuurentToken.contains(".")) {
                        view.setTextFieldText(currentText + ".");
                    }
                }
            } else if (e.getSource() == view.spaceButton) {
                String currentText = view.getTextFieldText();
                if (!currentText.endsWith(" ")) {
                    view.setTextFieldText(currentText + " ");
                }
            }
        }
    }
}

