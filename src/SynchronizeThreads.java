import java.util.concurrent.*;

    public class SynchronizeThreads {
        private int sum = new Integer(0);

        public static void main(String[] args) {
            SynchronizeThreads test = new SynchronizeThreads();
            System.out.println("What is sum? " + test.sum);
        }

        public SynchronizeThreads() {
            ExecutorService executor = Executors.newFixedThreadPool(1000);

            for (int i = 0; i < 1000; i++) {
                executor.execute(new SumTask());
            }

            executor.shutdown();

            while(!executor.isTerminated()) {
            }
        }

        class SumTask implements Runnable {
            public void run() {
                sum++;
        //int value = sum.intValue() + 1;
        //sum = new Integer(value);
            }
        }
    }
