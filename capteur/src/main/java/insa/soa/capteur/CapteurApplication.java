package insa.soa.capteur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import insa.soa.Methodes.luminositeExterne;
import insa.soa.Methodes.luminositeInterne;
import insa.soa.Methodes.presence;
import insa.soa.Methodes.temperatureExterne;
import insa.soa.Methodes.temperatureInterne;

@SpringBootApplication
public class CapteurApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(CapteurApplication.class, args);
	}

}
