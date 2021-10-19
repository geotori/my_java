import java.util.concurrent.locks.*;

public class Account {
    private int balance;
    private int accountNumber;
    private Lock lock = new ReentrantLock();
    private Condition lockCondition = lock.newCondition();


    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void withdraw(int amount) {
        lock.lock();

        try {
            while (balance - amount < 0) {
                lockCondition.await();
            }
            balance -= amount;
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }

    void deposit(int amount) {
        lock.lock();

        balance += amount;
        lockCondition.signalAll();

        lock.unlock();
    }

    int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    Lock getLock() {
        return lock;
    }
}