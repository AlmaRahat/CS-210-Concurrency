/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aamr201
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Library library = new Library();
        Student s1 = new Student(library, "Tom");
        Student s2 = new Student(library, "Jenny");
        Student s3 = new Student(library, "Plato");
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
    
}
