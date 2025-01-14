package insa.soa.Methodes;

import java.util.Random;

 public class presence extends Sensor {
    // Constructor to initialize the id
    public presence(int id) {
    	super(id, "Presence");
    }
    
    @Override
    public int getValue() {
    	boolean isPresence = false;
    	int randint = 0;
    	
        Random random = new Random();
        randint = random.nextInt(2); // 0 (inclusive) to 2 (exclusive)
        
        return randint;
    }
   
}