package isp.lab4.exercise2;

// SmartPhone.java
public class SmartPhone implements Chargeable {
    private int batteryLevel;

    public SmartPhone() {
        batteryLevel = 0;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void charge(int durationInMinutes) {
        batteryLevel += durationInMinutes / 5;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }
}
