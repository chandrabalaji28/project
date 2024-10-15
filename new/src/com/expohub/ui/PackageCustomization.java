package com.expohub.ui;

import com.expohub.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PackageCustomization extends JFrame {
    public PackageCustomization() {
        setTitle("Expohub - Customize Package");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Select Package Options:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JCheckBox foodBox = new JCheckBox("Food");
        foodBox.setBounds(10, 50, 100, 25);
        panel.add(foodBox);

        JCheckBox decorationBox = new JCheckBox("Decoration");
        decorationBox.setBounds(10, 80, 100, 25);
        panel.add(decorationBox);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(10, 110, 150, 25);
        panel.add(nextButton);

        nextButton.addActionListener(e -> {
            new PaymentGateway().setVisible(true);
            dispose();
        });
    }
    public void addPackage(String packageName, String details, double price) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "INSERT INTO Packages (package_name, details, price) VALUES (?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, packageName);
                pst.setString(2, details);
                pst.setDouble(3, price);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Package added successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

