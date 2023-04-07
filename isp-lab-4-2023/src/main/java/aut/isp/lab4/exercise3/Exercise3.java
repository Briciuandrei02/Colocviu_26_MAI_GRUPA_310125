package aut.isp.lab4.exercise3;


public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Acme Corp.", "Model A");
        AquariumController aquariumController = new AquariumController("Acme Corp.", "Aquarium 1", fishFeeder);

        System.out.println(aquariumController); // should print "AquariumController{manufacturer='Acme Corp.', model='Aquarium 1', feeder=FishFeeder{manufacturer='Acme Corp.', model='Model A', meals=0}, currentTime=0.0, feedingTime=0.0}"

        aquariumController.setFeedingTime(10.0f);
        aquariumController.setCurrentTime(8.0f); // should not print anything
        aquariumController.setCurrentTime(10.0f); // should print "Feeding fish. Remaining meals: 13"
        aquariumController.setCurrentTime(11.0f); // should print "Feeding fish. Remaining meals: 12"
    }
}