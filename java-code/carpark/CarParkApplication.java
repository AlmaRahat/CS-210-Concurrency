import java.util.concurrent.Semaphore;
public class CarParkApplication {
    public static void main(String[] args) throws InterruptedException {
        Controller controller = new Controller(4);
        Entrance entrance = new Entrance(controller, "In");
        Exit exit = new Exit(controller, "Out");
        Thread arrThread = new Thread(entrance);
        Thread depThread = new Thread(exit);
        arrThread.start();
        depThread.start();
        Thread.sleep(5*10000);
        arrThread.interrupt();
        arrThread.join();
        depThread.interrupt();
        depThread.join();
    }

}
