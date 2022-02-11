public class Counter {
    int value;

    public int getValue(){
        return value;
    }

    public void increment(){
        int temp = value; //read value
        Simulate.HWInterrupt();
        value = temp + 1; // set value
    }
}
