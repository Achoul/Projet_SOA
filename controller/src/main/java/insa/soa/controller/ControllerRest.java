package insa.soa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import insa.soa.Methodes.ActionActionneurs;

@RestController
@RequestMapping("/controller")
public class ControllerRest {

    private static RestTemplate restTemplate = new RestTemplate();

    // Variables pour stocker les données des capteurs
    private static int luminositeExterne;
    private static int luminositeInterne;
    private static int presence;
    private static int temperatureExterne;
    private static int temperatureInterne;

    // Trois variables pour stocker les dernières actions
    private static String lastAction1 = "";
    private static String lastAction2 = "";
    private static String lastAction3 = "";

    // Compteur pour suivre quelle variable mettre à jour
    private static int actionCounter = 1;

    public static String getLastAction1() {
        return lastAction1;  // Retourne la première action pour l'exemple
    }

    @PostMapping("/send-command")
    public ResponseEntity<String> sendCommandToActionneur() {
        String actionneurServiceUrl = "http://localhost:8082/actionneur/execute";
        String command = "test";

        ResponseEntity<String> response = restTemplate.postForEntity(actionneurServiceUrl, command, String.class);
        return ResponseEntity.ok("Command sent, Actionneur response: " + response.getBody());
    }

    public static void fetchDataFromCapteur() {
        try {
            System.out.println("Fetching data from Capteur...");

            String capteurUrl = "http://localhost:8083/Capteur/all";
            ResponseEntity<String> response = restTemplate.getForEntity(capteurUrl, String.class);

            System.out.println("Response received from Capteur: " + response.getBody());

            // Parse JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.getBody());

            // Extraire les valeurs des données des capteurs
            for (JsonNode node : rootNode) {
                String type = node.get("type").asText();
                int value = node.get("value").asInt();

                System.out.println("Processing sensor data - Type: " + type + ", Value: " + value);

                switch (type) {
                    case "LuminositeExterne":
                        luminositeExterne = value;
                        break;
                    case "LuminositeInterne":
                        luminositeInterne = value;
                        break;
                    case "Presence":
                        presence = value;
                        break;
                    case "TemperatureExterne":
                        temperatureExterne = value;
                        break;
                    case "TemperatureInterne":
                        temperatureInterne = value;
                        break;
                }
            }

            // Appel des fonctions d'actions
            String temperatureAction = ActionActionneurs.temperatureAction(temperatureInterne, temperatureExterne, false, false);
            System.out.println("Temperature action: " + temperatureAction);
            sendActionToActionneur(temperatureAction);

            String luminositeAction = ActionActionneurs.luminositeAction(luminositeInterne, luminositeExterne);
            System.out.println("Luminosite action: " + luminositeAction);
            sendActionToActionneur(luminositeAction);

            String presenceAction = ActionActionneurs.presenceAction(presence);
            System.out.println("Presence action: " + presenceAction);
            sendActionToActionneur(presenceAction);

        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération ou du traitement des données des capteurs : " + e.getMessage());
        }
    }

    public static void sendActionToActionneur(String action) {
        try {
            String actionneurUrl = "http://localhost:8082/actionneur/execute";
            ResponseEntity<String> response = restTemplate.postForEntity(actionneurUrl, action, String.class);
            System.out.println("Response from Actionneur: " + response.getBody());

            // En fonction du compteur, on met à jour la variable appropriée
            switch (actionCounter) {
                case 1:
                    lastAction1 = action;
                    break;
                case 2:
                    lastAction2 = action;
                    break;
                case 3:
                    lastAction3 = action;
                    break;
            }

            // Incrémenter le compteur et réinitialiser à 1 après avoir atteint 3
            actionCounter = (actionCounter % 3) + 1;
        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi de l'action à l'actionneur : " + e.getMessage());
        }
    }

	public static String getLastAction2() {
		return lastAction2;
	}

	public static String getLastAction3() {
		return lastAction3;
	}
}
