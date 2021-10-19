import java.util.concurrent.*;

public class PrimeChecker {
    private ExecutorService pool = Executors.newCachedThreadPool();
    private boolean isPrime = true;
    private long number = 9223372036854775783L;
    private int numberOfThreads = 10;
    private long[] startValues = new long[numberOfThreads];
    private long[] endValues = new long[numberOfThreads];

    private PrimeChecker() {
        System.out.printf("Checking if %d is a prime number, multithreaded. %n%n", number);

        long startTime = System.currentTimeMillis();
        init();
        runThreads();
        long endTime = System.currentTimeMillis();

        System.out.printf("%d%s a prime number.%n", number, isPrime ? " is" : " is not");
        System.out.printf("Execution time: %d ms. %n%n", endTime - startTime);
        System.out.printf("Checking if %d is a prime number, singlethreaded. %n", number);

        startTime = System.currentTimeMillis();
        isPrime = singlethreadedPrimeCheck();
        endTime = System.currentTimeMillis();

        System.out.printf("%d%s a prime number.%n", number, isPrime ? " is" : " is not");
        System.out.printf("Execution time: %d ms. %n%n", endTime - startTime);
    }

    public static void main(String args[]) {
        new PrimeChecker();
    }

    private void init() {
        if (number % 2 == 0 && number != 2) {
            isPrime = false;
            return;
        }

        long limit = (long) Math.sqrt((double) number) + 1;
        long size = limit / numberOfThreads;
        startValues[0] = 3;
        endValues[numberOfThreads - 1] = limit;

        for (int i = 0; i < numberOfThreads - 1; i++) {
            startValues[i + 1] = startValues[i] + size;
            endValues[i] = startValues[i + 1] - 1;
        }
    }

    private void runThreads() {
        try {
            for (int i = 0; i < numberOfThreads && !pool.isShutdown(); i++) {
                PrimeTask thread = new PrimeTask(startValues[i], endValues[i], number);
                pool.execute(thread);
            }

            pool.shutdown();
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private synchronized void notPrime() {
        pool.shutdownNow();
        isPrime = false;
    }

    private boolean singlethreadedPrimeCheck() {
        if (number % 2 == 0 && number != 2) {
            return false;
        }

        long limit = (long) Math.sqrt((double) number) + 1;

        for (long i = 3; i <= limit; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }

    private class PrimeTask implements Runnable {
        private long number;
        private long startValue;
        private long endValue;

        PrimeTask(long startValue, long endValue, long number) {
            this.startValue = startValue;
            this.endValue = endValue;
            this.number = number;
        }

        public void run() {
            for (long i = startValue; i <= endValue; i += 2)
                if (number % i == 0)
                    notPrime();
        }
    }
}