package pract16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Password {
    public static HashMap<String, HashMap<String, String>> passwordManager = new HashMap<>();

    public static void fillPasswordManager() {
        HashMap<String, String> youtubePassword = new HashMap<>();
        youtubePassword.put("MrBeast", "iamthebest");
        passwordManager.put("youtube", youtubePassword);

        HashMap<String, String> twitterPassword = new HashMap<>();
        youtubePassword.put("Elon Musk", "iamtherichest");
        passwordManager.put("twitter", twitterPassword);

        HashMap<String, String> facebookPassword = new HashMap<>();
        youtubePassword.put("Mark Zuckerback", "iamthereptile");
        passwordManager.put("facebook", facebookPassword);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fillPasswordManager();

        JTextField serviceName = new JTextField();
        JTextField userName = new JTextField();
        JTextField password = new JTextField();


        serviceName.setBounds(150, 50, 200, 50);
        userName.setBounds(150, 150, 200, 50);
        password.setBounds(150, 250, 200, 50);

        frame.add(serviceName);
        frame.add(userName);
        frame.add(password);

        JLabel serviceLabel = new JLabel("Service: ");
        JLabel userLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        serviceLabel.setBounds(50, 50, 80, 50);
        userLabel.setBounds(50, 150, 80, 50);
        passwordLabel.setBounds(50, 250, 80, 50);

        frame.add(serviceLabel);
        frame.add(userLabel);
        frame.add(passwordLabel);

        JButton checkPassword = new JButton("Log in");

        checkPassword.setBounds(100, 310, 200, 50);

        checkPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordManager.containsKey(serviceName.getText())) {
                    HashMap<String, String> passwordMap = passwordManager.get(serviceName.getText());
                    if (passwordMap.containsKey(userName.getText())) {
                        if (Objects.equals(passwordMap.get(userName.getText()), password.getText())) {
                            JOptionPane.showMessageDialog(null, "Пароль верный!");
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Пароль неверный!");
            }
        });

        frame.add(checkPassword);

        frame.validate();
        frame.repaint();
    }
}