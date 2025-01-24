package insa.soa.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerGUI {

    private JFrame frame;
    private JTextArea textArea;

    public ControllerGUI() {
        // Créer la fenêtre principale
        frame = new JFrame("Controller Application");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Ajouter une zone de texte pour afficher les résultats
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ajouter un bouton "Actualiser"
        JButton refreshButton = new JButton("Actualiser");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
            }
        });
        frame.add(refreshButton, BorderLayout.SOUTH);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    private void refreshData() {
        try {
            ControllerRest.fetchDataFromCapteur();

            // Récupérer les dernières actions
            String lastAction1 = ControllerRest.getLastAction1();
            String lastAction2 = ControllerRest.getLastAction2();
            String lastAction3 = ControllerRest.getLastAction3();

            // Afficher les résultats dans la JTextArea
            textArea.setText(""); // Réinitialiser la zone de texte avant de l'actualiser
            textArea.append("Dernière commande de température : " + lastAction1 + "\n");
            textArea.append("Dernière commande de lumière : " + lastAction2 + "\n");
            textArea.append("Dernière commande d'alarme : " + lastAction3 + "\n");
        }
        catch (Exception ex) {
            textArea.append("Erreur lors de l'actualisation : " + ex.getMessage() + "\n");
        }
    }
}
