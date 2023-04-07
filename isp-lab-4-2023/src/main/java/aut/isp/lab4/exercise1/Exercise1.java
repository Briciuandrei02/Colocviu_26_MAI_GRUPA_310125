package aut.isp.lab4.exercise1;

public class Exercise1 {

    public static void main(String[] args) {
        // create an object of AquariumController class
        AquariumController controller = new AquariumController("Acme", "AquariumMaster");
        System.out.println(controller.toString());

        controller.setCurrentTime(2.5f);
        System.out.println(controller.toString());
    }
}
