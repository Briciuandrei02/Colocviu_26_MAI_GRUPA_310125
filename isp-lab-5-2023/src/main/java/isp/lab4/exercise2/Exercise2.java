package isp.lab4.exercise2;

import isp.lab4.exercise2.Chargeable;

// Exercise2.java
public class Exercise2 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        SmartPhone smartPhone = new SmartPhone();
        SmartWatch smartWatch = new SmartWatch();

        laptop.charge(30);
        smartPhone.charge(20);
        smartWatch.charge(10);

        System.out.println("Laptop battery level: " + laptop.getBatteryLevel());
        System.out.println("SmartPhone battery level: " + smartPhone.getBatteryLevel());
        System.out.println("SmartWatch battery level: " + smartWatch.getBatteryLevel());
    }
}
