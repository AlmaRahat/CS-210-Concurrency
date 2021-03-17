/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlelanebridge;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author aamr201
 */
public class BridgeQueueFixed {
    private Queue<Integer> westQueue;
    private Queue<Integer> eastQueue;
    private int westCount;  // west car on bridge
    private int eastCount;  // east car on bridge 
    private int westWaitCount;  // west car waiting
    private int eastWaitCount;  // east car waiting
    private boolean isWestTurn; // whose turn is it?
    BridgeQueueFixed(){
        westQueue = new LinkedList<Integer>();
        eastQueue = new LinkedList<Integer>();
        westCount = 0;
        eastCount = 0;
        westWaitCount = 0;
        eastWaitCount = 0;
        isWestTurn = true;
    }
    public synchronized void westEnter() 
            throws InterruptedException{
        westWaitCount += 1;
        while (eastCount > 0 || (eastWaitCount>0 && !isWestTurn))
                wait();
        westCount += 1;
        westWaitCount += 1;
        westQueue.add(westCount);
        System.out.println("Added to the west queue: " + westCount);
        notifyAll();
    }
    public synchronized void westExit(){
        System.out.println("Removed from the west queue: " + westCount);
        westCount -= 1;
        westQueue.remove();
        isWestTurn = false; // let east use the bridge
        notifyAll();
    }
    public synchronized void eastEnter() 
            throws InterruptedException{
        eastWaitCount += 1;
        while (westCount > 0 || (westWaitCount>0 && isWestTurn))
                wait();
        eastCount += 1;
        eastWaitCount -= 1;
        eastQueue.add(eastCount);
        System.out.println("Added to the east queue: " + eastCount);
        notifyAll();
    }
    public synchronized void eastExit(){
        System.out.println("Removed from the east queue: " + eastCount);
        eastCount -= 1;
        eastQueue.remove();
        isWestTurn = true; // let west use the bridge
        notifyAll();
    }
}
