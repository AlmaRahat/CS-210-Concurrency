public class Transactions implements Runnable{
    private Account[] accounts;
    Transactions(Account[] accounts){
        this.accounts = accounts;
    }
    @Override
    public void run() {
        for(int i =0; i<10; i++) {
            accounts[0].atomicTransfer(accounts[1], 5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accounts[1].atomicTransfer(accounts[2], 5);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accounts[2].atomicTransfer(accounts[0], 5);
        }
    }
}
