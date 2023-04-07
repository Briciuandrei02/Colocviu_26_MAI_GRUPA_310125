package isp.lab4.exercise3;

import java.util.ArrayList;
import java.util.List;

public class MonitoringService {
    private List<Sensor> sensors = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    public double getAverageTemperatureSensors() {
        double sum = 0;
        int count = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                TemperatureSensor tempSensor = (TemperatureSensor) sensor;
                sum += tempSensor.getTemperature();
                count++;
            }
        }

        return sum / count;
    }

    public double getAverageAllSensors() {
        double sum = 0;

        for (Sensor sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                TemperatureSensor tempSensor = (TemperatureSensor) sensor;
                sum += tempSensor.getTemperature();
            } else if (sensor instanceof PressureSensor) {
                PressureSensor pressSensor = (PressureSensor) sensor;
                sum += pressSensor.getPressure();
            }
        }

        return sum / sensors.size();
    }
}
