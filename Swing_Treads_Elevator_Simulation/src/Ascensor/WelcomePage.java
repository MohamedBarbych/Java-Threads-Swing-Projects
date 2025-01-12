package Ascensor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        setTitle("Welcome");
        setSize(1800, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImagePanel backgroundPanel = new ImagePanel("images/background.png");
        backgroundPanel.setLayout(new BorderLayout());


        JLabel welcomeMessage = new JLabel("", JLabel.CENTER);
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeMessage.setForeground(Color.WHITE);
        backgroundPanel.add(welcomeMessage, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setOpaque(false);


        JButton startButton = new JButton("Start");
        styleButton(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new AscensorInterface().setVisible(true);
                    }
                });

                dispose();
            }
        });

        JButton exitButton = new JButton("Exit");
        styleButton(exitButton);
        exitButton.addActionListener(e -> System.exit(0));

        // Add both buttons to the button panel
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);

        // Add the button panel at the bottom of the main background panel
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the entire background panel to the frame
        add(backgroundPanel);
    }

    // Helper method to style the buttons
    private void styleButton(JButton button) {
        button.setBackground(Color.BLUE); // Blue background
        button.setForeground(Color.WHITE); // White text
        button.setFont(new Font("Arial", Font.BOLD, 30)); // Font style
    }

    // Inner class to handle background image painting
    class ImagePanel extends JPanel {
        private Image backgroundImage;

        // Constructor to load the background image
        public ImagePanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image scaled to fit the panel
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    // Main method to display the welcome page
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Create and show the welcome page
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomePage().setVisible(true);
            }
        });
    }
}
