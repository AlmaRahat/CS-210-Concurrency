// a simple toggle switch implements runnable interface
public class Switch implements Runnable
{
  // attributes to hold the state information
  private boolean signal;
  private String name;

  // constructor
  Switch(String name){
  	signal = false;
    this.name = name;
  }

  // setter and getters
  public boolean getSignal(){
  	return signal;
  }

  public String getName(){
  	return name;
  }

  // state changing actions
  public void down(){
  	signal = true;
  }

  public void up(){
  	signal = false;
  }

  // work that will be done by the thread
  public void run(){
    while(true){
      try{
        System.out.println("------");
        System.out.println(name);
        down();
        System.out.println(signal);
        Thread.sleep(1000); // sleep for 1 sec
        up();
        System.out.println(signal);
      }
      // if interrupted exit the thread appropriately
      catch(InterruptedException e){
        System.out.println("Interrupt occured!");
      	break;
      }
    }

  }
}
