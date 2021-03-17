public class LibraryShelves {
    public static void main(String[] args) 
            throws InterruptedException {
        Shelf shelfA= new Shelf(5, 98);
        Shelf shelfB= new Shelf(5, 54);
        Swapper sw1 = new Swapper("sw1", shelfA, shelfB);
        Swapper sw2 = new Swapper("sw2", shelfB, shelfA);
        Thread t1 = new Thread(sw1);
        Thread t2 = new Thread(sw2);
        t1.start();
        t2.start();
        Thread.sleep(10000);
        t1.interrupt();
        t2.interrupt();
        t1.join();
        t2.join();
    }    
}
