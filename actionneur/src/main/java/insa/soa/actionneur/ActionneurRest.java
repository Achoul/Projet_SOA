package insa.soa.actionneur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actionneur")
public class ActionneurRest {

    @PostMapping("/execute")
    public String executeAction(@RequestBody String command) {
    	if ("test".equalsIgnoreCase(command.trim())) {
            System.out.println("test concluant");
            return "Action executed: test concluant";
        } else {
            System.out.println("Received command: " + command);
            return "Action executed: " + command;
        }
//        System.out.println("Received command: " + command);
//        return ResponseEntity.ok("Action executed: " + command);
    }
}