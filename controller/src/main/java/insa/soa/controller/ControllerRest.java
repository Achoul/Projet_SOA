package insa.soa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
}
