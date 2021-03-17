import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WestCar implements Runnable {
    private BridgeQueue bridge;
    private String name;
    WestCar(String name, BridgeQueue bridge){
        this.bridge = bridge;
        this.name = name;
    }
    @Override
    public void run() {
        Random random = new Random();
        int randomInt = 0;
        while (true){
            try {
                System.out.println(name + " is adding to west queue.");
                bridge.westEnter();
                randomInt = random.nextInt(1000); // upto 1 sec
                Thread.sleep(randomInt);
                bridge.westExit();
                System.out.println(name + " has removed from west queue.");
                Thread.sleep(randomInt);
            } catch (InterruptedException ex) {
                System.out.println(name + " was interrupted. ");
                break;
            }
        }
    }
    
}
