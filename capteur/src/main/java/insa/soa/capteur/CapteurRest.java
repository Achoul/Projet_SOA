package insa.soa.capteur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import insa.soa.Methodes.Sensor;
import insa.soa.Methodes.horloge;
import insa.soa.Methodes.luminositeExterne;
import insa.soa.Methodes.luminositeInterne;
import insa.soa.Methodes.presence;
import insa.soa.Methodes.temperatureExterne;
import insa.soa.Methodes.temperatureInterne;

@RestController
@RequestMapping("/Capteur")
public class CapteurRest {
	
    private List<Sensor> sensors;
    
    
    public final horloge clock;
    
    @Autowired
    public CapteurRest(horloge clock) {
        // Initialize sensors
        sensors = new ArrayList<>();
        sensors.add(new luminositeExterne(1));
        sensors.add(new luminositeInterne(1));
        sensors.add(new presence(1));
        sensors.add(new temperatureExterne(1));
        sensors.add(new temperatureInterne(1));
        
        this.clock = clock;
    }

    // General GET method to return all sensors
    @GetMapping("/all")
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.ok(sensors);  // Returns HTTP 200 OK with the list of sensors
    }
    
    @GetMapping("/test")
    public String test() {
        return "cool raoul" ;  // Returns HTTP 200 OK with the list of sensors
    }
    
    // Specific GET method to retrieve a sensor by ID and type
    @GetMapping("/{type}/{id}")
    public ResponseEntity<Sensor> getSensorByIdAndType(
            @PathVariable String type,  // Path variable for sensor type
            @PathVariable int id) {     // Path variable for sensor ID
    		String timestamp = clock.getCurrentDate(); //timestamp for SQL log
    		int value;
    	
        // Look for a sensor that matches both the type and the ID
        for (Sensor sensor : sensors) {
            if (sensor.getType().equalsIgnoreCase(type) && sensor.getId() == id) {
            	value = sensor.getValue();
                return ResponseEntity.ok()
                		.header("X-Timestamp", timestamp)
                		.header("X-Sensor-Value", String.valueOf(value))
                		.body(sensor)
                		;  // If found, return the sensor
            }
        }

        // If no sensor is found, return HTTP 404 Not Found
        return ResponseEntity.notFound().build();
    }
    
    
}



