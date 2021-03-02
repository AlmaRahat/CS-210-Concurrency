/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.*;
/**
 *
 * @author aamr201
 */
public class SemaController extends Controller{
    private final Semaphore semaphore;

    SemaController(int n, Semaphore semaphore){
        super(n);
        this.semaphore = semaphore;
    }

    @Override
    public synchronized void enter()
        throws InterruptedException {
        semaphore.acquire();
        /*
        while (spaces == capacity){
            wait();
        }
        */
        if (spacesLeft < capacity)
            ++spacesLeft;
        semaphore.release();
    }

    @Override
    public synchronized void leave()
        throws InterruptedException {
        while (spacesLeft == 0){
            wait();
        }
        --spacesLeft;
        notifyAll();
    }

}
