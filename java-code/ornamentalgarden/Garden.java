//package ornamentalgarden;

public class Garden {
    public static final int MAX = 100;
    private Counter counter;
    private boolean synchronised = false;
    private Turnstile west;
    private Turnstile east;

    public int getCount(){
        if (counter!=null)
            return counter.getValue();
        else
            return 0;
    }

    public void reset(){
        if (!synchronised){
            System.out.println("Running with faulty counter.");
            counter = new Counter();
        }
        else{
            System.out.println("Running with fixed counter.");
            counter = new SynchronisedCounter();
        }
        // create Turnstiles
        west = new Turnstile(counter);
        east = new Turnstile(counter);
    }

    public void go() throws InterruptedException{
        reset();
        // create threads
        Thread westThread = new Thread(west, "west");
        Thread eastThread = new Thread(east, "east");
        // start threads
        westThread.start();
        eastThread.start();
        // wait for threads to die
        westThread.join();
        eastThread.join();
    }

    void flipSynchronised() {
        this.synchronised = !this.synchronised;
    }
}
