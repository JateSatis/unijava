package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator {
    public int num1;
    public int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int multiply() {
        return this.num1 * this.num2;
    }

    public double divide() {
        if (num2 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double)num1 / (double)num2;
    }

    public int add() {
        return num1 + num2;
    }

    public int subtract() {
        return num1 - num2;
    }
}

public class ex1 {

    public static void main(String[] args) {
        Frame frame = new JFrame("Калькулятор");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

        TextField firstNumTF = new TextField();
        TextField secondNumTF = new TextField();
        TextField result = new TextField();
        firstNumTF.setBounds(50,50, 150,20);
        secondNumTF.setBounds(200, 50, 150, 20);
        result.setBounds(50, 300, 150, 20);


        Button add = new Button("Сложить");
        Button subtract = new Button("Вычесть");
        Button multiply = new Button("Умножить");
        Button divide = new Button("Разделить");
        add.setBounds(50,100,60,30);
        add.setSize(100,50);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNumTF.getText());
                int num2 = Integer.parseInt(secondNumTF.getText());
                result.setText(String.valueOf(new Calculator(num1, num2).add()));
            }
        });

        subtract.setBounds(200,100,60,30);
        subtract.setSize(100,50);
        subtract.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNumTF.getText());
                int num2 = Integer.parseInt(secondNumTF.getText());
                result.setText(String.valueOf(new Calculator(num1, num2).subtract()));
            }
        });

        multiply.setBounds(50,200,60,30);
        multiply.setSize(100,50);
        multiply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNumTF.getText());
                int num2 = Integer.parseInt(secondNumTF.getText());
                result.setText(String.valueOf(new Calculator(num1, num2).multiply()));
            }
        });

        divide.setBounds(200,200,60,30);
        divide.setSize(100,50);
        divide.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int num1 = Integer.parseInt(firstNumTF.getText());
                int num2 = Integer.parseInt(secondNumTF.getText());
                result.setText(String.valueOf(new Calculator(num1, num2).divide()));
            }
        });

        frame.add(firstNumTF);
        frame.add(secondNumTF);
        frame.add(result);
        frame.add(add);
        frame.add(subtract);
        frame.add(multiply);
        frame.add(divide);
    }
}
