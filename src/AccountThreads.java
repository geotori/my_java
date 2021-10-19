import java.util.Random;

public class AccountThreads extends Thread {
    private Bank bank;
    private boolean debug;
    private int accountIndex;
    private int maxTransferAmount;
    private Random random = new Random(System.currentTimeMillis());

    public AccountThreads(Bank bank, int accountIndex, int maxTransferAmount, boolean debug) {
        this.bank = bank;
        this.debug = debug;
        this.accountIndex = accountIndex;
        this.maxTransferAmount = maxTransferAmount;
    }

    public void run() {
        try {
            while (!interrupted()) {
                bank.transfer(
                        accountIndex,
                        random.nextInt(bank.numberOfAccounts()),
                        random.nextInt(maxTransferAmount));

                sleep(debug ? 2 : random.nextInt(11));
            }
        } catch (InterruptedException ignored) {
        }
    }
}