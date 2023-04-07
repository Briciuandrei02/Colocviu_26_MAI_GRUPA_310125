package isp.lab4.exercise2;

// SmartWatch.java
public class SmartWatch implements Chargeable {
    private int batteryLevel;

    public SmartWatch() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        batteryLevel += durationInMinutes / 2;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }
}
