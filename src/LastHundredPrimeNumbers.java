import java.io.*;

public class LastHundredPrimeNumbers {
    public static void main(String[] args) throws Exception {
        DataInputStream input =
                new DataInputStream(new BufferedInputStream(
                        new FileInputStream("PrimeNumbers.dat")));

        input.skip(input.available() - 8 * 100);
        while (input.available() > 0) {
            System.out.println(input.readLong() + " ");
        }

        input.close();
    }
}
