package isp.lab4.exercise3;

public class PressureSensor implements Sensor {
    private double pressure;
    private String installLocation;
    private String name;

    public PressureSensor(String installLocation, String name) {
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

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
