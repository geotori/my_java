import java.util.concurrent.locks.*;

public class Bank {
    private static final int TO_STRING_FREQUENCY = 100000;
    private static final int TEST_FREQUENCY = 10000;
    private Lock lock = new ReentrantLock();
    private long transactionCount;
    private int deviationCount;
    private int initialBalance;
    private Account[] accounts;
    private boolean debug;
    private int testCount;

    public Bank(int amount, int initialBalance, boolean debug) {
        accounts = new Account[amount];
        this.initialBalance = initialBalance;
        this.debug = debug;

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, initialBalance);
        }
    }

    void transfer(int from, int to, int amount) {
        lock.lock();
        transactionCount++;

        if (transactionCount % TO_STRING_FREQUENCY == 0) {
            System.out.println("\n----------------------------------------------------------------------");
            System.out.println(toString());
            System.out.println("-----------------------------------------------------------------------\n");
        } else if (transactionCount % TEST_FREQUENCY == 0) {
            test();
        }

        lock.unlock();
        accounts[from].withdraw(amount);
        accounts[to].deposit(amount);
    }

    private void test() {
        testCount++;
        int total = 0;

        for (Account account: accounts) account.getLock().lock();
        for (Account account: accounts) total += account.getBalance();
        for (Account account: accounts) account.getLock().unlock();

        if (total != (accounts.length * initialBalance)) deviationCount++;

        System.out.printf("Transaction count: %7d Total balance: %7d Deviation count: %3d\n",
                getTransactionCount(), total, getDeviationCount());
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        int totalBalance = 0;

        builder.append(String.format("Number of bank clients:\t%10d\n", numberOfAccounts()));
        builder.append(String.format("Number of transactions:\t%10d\n", getTransactionCount()));
        builder.append(String.format("Number of deviations:\t%10d\n", getDeviationCount()));
        builder.append(String.format("Deviation percentage:\t%10.1f\n", getErrorPercentage()));

        for (Account account: accounts) account.getLock().lock();
        for (Account account: accounts) {
            if (debug) {
                builder.append(String.format("Account #%2d balance:\t%10d\n", account.getAccountNumber(), account.getBalance()));
            }
            totalBalance += account.getBalance();
        }
        for (Account account: accounts) account.getLock().unlock();

        builder.append(String.format("Total balance in bank:\t%10d", totalBalance));

        return builder.toString();
    }

    int numberOfAccounts() {
        return accounts.length;
    }

    private long getTransactionCount() {
        return transactionCount;
    }

    private int getDeviationCount() {
        return deviationCount;
    }

    private double getErrorPercentage() {
        return (double) deviationCount / testCount * 100;
    }
}