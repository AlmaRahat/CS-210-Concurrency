/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ornamentalgarden;

/**
 *
 * @author aamr201
 */
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
