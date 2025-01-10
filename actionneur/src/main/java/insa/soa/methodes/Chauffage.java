package insa.soa.methodes;

public class Chauffage {
    private int temperature;

    public Chauffage() {
        this.temperature = 20; // Température par défaut.
    }

    public void augmenterTemperatureChauf(int increment) {
        this.temperature += increment;
        System.out.println("La température du chauffage est augmentée à : " + this.temperature + "°C.");
    }

    public void diminuerTemperatureChauf(int decrement) {
        this.temperature -= decrement;
        System.out.println("La température du chauffage est diminuée à : " + this.temperature + "°C.");
    }

    public int getTemperature() {
        return temperature;
    }
}
