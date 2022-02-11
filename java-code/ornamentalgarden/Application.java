import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Garden garden;
        Scanner scan = new Scanner(System.in);
        garden = new Garden(); // create a garden

        while(true){
            try {
                garden.go(); // run the garden
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
