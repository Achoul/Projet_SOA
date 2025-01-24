package insa.soa.Methodes;

import java.util.Random;

import insa.soa.util.SQL_connector;

public class luminositeInterne extends Sensor {
	
    // Constructor to initialize the id
    public luminositeInterne(int id) {
        super(id, "LuminositeInterne");
    }

    // Method to get a random number between 0 and 100
    @Override
    public int getValue() {
        Random random = new Random();
        int lum = random.nextInt(101);
        
        // Database connection details
        String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_038";
        String username = "projet_gei_038";
        String password = "Seek3kei";
        String driverClassName = "com.mysql.cj.jdbc.Driver";

        // Initialize SQL_connector
        SQL_connector sqlConnector = new SQL_connector(url, username, password, driverClassName);

        // Insert a new record into the Sensor_values table
        int rowsAffected = sqlConnector.insertSensorValue(this.getId(), this.getType(), lum);
        if (rowsAffected > 0) {
            System.out.println("Base de donnée sollicitée pour la luminosité intérieure");
        }
        return lum; // 0 (inclusive) to 101 (exclusive)
    }
   
}