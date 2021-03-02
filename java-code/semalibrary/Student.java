/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aamr201
 */
public class Student implements Runnable{
    private Library library;
    private String name;
    private int sleepScaler = 10000;
    Student(Library library, String name){
        this.library = library;
        this.name = name;
    }
    @Override
    public void run() {
        try {
            library.borrowBook(name);
            double random = Math.random();
            System.out.println(name + " is starting to read.");
            Thread.sleep((long) (random*sleepScaler));
            System.out.println(name + " has finisehd reading.");
            library.returnBook(name);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Arrival Thread");
            return;
        }
    }
    
}
