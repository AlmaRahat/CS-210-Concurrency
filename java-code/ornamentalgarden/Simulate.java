public class Simulate {
    public static void HWInterrupt(){
        if (Math.random()>0.5)
            Thread.yield();
    }
}
