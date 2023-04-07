package aut.isp.lab4.exercise4;

// Clasa principala care contine metoda main
public class Exercise4 {
    public static void main(String[] args) {
        // Instantierea unui nou FishFeeder si AquariumLighting si pasarea lor ca parametri la constructorul AquariumController
        AquariumController controller = new AquariumController("Fluval", "10531", new FishFeeder("Eheim", "3581"), new AquariumLighting());

        // Setarea momentului de hranire si momentelor de aprindere/oprire a luminii
        controller.setFeedingTime(9.0f);
        controller.setLightOnTime(8.0f);
        controller.setLightOffTime(16.0f);

        // Afisarea informatiilor din controller
        System.out.println(controller);

        // Simularea timpului curent si afisarea informatiilor din controller la fiecare pas
        controller.setCurrentTime(7.0f);
        System.out.println(controller);

        controller.setCurrentTime(8.0f);
        System.out.println(controller);

        controller.setCurrentTime(9.0f);
        System.out.println(controller);

        controller.setCurrentTime(16.0f);
        System.out.println(controller);

        controller.setCurrentTime(17.0f);
        System.out.println(controller);
    }
}

// Clasa care controleaza acvariu
class AquariumController {
    // Variabilele membru
    private FishFeeder feeder;
    private AquariumLighting lighting;
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private float lightOnTime;
    private float lightOffTime;

    // Constructorul
    public AquariumController(String manufacturer, String model, FishFeeder feeder, AquariumLighting lighting) {
        // Initializarea variabilelor membru
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.lighting = lighting;
    }

    // Metoda care actualizeaza timpul curent si controleaza hranirea si lumina
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feed();
        }
        if (this.currentTime == this.lightOnTime) {
            this.lighting.turnOn();
        }
        if (this.currentTime == this.lightOffTime) {
            this.lighting.turnOff();
        }
    }

    // Metode de setare pentru momentul de hranire si momentele de aprindere/oprire a luminii
    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    // Metoda de hranire a pestilor
    public void feed() {
        this.feeder.feed();
    }

    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", feeder=" + feeder +
                ", lighting=" + lighting +
                ", currentTime=" + currentTime +
                ", feedingTime=" + feedingTime +
                ", lightOnTime=" + lightOnTime +
                ", lightOffTime=" + lightOffTime +
                '}';
    }
}

class FishFeeder {
    private String manufacturer;
    private String model;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void feed() {
        System.out.println("Feeding fish with " + this.manufacturer + " " + this.model);
    }

    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

class AquariumLighting {
    private boolean isOn;

    public AquariumLighting() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public String toString() {
        return "AquariumLighting{";
    }
}