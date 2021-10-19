import java.io.*;

public class InitialSortedSegments {
    private static int initializeSegments
            (int segmentSize, String originalFile, String f1) throws Exception {
        int[] list = new int[segmentSize];
        DataInputStream input = new DataInputStream(new BufferedInputStream(
                new FileInputStream(originalFile)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(f1)));

        int numberOfSegments = 0;
        while (input.available() > 0) {
            numberOfSegments++;
            int i = 0;
            for ( ; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }

            java.util.Arrays.sort(list, 0, i);

            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }

        input.close();
        output.close();

        return numberOfSegments;
    }
}