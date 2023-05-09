package isp.lab10.raceapp;

import isp.lab10.racedemo.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel();

        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();


        frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500, 300);
        frame.setVisible(true);

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);

        semaphoreThread.join();
        PlaySound play = new PlaySound();
        play.playSound();

        car1.start();
        car2.start();
        car3.start();
        car4.start();

        car1.join();
        car2.join();
        car3.join();
        car4.join();

        play.stopSound();
        List<CarDurations> carDurations=new ArrayList<>();

    }


}