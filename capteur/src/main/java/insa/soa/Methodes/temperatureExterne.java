package insa.soa.Methodes;

import java.util.Random;

public class temperatureExterne {
    // Method to get a random number between 0 and 100
    public static int getLumExterne() {
    	int randInt;
        Random random = new Random();
        randInt = random.nextInt(101); // 0 (inclusive) to 101 (exclusive)
        return randInt -50;
    }
}