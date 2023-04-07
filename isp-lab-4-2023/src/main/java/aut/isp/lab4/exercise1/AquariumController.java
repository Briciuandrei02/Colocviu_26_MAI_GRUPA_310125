package aut.isp.lab4.exercise1;
public class AquariumController {

    // attributes
    private String manufacturer;
    private String model;
    private float currentTime;

    // constructors
    public AquariumController(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
    }

    // methods
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }
}

