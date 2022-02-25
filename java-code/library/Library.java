public class Library{
    static final int MAX_AVAIALABLE = 2;
    private boolean[] booksInUse = new boolean[MAX_AVAIALABLE];
    public synchronized void borrowBook(String name)
            throws InterruptedException{
        System.out.println(name + " is waiting!");
        while(areAllTrue()){
            wait();
        }
        System.out.println(name + " is trying to get a book!");
        takeFirstAvaialbleBook();
        notifyAll();
    }
    private boolean areAllTrue(){
        for(boolean b : booksInUse) if(!b) return false;
        return true;
    }
    private void takeFirstAvaialbleBook() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == false){
                booksInUse[i] = true;
                break;
            }
    }
    public synchronized void returnBook(String name)
            throws InterruptedException{
        System.out.println(name + " is trying to return a book!");
        returnFirstAvailableSlot();
        notifyAll();
    }
    private void returnFirstAvailableSlot() {
        for(int i=0; i<MAX_AVAIALABLE; i++)
            if (booksInUse[i] == true){
                booksInUse[i] = false;
                break;
            }
    }
}
