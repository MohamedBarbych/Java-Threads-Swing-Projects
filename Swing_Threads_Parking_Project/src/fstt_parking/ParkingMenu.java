package fstt_parking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingMenu extends JFrame {
    public ParkingMenu() {
        setTitle("Parking Simulator Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2500, 1000);
        setLocationRelativeTo(null);
        setResizable(false);

        // Créer un JPanel personnalisé pour le fond
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dessiner l'image de fond
                ImageIcon backgroundImage = new ImageIcon("src/img/background.jpg");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Utiliser une disposition en superposition pour les composants
        backgroundPanel.setLayout(new BorderLayout());

        // Créer le panneau principal pour le texte et les boutons
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Créer le panneau de texte avec le JLabel
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(Color.BLUE); // Définir le fond du panneau en bleu

        JLabel descriptionLabel = new JLabel("Bienvenue dans le simulateur de parking");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionLabel.setForeground(Color.WHITE); // Définir la couleur du texte en blanc

// Ajouter le JLabel au centre du panneau de texte
        textPanel.add(descriptionLabel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Commencer la simulation");
        JButton exitButton = new JButton("Quitter");
        buttonPanel.setOpaque(false); // Rendre le panel transparent

        // Personnalisation des boutons
        startButton.setBackground(Color.BLUE); // Fond bleu
        startButton.setForeground(Color.WHITE); // Texte blanc
        exitButton.setBackground(Color.BLUE); // Fond bleu
        exitButton.setForeground(Color.WHITE); // Texte blanc

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Démarrer la simulation
                dispose(); // Fermer le menu
                startSimulation();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);


        mainPanel.add(backgroundPanel);

        // Ajouter le texte au centre du panneau principal
        mainPanel.add(textPanel, BorderLayout.CENTER);
        // Ajouter les boutons en bas du panneau principal
        add(buttonPanel, BorderLayout.SOUTH);
        // Ajouter le panneau principal au panneau de fond
//        backgroundPanel.add(mainPanel);

        // Ajouter le panneau de fond à la fenêtre
        add(backgroundPanel);

        setVisible(true);
    }

    private void startSimulation() {
        main.main(new String[]{});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ParkingMenu();
            }
        });
    }
}
