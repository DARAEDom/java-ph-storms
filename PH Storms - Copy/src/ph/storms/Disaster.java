package ph.storms;


public abstract class Disaster {
    
    protected int windSpeed;
    protected int temperature;
    protected String name;
    
    public Disaster(String nameIn, int windSpeedIn, int temperatureIn) {
        windSpeed = windSpeedIn;
        temperature = temperatureIn;
        name = nameIn;
    }

    public abstract String classification();
    
    public abstract String advice();
    
    public abstract String kindOfDisaster();

    public double getWindSpeed() {
        return windSpeed;
    }

    public int getTemperature() {
        return temperature;
    }
    
    public String getName() {
        return name;
    }

    public void setWindSpeed(int windSpeedIn) {
        windSpeedIn = windSpeed;
    }

    public void setTemperature(int temperatureIn) {
        temperatureIn = temperature;
    }

    public void setName(String nameIn) {
        nameIn = name;
    }
    
    
}
