package com.expohub.ui;

import com.expohub.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("Expohub - Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Select an Event Category:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JButton birthdayButton = new JButton("Birthday");
        birthdayButton.setBounds(10, 50, 150, 25);
        panel.add(birthdayButton);

        birthdayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VenueSelection().setVisible(true);
                dispose();
            }
        });

        JButton weddingButton = new JButton("Wedding");
        weddingButton.setBounds(10, 80, 150, 25);
        panel.add(weddingButton);

        weddingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VenueSelection().setVisible(true);
                dispose();
            }
        });
    }
    public void addEvent(String eventName, String eventType) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "INSERT INTO Events (event_name, event_type) VALUES (?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, eventName);
                pst.setString(2, eventType);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Event added successfully!");
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
