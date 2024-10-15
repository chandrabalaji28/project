package com.expohub.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import com.expohub.DatabaseConnection;



public class RegistrationScreen extends JFrame {
    JTextField nameField, emailField;
    JPasswordField passwordField;

    public RegistrationScreen() {
        setTitle("Expohub - Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 50, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 80, 165, 25);
        panel.add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 110, 100, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser(nameField.getText(), emailField.getText(), new String(passwordField.getPassword()));
            }
        });
    }

    private void registerUser(String name, String email, String password) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) { // Check if the connection is not null
            try {
                String query = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, password);
                int rowsAffected = pst.executeUpdate(); // Execute the query

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                    new LoginScreen().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Print stack trace for debugging
            } finally {
                try {
                    conn.close(); // Close the connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed to connect to database.");
        }
    }


}
