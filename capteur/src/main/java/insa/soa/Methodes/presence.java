package insa.soa.Methodes;

import java.util.Random;

<<<<<<< HEAD
public class presence {
    // Method to get a random number between 0 and 100

=======
public class presence extends Sensor {
	int id;
	
    // Constructor to initialize the id
    public presence(int id) {
    	super(id, "Presence");
    }
>>>>>>> H
	
    public static boolean getPresence() {
    	boolean isPresence = false;
    	int randint = 0;
    	
        Random random = new Random();
        randint = random.nextInt(1); // 0 (inclusive) to 1 (exclusive)
        
        if (randint == 0) {
        	isPresence = false;
        }
        else {
        	isPresence = true;
        }
        return isPresence;
    }
   
}