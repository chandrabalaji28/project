package com.expohub.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VenueSelection extends JFrame {
    public VenueSelection() {
        setTitle("Expohub - Select Venue");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Select a Venue:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JButton venue1Button = new JButton("Venue 1");
        venue1Button.setBounds(10, 50, 150, 25);
        panel.add(venue1Button);

        JButton venue2Button = new JButton("Venue 2");
        venue2Button.setBounds(10, 80, 150, 25);
        panel.add(venue2Button);

        // Add Action Listeners to the buttons to transition to the next page
        venue1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // After selecting the venue, navigate to Package Customization
                new PackageCustomization().setVisible(true); // Open the Package Customization window
                dispose(); // Close the VenueSelection window
            }
        });

        venue2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // After selecting the venue, navigate to Package Customization
                new PackageCustomization().setVisible(true); // Open the Package Customization window
                dispose(); // Close the VenueSelection window
            }
        });
    }

    public static void main(String[] args) {
        VenueSelection venueSelection = new VenueSelection();
        venueSelection.setVisible(true);
    }
}
