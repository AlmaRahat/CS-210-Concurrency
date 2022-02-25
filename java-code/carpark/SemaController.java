import java.util.concurrent.*;
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
        if (spacesLeft > 0)
            --spacesLeft;
        semaphore.release();
    }

    @Override
    public synchronized void leave()
        throws InterruptedException {
        while (spacesLeft < capacity){
            wait();
        }
        ++spacesLeft;
        notifyAll();
    }

}
