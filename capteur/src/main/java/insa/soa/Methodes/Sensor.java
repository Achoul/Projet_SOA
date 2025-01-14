package insa.soa.Methodes;

public abstract class Sensor {
    private int id;
    private String type;

    public Sensor(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    
    public abstract int getValue();
}
