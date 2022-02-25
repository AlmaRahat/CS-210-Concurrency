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
            System.out.println(name + " has finished reading.");
            library.returnBook(name);
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Arrival Thread");
            return;
        }
    }
}
