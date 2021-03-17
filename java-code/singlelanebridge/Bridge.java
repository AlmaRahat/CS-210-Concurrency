public class Bridge {
    private int westCount = 0;
    private int eastCount = 0;
    public synchronized void westEnter() 
            throws InterruptedException{
        while (eastCount > 0) wait();
        westCount += 1; 
    }
    public synchronized void westExit(){
        westCount -= 1;
        notifyAll();
    }
    public synchronized void eastEnter() 
            throws InterruptedException{
        while (westCount > 0) wait();
        eastCount += 1; 
    }
    public synchronized void eastExit(){
        eastCount -= 1;
        notifyAll();
    }
}
