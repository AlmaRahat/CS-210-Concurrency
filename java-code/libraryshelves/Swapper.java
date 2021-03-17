import java.util.Random;
public class Swapper implements Runnable{
    private Shelf shelfA;
    private Shelf shelfB;
    private String name;
    Swapper(String name, Shelf shelfA, Shelf shelfB){
        this.name = name;
        this.shelfA = shelfA;
        this.shelfB = shelfB;
    }
    @Override
    public void run() {
        Random random = new Random();
        int randomInt = 0;
        int randomIndA = 0;
        int randomIndB = 0;
        while(true){
            try {
                randomInt = random.nextInt(1000); // upto 1 sec
                Thread.sleep(randomInt);
                randomIndA = random.nextInt(shelfA.getCapacity());
                randomIndB = random.nextInt(shelfB.getCapacity());
                System.out.println(name + " is trying to acquire " + shelfA.getId());
                shelfA.acquire();
                System.out.println(name + " is trying to acquire " + shelfB.getId());
                shelfB.acquire();
                shelfA.swap(shelfB, randomIndA, randomIndB);
                System.out.println(name + " completed swap.");
                shelfA.release();
                shelfB.release();
                System.out.println(name + " has released the shelves.");
            } catch (InterruptedException ex) {
                System.out.println("Thread Interrupted.");
                break;
            }
        }
    }    
}
