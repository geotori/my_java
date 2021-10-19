import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableFibonacci implements Iterable<Integer> {
    private int maxIndex;

    /**
     * Creates a new IterableFibonacci
     *
     * @param maxIndex
     *            -- the index of the last Fibonacci number returned in this
     *            sequence
     * @throws IllegalArgumentException
     *             if maxIndex < 0
     **/
    public IterableFibonacci(int maxIndex) {
        if (maxIndex < 0) {
            throw new IllegalArgumentException("Invalid index for Fibonacci"
                    + "sequence: " + maxIndex);
        }
        this.maxIndex = maxIndex;
    }

    /**
     * sets the maximal index in this Fibonacci sequence
     *
     * @param newMax
     *            -- the new value of the maximum index in this sequence
     * @throws IllegalArgumentException
     *             if newMax < 0
     **/
    public void setMaxIndex(int newMax) {
        if (newMax < 0) {
            throw new IllegalArgumentException("Invalid index for Fibonacci"
                    + "sequence: " + newMax);
        }
        maxIndex = newMax;
    }

    /**
     * Returns an iterator that produces the sequence of Fibonacci numbers from
     * index 0 to the maximum index (inclusive)
     **/
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    private class FibonacciIterator implements Iterator<Integer> {
        // two latest fibonacci numbers:
        private int fib1 = 0;
        private int fib2 = 1;
        private int count = 0;

        /**
         * @return - true if there are more elements in the sequence, false
         *         otherwise
         **/
        public boolean hasNext() {
            return (count < maxIndex);
        }

        /**
         * @return - the next Fibonacci number in the sequence
         * @throws -- NoSuchElementException if there are no more elements
         **/
        public Integer next() {
            if (hasNext()) {
                int current = fib1;
                fib1 = fib2;
                fib2 = fib1 + current;
                count++;
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * method not supported
         **/
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}