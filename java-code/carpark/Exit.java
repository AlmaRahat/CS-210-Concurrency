/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aamr201
 */
public class Exit implements Runnable{
    Controller controller;
    private int sleepScaler = 1000;
    private String name;
    Exit (Controller controller, String name){
        this.controller = controller;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                double random = Math.random();
                Thread.sleep((long) (random*sleepScaler));
                controller.leave();
                System.out.println(name + " depart: " + controller.getSpaces());

            } catch (InterruptedException ex) {
                System.out.println("Interrupted Departure Thread");
                return;
            }
        }
    }

}
