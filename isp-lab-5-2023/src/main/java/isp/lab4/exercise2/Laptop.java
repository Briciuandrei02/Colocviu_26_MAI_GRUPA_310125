package isp.lab4.exercise2;

// Laptop.java
public class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        batteryLevel += durationInMinutes / 10;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }
}
