package insa.soa.Methodes;

import java.util.Random;

import insa.soa.util.SQL_connector;

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
        
        // Database connection details
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_038";
        String username = "projet_gei_038";
        String password = "Seek3kei";
        String driverClassName = "com.mysql.cj.jdbc.Driver";

        // Initialize SQL_connector
        SQL_connector sqlConnector = new SQL_connector(url, username, password, driverClassName);

        // Insert a new record into the Sensor_values table
        int rowsAffected = sqlConnector.insertSensorValue(this.getId(), this.getType(), randint);
        if (rowsAffected > 0) {
            System.out.println("Base de donnée sollicitée pour la présence");
        }
        
        return randint;
    }
   
}