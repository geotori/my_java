import java.util.concurrent.*;

public class ArraySearch {
    private ExecutorService pool = Executors.newCachedThreadPool();
    private int antallThreads = 10;
    private int tall = 1000000;
    private int[] array = new int[tall];
    private int[] startverdi = new int[antallThreads];
    private int[] sluttverdi = new int[antallThreads];
    private int indeks = -1;

    public static void main(String[] args) {
        new ArraySearch();
    }

    private void init() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 1000000) + 1;
        }

        int storrelse = tall / antallThreads;
        startverdi[0] = 0;
        sluttverdi[antallThreads - 1] = tall - 1;

        for (int i = 0; i < antallThreads - 1; i++) {
            startverdi[i + 1] = startverdi[i] + storrelse;
            sluttverdi[i] = startverdi[i + 1] - 1;
        }
    }

    public ArraySearch() {
        init();
        runThreads();
        System.out.printf("%d er på indeks %d.%n", tall, indeks);
    }

    private void runThreads() {
        try {
            for (int i = 0; i < antallThreads && !pool.isShutdown(); i++) {
                ArraySearchTask thread = new ArraySearchTask(startverdi[i], sluttverdi[i], tall);
                pool.execute(thread);
            }

            pool.shutdown();

            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }

        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private synchronized void tallFunnet(int indeks) {
        pool.shutdownNow();
        this.indeks = indeks;
    }

    private class ArraySearchTask implements Runnable {
        private int tall;
        private int startverdi;
        private int sluttverdi;

        ArraySearchTask(int startverdi, int sluttverdi, int tall) {
            this.startverdi = startverdi;
            this.sluttverdi = sluttverdi;
            this.tall = tall;
        }

        public void run() {
            for (int i = startverdi; i <= sluttverdi; i++) {
                if (tall == array[i]) {
                    tallFunnet(i);
                }
            }
        }
    }
}
