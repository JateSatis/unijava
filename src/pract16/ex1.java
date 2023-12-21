package pract16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ex1 {
    public static int random = new Random().nextInt(20);
    public static int attemptCount = 3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Игра угадайка");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBounds(50, 150, 300, 100);

        JTextArea text = new JTextArea("Введите число от 0 до 20. У вас осталось " + attemptCount + " попытки");
        JTextField number = new JTextField();
        JButton input = new JButton("Проверить число");

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attemptCount != 0) {
                    int userNumber = Integer.parseInt(number.getText());
                    if (userNumber > random) {
                        text.setText("Ваше число больше загаданного, попробуйте еще раз. У вас осталось " + attemptCount + " попытки");
                        attemptCount--;
                    } else if (userNumber < random) {
                        text.setText("Ваше число меньше загадонного, попробуйте еще раз. У вас осталось " + attemptCount + " попытки");
                        attemptCount--;
                    } else {
                        text.setText("Вы угадали!");
                    }
                } else {
                    text.setText("Вы не успели угадать число за 3 попытки!");
                }
            }
        });

        panel.add(text);
        panel.add(number);
        panel.add(input);
        frame.add(panel);

        frame.validate();
        frame.repaint();
    }
}
