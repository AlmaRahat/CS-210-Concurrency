import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Garden garden;
        Scanner scan = new Scanner(System.in);
        garden = new Garden(); // create a garden

        while(true){
            try {
                garden.go(); // run the garden
                /*
                // reset counters
                reset();
                // create threads
                Thread westThread = new Thread(west, "west");
                Thread eastThread = new Thread(east, "east");
                // start threads
                westThread.start();
                eastThread.start();
                // wait for threads to die
                westThread.join();
                eastThread.join();
                */
            } catch (InterruptedException ex) {
            }
            // count at the end
            System.out.println(garden.getCount());
            // ask to continue
            System.out.println("Have another go?");
            System.out.println("input should be: \n 0 to exit the program, \n 1 to iterate with same settings, \n 2 to flip between faulty counter and fixed counter, and run the new settings.");
            int choice = scan.nextInt();
            if (choice == 0){
                break;
            }
            else if(choice == 2){
                garden.flipSynchronised();
            }
        }
    }

}
