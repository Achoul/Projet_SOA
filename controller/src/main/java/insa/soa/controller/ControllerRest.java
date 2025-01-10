package insa.soa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import insa.soa.Methodes.ActionActionneurs;
import insa.soa.Methodes.AnalyseRequest;

@RestController
@RequestMapping("/controller")
public class ControllerRest {

    @PostMapping("/send-command")
    public ResponseEntity<String> sendCommandToActionneur() {
        RestTemplate restTemplate = new RestTemplate();
        String ActionneurServiceUrl = "http://localhost:8082/actionneur/execute";

        String command = "test"; 

        ResponseEntity<String> response = restTemplate.postForEntity(ActionneurServiceUrl, command, String.class);
        
        return ResponseEntity.ok("Command sent, Actionneur response: " + response.getBody());
    }
    
    
    
    @PostMapping("/analyser")
    public String analyserDonnees(@RequestBody AnalyseRequest request) {
        
		// determineer l'action
		String action = ActionActionneurs.temperatureAction(request.getTint(), request.getText(), request.isClimActive(), request.isChauffageActive());

        if ("NoAction".equalsIgnoreCase(action)) {
            return "Aucune action nécessaire.";
        }

        // Envoi de l'action au service d'actionneur via API REST
        RestTemplate restTemplate = new RestTemplate();
        String actionneurUrl = "http://localhost:8082/actionneur/execute";
        ResponseEntity<String> response = restTemplate.postForEntity(actionneurUrl, action, String.class);

        return "Action envoyée à l'actionneur : " + response.getBody();
    }
}
