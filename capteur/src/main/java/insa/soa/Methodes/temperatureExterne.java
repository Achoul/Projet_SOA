package insa.soa.Methodes;

import java.util.Random;

<<<<<<< HEAD
public class temperatureExterne {
    // Method to get a random number between 0 and 100
=======
public class temperatureExterne extends Sensor {
    // Method to get a random number between 0 and 100
	int id;
	
    // Constructor to initialize the id
    public temperatureExterne(int id) {
    	super(id, "TemperatureExterne");
    }
    // Method to get a random number between -50 and 50
>>>>>>> H
    public static int getLumExterne() {
    	int randInt;
        Random random = new Random();
        randInt = random.nextInt(101); // 0 (inclusive) to 101 (exclusive)
        return randInt -50;
    }
}