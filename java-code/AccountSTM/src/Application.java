public class Application {
    public static void main(String[] args) throws InterruptedException {
        Account[] accounts = new Account[3];
        accounts[0] = new Account(100);
        accounts[1] = new Account(100);
        accounts[2] = new Account(100);
        Thread t1 = new Thread(new Transactions(accounts));
        Thread t2 = new Thread(new Transactions(accounts));
        Thread t3 = new Thread(new Transactions(accounts));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("I am done!");
        System.out.println(accounts[0].getBalance());
        System.out.println(accounts[1].getBalance());
        System.out.println(accounts[2].getBalance());
    }
}
