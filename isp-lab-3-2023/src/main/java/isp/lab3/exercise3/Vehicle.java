public class Vehicle {
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    private static int numberOfVehicles = 0;

    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        numberOfVehicles++;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    public static int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle v = (Vehicle) o;
        return v.model.equals(model) && v.type.equals(type) && v.speed == speed && v.fuelType == fuelType;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle v2 = new Vehicle("BMW", "X5", 220, 'D');

        // Test getters and setters
        System.out.println(v1.getModel());  // Dacia
        v1.setModel("Renault");
        System.out.println(v1.getModel());  // Renault
        System.out.println(v2.getSpeed());  // 220
        v2.setSpeed(250);
        System.out.println(v2.getSpeed());  // 250

        // Test equals method
        System.out.println(v1.equals(v2));  // false
        Vehicle v3 = new Vehicle("Dacia", "Logan", 150, 'B');
        System.out.println(v1.equals(v3));  // true

        // Test static attribute and method
        System.out.println(Vehicle.getNumberOfVehicles());  // 3
        Vehicle v4 = new Vehicle("Ford", "Focus", 180, 'B');
        System.out.println(Vehicle.getNumberOfVehicles());  // 4

        // Test toString method
        System.out.println(v1.toString());  // Renault (Logan) speed 150 fuel type B
    }
}
