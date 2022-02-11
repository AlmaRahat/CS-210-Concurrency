import java.util.logging.Level;
import java.util.logging.Logger;

public class Turnstile implements Runnable{
    private Counter people;

    public Turnstile(Counter people) {
        this.people = people;
    }

    @Override
    public void run() {
        double randomFactor;
        int waitingTime;
        for (int i=0; i< Garden.MAX; i++){
            randomFactor = Math.random();
            waitingTime = (int) Math.ceil(randomFactor * 10);
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException ex) {

            }
            people.increment();
        }
    }



}
