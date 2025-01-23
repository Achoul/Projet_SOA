package insa.soa.Methodes;

import java.util.Random;

import insa.soa.util.SQL_connector;

public class temperatureInterne extends Sensor {
    // Method to get a random number between 0 and 100
	int id;
	
    // Constructor to initialize the id
    public temperatureInterne(int id) {
    	super(id, "TemperatureInterne");
    }
    // Method to get a random number between 0 and 30
    @Override
    public int getValue() {
    	
    	int randInt;
        Random random = new Random();
        randInt = random.nextInt(31); // 0 (inclusive) to 101 (exclusive)
        
        // Database connection details
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_038";
        String username = "projet_gei_038";
        String password = "Seek3kei";
        String driverClassName = "com.mysql.cj.jdbc.Driver";

        // Initialize SQL_connector
        SQL_connector sqlConnector = new SQL_connector(url, username, password, driverClassName);

        // Insert a new record into the Sensor_values table
        int rowsAffected = sqlConnector.insertSensorValue(this.getId(), this.getType(), randInt);
        if (rowsAffected > 0) {
            System.out.println("Record inserted successfully!");
        }
        return randInt;
    }
}