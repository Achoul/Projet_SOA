package insa.soa.Methodes;

import java.util.Random;

public class temperatureInterne extends Sensor {
    // Method to get a random number between 0 and 100
	int id;
	
    // Constructor to initialize the id
    public temperatureInterne(int id) {
    	super(id, "TemperatureInterne");
    }
    // Method to get a random number between 0 and 30
    public static int getLumExterne() {
    	
    	int randInt;
        Random random = new Random();
        randInt = random.nextInt(31); // 0 (inclusive) to 101 (exclusive)
        return randInt;
    }
}