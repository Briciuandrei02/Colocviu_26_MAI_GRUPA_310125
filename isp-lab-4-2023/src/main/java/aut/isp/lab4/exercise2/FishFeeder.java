package aut.isp.lab4.exercise2;

public class FishFeeder {
    private String manufacturer;
    private String model;
    private int meals;

    public FishFeeder(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 0;
    }

    public void feed() {
        if (meals > 0) {
            meals--;
            System.out.println("Hrănire pești. Mese rămase: " + meals);
        } else {
            System.out.println("Nu mai sunt mese.Va rog fillUp");
        }
    }

    public void fillUp() {
        meals = 14;
        System.out.println("Fish feeder filled up with 14 meals.");
    }

    public String toString() {
        return "FishFeeder{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", meals=" + meals +
                '}';
    }
}
