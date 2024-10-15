package com.expohub.ui;

import com.expohub.DatabaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentGateway extends JFrame {
    public PaymentGateway() {
        setTitle("Expohub - Payment Gateway");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Make a Payment:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JButton creditCardButton = new JButton("Pay with Credit Card");
        creditCardButton.setBounds(10, 50, 150, 25);
        panel.add(creditCardButton);

        JButton upiButton = new JButton("Pay with UPI");
        upiButton.setBounds(10, 80, 150, 25);
        panel.add(upiButton);

        JButton backButton = new JButton("Back to Dashboard");
        backButton.setBounds(10, 110, 200, 25);
        panel.add(backButton);

        // Action Listener for Credit Card Payment
        creditCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulate payment processing
                JOptionPane.showMessageDialog(null, "Payment Successful with Credit Card!");
                new Dashboard().setVisible(true); // Navigate to the Dashboard after payment
                dispose(); // Close the PaymentGateway window
            }
        });

        // Action Listener for UPI Payment
        upiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulate payment processing
                JOptionPane.showMessageDialog(null, "Payment Successful with UPI!");
                new Dashboard().setVisible(true); // Navigate to the Dashboard after payment
                dispose(); // Close the PaymentGateway window
            }
        });

        // Action Listener for Back Button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dashboard().setVisible(true); // Go back to the Dashboard
                dispose(); // Close the PaymentGateway window
            }
        });
    }

    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway();
        paymentGateway.setVisible(true);
    }
    public void addBooking(int userId, int venueId, int packageId, String eventDate, String paymentStatus) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            try {
                String query = "INSERT INTO Bookings (user_id, venue_id, package_id, event_date, payment_status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, userId);
                pst.setInt(2, venueId);
                pst.setInt(3, packageId);
                pst.setString(4, eventDate);
                pst.setString(5, paymentStatus);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Booking successful!");
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
