package insa.soa.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class ControllerApplication {

    public static void main(String[] args) {
        // Forcer le mode non headless
        System.setProperty("java.awt.headless", "false");

        // Lancer l'application Spring Boot
        SpringApplication.run(ControllerApplication.class, args);

        // Lancer l'interface graphique
        SwingUtilities.invokeLater(() -> new ControllerGUI());
    }
}
