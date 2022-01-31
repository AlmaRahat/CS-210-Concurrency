// tha main application
public class Application
{
  // it throws InterruptedException to properly shut down Threads.
  public static void main(String[] args) throws InterruptedException
  {
    // create a switch instance
    Switch sw1 = new Switch("sw1");
    // create new thread for switch
    Thread toggler = new Thread(sw1);
    // start executing the thread
    toggler.start();
    // the main thread sleeps while switch keeps going
    Thread.sleep(2000); // for 2 secs
    // stopping the other thread
    toggler.interrupt();
    // allow toggler to finish what it is doing
    toggler.join();
    // print message
    System.out.print("Execution ended!");
    // exit program
  }
}
