package insa.soa.methodes;

public class Climatisation {
    private int temperature;

    public Climatisation() {
        this.temperature = 20; // Température par défaut.
    }

    public void augmenterTemperatureClim(int increment) {
        this.temperature += increment;
        System.out.println("La température de la climatisation est augmentée à : " + this.temperature + "°C.");
    }

    public void diminuerTemperatureClim(int decrement) {
        this.temperature -= decrement;
        System.out.println("La température de la climatisation est diminuée à : " + this.temperature + "°C.");
    }

    public int getTemperature() {
        return temperature;
    }
}
