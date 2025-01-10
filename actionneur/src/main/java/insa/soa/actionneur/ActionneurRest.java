package insa.soa.actionneur;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import insa.soa.methodes.Chauffage;
import insa.soa.methodes.Climatisation;
import insa.soa.methodes.Fenetre;

@RestController
@RequestMapping("/actionneur")
public class ActionneurRest {

    private final Fenetre fenetre = new Fenetre();
    private final Climatisation climatisation = new Climatisation();
    private final Chauffage chauffage = new Chauffage();
    
    @PostMapping("/execute")
    public String executeAction(@RequestBody String command) {
    	
    	// Gestion du Chauffage
        if ("TurnUpHeater".equalsIgnoreCase(command.trim())) {
            chauffage.augmenterTemperatureChauf(2); 
            return "Action executed: TurnUpHeater";
        } 
        if ("TurnDownHeater".equalsIgnoreCase(command.trim())) {
            chauffage.diminuerTemperatureChauf(2); 
            return "Action executed: TurnDownHeater";
        } 

        // Gestion des Fenêtres
        if ("OpenWindow".equalsIgnoreCase(command.trim())) {
            fenetre.ouvrirFenetre();
            return "Action executed: OpenWindow";
        } 
        if ("CloseWindow".equalsIgnoreCase(command.trim())) {
            fenetre.fermerFenetre();
            return "Action executed: CloseWindow";
        } 

        // Gestion de la Climatisation
        if ("TurnUpAC".equalsIgnoreCase(command.trim())) {
            climatisation.augmenterTemperatureClim(2); 
            return "Action executed: TurnUpAC";
        } 
        if ("TurnDownAC".equalsIgnoreCase(command.trim())) {
            climatisation.diminuerTemperatureClim(2); 
            return "Action executed: TurnDownAC";
        } 
        if ("NoAction".equalsIgnoreCase(command.trim())) {
            System.out.println("rien a faire");
            return "Action executed: rien a faire";
        }
    	
        
        
    	
    	if ("test".equalsIgnoreCase(command.trim())) {
            System.out.println("test concluant");
            return "Action executed: test concluant";
        } 
    	else {
            System.out.println("Received command: " + command);
            return "Action executed: " + command;
        }
//        System.out.println("Received command: " + command);
//        return ResponseEntity.ok("Action executed: " + command);
    }
}