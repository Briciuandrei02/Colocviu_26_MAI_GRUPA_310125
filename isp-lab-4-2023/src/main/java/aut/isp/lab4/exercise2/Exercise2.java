package aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Acme Corp.", "Model A");
        System.out.println(fishFeeder);
        fishFeeder.fillUp();
        System.out.println(fishFeeder);
        fishFeeder.feed();
        fishFeeder.feed();

        fishFeeder.feed();
        fishFeeder.fillUp();
    }
}
