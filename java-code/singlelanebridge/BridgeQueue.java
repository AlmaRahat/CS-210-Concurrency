import java.util.LinkedList;
import java.util.Queue;
public class BridgeQueue {
    private Queue<Integer> westQueue;
    private Queue<Integer> eastQueue;
    private int westCount;
    private int eastCount;
    BridgeQueue(){
        westQueue = new LinkedList<Integer>();
        eastQueue = new LinkedList<Integer>();
        westCount = 0;
        eastCount = 0;
    }
    public synchronized void westEnter() 
            throws InterruptedException{
        while (eastCount > 0)
                wait();
        westCount += 1;
        westQueue.add(westCount);
        System.out.println("Added to the west queue: " + westCount);
    }
    public synchronized void westExit(){
        System.out.println("Removed from the west queue: " + westCount);
        westCount -= 1;
        westQueue.remove();
        notifyAll();
    }
    public synchronized void eastEnter() 
            throws InterruptedException{
        while (westCount > 0)
                wait();
        eastCount += 1;
        eastQueue.add(eastCount);
        System.out.println("Added to the east queue: " + eastCount);
    }
    public synchronized void eastExit(){
        System.out.println("Removed from the east queue: " + eastCount);
        eastCount -= 1;
        eastQueue.remove();
        notifyAll();
    }
}
