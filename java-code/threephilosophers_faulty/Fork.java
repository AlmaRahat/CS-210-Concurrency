public class Fork {
    private boolean isTaken = false;
    public synchronized void acquire() 
            throws InterruptedException{
        while (isTaken == true)
            wait();
        this.isTaken = true;
        // notify not necessary here.
    }
    public synchronized void release() 
            throws InterruptedException{
        this.isTaken = false;
        // better to use notifyAll rather than notify
        notifyAll(); 
    }
}
