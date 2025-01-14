package insa.soa.Methodes;

import java.util.Random;

public class temperatureExterne extends Sensor {

    // Constructor to initialize the id
    public temperatureExterne(int id) {
    	super(id, "TemperatureExterne");
    }
    // Method to get a random number between -50 and 50
    @Override
    public int getValue() {
    	int randInt;
        Random random = new Random();
        randInt = random.nextInt(101); // 0 (inclusive) to 101 (exclusive)
        return randInt -50;
    }
}