/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.Semaphore;

/**
 *
 * @author aamr201
 */
public class CarParkApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller(4);
        Entrance entrance = new Entrance(controller, "In");
        Exit exit = new Exit(controller, "Out");
        Thread arrThread = new Thread(entrance);
        Thread depThread = new Thread(exit);
        arrThread.start();
        depThread.start();
        Thread.sleep(5*10000);
        arrThread.interrupt();
        arrThread.join();
        depThread.interrupt();
        depThread.join();
    }

}
