package com.expohub.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import com.expohub.DatabaseConnection;

public class LoginScreen extends JFrame {
    JTextField emailField;
    JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Expohub - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 20, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 20, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticateUser(emailField.getText(), new String(passwordField.getPassword()));
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 80, 80, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegistrationScreen().setVisible(true);
                dispose();
            }
        });
    }

    private void authenticateUser(String email, String password) {
        Connection conn = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                new Dashboard().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
        login.setVisible(true);
    }
}
