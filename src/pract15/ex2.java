package pract15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ex2 {
    public static void main(String[] args) {
        Frame frame = new Frame("Дропбокс");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);

        String[] countries = {"Australia", "China", "England", "Russia"};
        JComboBox<String> countriesDropBox = new JComboBox<>(countries);
        countriesDropBox.setBounds(50, 50, 100, 50);
        countriesDropBox.setSelectedItem("Australia");

        JLabel label = new JLabel();
        label.setBounds(50, 150, 300, 100);

        countriesDropBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = Objects.requireNonNull(countriesDropBox.getSelectedItem()).toString();
                if (selected.equals("Australia")) {
                    label.setText("Туда отправляли зеков из Америки");
                } else if (selected.equals("China")) {
                    label.setText("Я знаю как сказать что я из Америки на Китайском");
                } else if (selected.equals("England")) {
                    label.setText("У них недавно умерла королева");
                } else if (selected.equals("Russia")) {
                    label.setText("РОССИЯ ВПЕРЕД!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
            }
        } );

        frame.add(countriesDropBox);
        frame.add(label);
        frame.validate();
        frame.repaint();
    }
}
