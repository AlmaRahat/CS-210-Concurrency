public class Shelf {
    private Book[] bookArray;
    private int capacity;
    private int id;
    private boolean isTaken;
    Shelf(int capacity, int id){
        this.id = id;
        this.capacity = capacity;
        bookArray = new Book[capacity];
        Book book = bookArray[0];
        for(int i=0; i<capacity; i++)
            bookArray[i] = new Book();
        this.isTaken = false;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getId(){
        return id;
    }
    public synchronized void acquire() 
            throws InterruptedException{
        while (isTaken) wait();
        isTaken = true;
        notifyAll();
    }
    public synchronized void release(){
        isTaken = false;
        notifyAll();
    }
    public Book getBookAtIndex(int index){
        return bookArray[index];
    }
    public void setBookAtIndex(int index, Book book){
        bookArray[index] = book;
    }
    public synchronized void swap(Shelf other, int originIndex, int destIndex){
        Book origin = getBookAtIndex(originIndex);
        Book dest = other.getBookAtIndex(destIndex);
        setBookAtIndex(originIndex, dest);
        other.setBookAtIndex(destIndex, origin);
    }
}
