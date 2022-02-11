public class SynchronisedCounter extends Counter {

    SynchronisedCounter() {
        super();
    }
    @Override
    public synchronized void increment(){
        int temp = value; //read value
        Simulate.HWInterrupt();
        value = temp + 1; // set value
    }
}
