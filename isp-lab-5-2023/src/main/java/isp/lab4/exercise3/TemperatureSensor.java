package isp.lab4.exercise3;

public class TemperatureSensor implements Sensor {
    private double temperature;
    private String installLocation;
    private String name;

    public TemperatureSensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }

    @Override
    public String getInstallLocation() {
        return installLocation;
    }

    @Override
    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
