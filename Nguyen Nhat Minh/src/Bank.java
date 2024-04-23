
import java.util.Random;


public class Bank {
   
    private double[] accounts;

    public Bank(int n, double initBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initBalance;
        }
    }

    public synchronized int size() {
        return accounts.length;
    }
    public synchronized double getTotalBalance() {
        double totalBalance = 0;
        for (double balance : accounts) {
            totalBalance += balance;
        }
        return totalBalance;
    }
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            wait();
        }

        System.out.printf("Transferring %.2f from account %d to account %d\n", amount, from, to);
        accounts[from] -= amount;
        accounts[to] += amount;

        System.out.printf("Total balance: %.2f\n", getTotalBalance());
        notifyAll();
    }
    
}



