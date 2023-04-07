package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        MonitoringService monitoringService = new MonitoringService();

        TemperatureSensor tempSensor1 = new TemperatureSensor("Living room", "Living room sensor");
        tempSensor1.setTemperature(23.5);
        monitoringService.addSensor(tempSensor1);

        TemperatureSensor tempSensor2 = new TemperatureSensor("Bedroom", "Bedroom sensor");
        tempSensor2.setTemperature(21.0);
        monitoringService.addSensor(tempSensor2);

        PressureSensor pressSensor = new PressureSensor("Kitchen", "Kitchen sensor");
        pressSensor.setPressure(1008.2);
        monitoringService.addSensor(pressSensor);

        System.out.println("Temperatura medie: " + monitoringService.getAverageTemperatureSensors() + "°C");
        System.out.println("Senzorii in unitati: " + monitoringService.getAverageAllSensors() + " unitati");
    }
}
