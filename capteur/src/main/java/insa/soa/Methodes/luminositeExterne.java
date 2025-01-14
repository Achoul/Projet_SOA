package insa.soa.Methodes;

import java.util.Random;

<<<<<<< HEAD
public class luminositeExterne {
=======
public class luminositeExterne extends Sensor {
	int id;
	
    // Constructor to initialize the id
    public luminositeExterne(int id) {
        super(id, "LuminositeExterne");
    }
	
>>>>>>> H
    // Method to get a random number between 0 and 100
    public static int getLumExterne() {
        Random random = new Random();
        return random.nextInt(101); // 0 (inclusive) to 101 (exclusive)
    }
   
}