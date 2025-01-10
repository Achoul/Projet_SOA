package insa.soa.capteur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Capteur")
public class CapteurRest {

    @PostMapping("/execute")
    public ResponseEntity<String> executeAction(@RequestBody String command) {
   
        System.out.println("Received command: " + command);
        return ResponseEntity.ok("Action executed: " + command);
    }
}