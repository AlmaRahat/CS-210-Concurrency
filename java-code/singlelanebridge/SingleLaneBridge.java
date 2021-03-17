public class SingleLaneBridge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws InterruptedException {
        BridgeQueue bridge = new BridgeQueue();
        WestCar westCarA = new WestCar("WA", bridge);
        WestCar westCarB = new WestCar("WB", bridge);
        EastCar eastCarA = new EastCar("EA", bridge);
        EastCar eastCarB = new EastCar("EB", bridge);
        Thread twa = new Thread(westCarA);
        Thread twb = new Thread(westCarB);
        Thread tea = new Thread(eastCarA);
        Thread teb = new Thread(eastCarB);
        twa.start();twb.start();tea.start();teb.start();
        Thread.sleep(10000);// sleep for a while
        twa.interrupt();twb.interrupt();tea.interrupt();teb.interrupt();
        twa.join();twb.join();tea.join();teb.join();
        System.out.println("Program has ended.");
    }   
}
