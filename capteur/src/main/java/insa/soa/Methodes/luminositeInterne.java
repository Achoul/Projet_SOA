package insa.soa.Methodes;

import java.util.Random;

public class luminositeInterne extends Sensor {
	int id;
	
    // Constructor to initialize the id
    public luminositeInterne(int id) {
        super(id, "LuminositeInterne");
    }
    // Method to get a random number between 0 and 100
    public static int getLumInterne() {
        Random random = new Random();
        return random.nextInt(101); // 0 (inclusive) to 101 (exclusive)
    }
   
}