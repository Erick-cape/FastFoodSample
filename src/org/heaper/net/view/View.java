package org.heaper.net.view;

import javax.swing.*;
import java.awt.*;

public class View {
    JFrame frame;

    public View(String frameName) {
        frame = new JFrame(frameName);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
    }

    public void setVisible(boolean setVisible) {
        frame.setVisible(setVisible);
    }

    public void refreshFrame() {
        frame.revalidate();
        frame.repaint();
    }

    public void turnButtonFlat(JButton button) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    public void drawInitPanel() {
        JPanel initPanel = new JPanel();
        initPanel.setLayout(new GridBagLayout());

        JButton loginButton = new JButton("LOGIN");
        JButton exitButton = new JButton("EXIT");

        turnButtonFlat(loginButton);
        turnButtonFlat(exitButton);

        loginButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        loginButton.setFont(new Font("Arial", Font.BOLD, 25));
        exitButton.setFont(new Font("Arial", Font.BOLD, 25));

        loginButton.addActionListener(e -> {
            drawLoginPanel();
            refreshFrame();
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        initPanel.add(loginButton, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 5, 10),
                0, 10));

        initPanel.add(exitButton, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 10 ,10, 10),
                0, 10));
        initPanel.setBackground(new Color(190, 190, 190));

        frame.getContentPane().removeAll();
        frame.add(initPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void drawLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());

        JLabel userLabel = new JLabel("User");
        JLabel passwordLabel = new JLabel("Password");
        JLabel errorLabel = new JLabel("Incorrect User or Password!");

        userLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        errorLabel.setForeground(new Color(204, 0, 0));
        errorLabel.setVisible(false);

        JTextField userField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);

        userField.setFont(new Font("Arial", Font.BOLD, 20));
        passwordField.setFont(new Font("Arial", Font.BOLD, 20));

        JButton loginButton = new JButton("LOGIN");

        turnButtonFlat(loginButton);
        loginButton.setFont(new Font("Roboto", Font.BOLD, 25));
        loginButton.addActionListener(e -> {
            errorLabel.setVisible(true);
            frame.pack();
            String stringUser = String.valueOf(userField.getText());
            String stringPassword = String.valueOf(passwordField.getPassword());
            System.out.println(stringUser + "\n" + stringPassword);
        });
        loginButton.setFocusPainted(false);

        loginPanel.add(userLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10,10,5,10),
                0, 0));
        loginPanel.add(userField, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5,10,5,10),
                0, 0));
        loginPanel.add(passwordLabel, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(1,10,1,10),
                0, 0));
        loginPanel.add(passwordField, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5,10,10,10),
                0, 0));
        loginPanel.add(errorLabel, new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 10, 10, 10),
                0, 0));
        loginPanel.add(loginButton, new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10,10,10,10),
                0, 10));
        loginPanel.setBackground(new Color(190, 190, 190));

        frame.getContentPane().removeAll();
        frame.add(loginPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
