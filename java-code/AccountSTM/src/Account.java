import org.multiverse.api.references.*;
import org.multiverse.api.StmUtils;
public class Account {
    private TxnDouble balance;
    Account(double initBalance){
        balance = StmUtils.newTxnDouble(initBalance);
    }
    public double getBalance(){
        return balance.atomicGet();
    }
    public void addBalance(double amount){
        balance.incrementAndGet(amount);
    }
    public void subtractBalance(double amount){
        balance.incrementAndGet(-amount);
    }
    public void transfer(Account to, double amount){
        subtractBalance(amount);
        to.addBalance(amount);
    }
    public void atomicTransfer(Account to, double amount){
        StmUtils.atomic(()->{ // atomic wrapper
           transfer(to, amount);
        });
    }
}
