/**import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;

public class CountOccurrencesOfWordsInTextFile {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(
                    "Usage: java fullfilename");
            System.exit(1);
        }

        String filename = args[0];

        // Create a tree map to hold words as key and count as value
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        try {
            Scanner input = new Scanner(new File(filename));

            while (input.hasNext()) {
                String line = input.nextLine();
                String[] words = line.split("[ @!~{}\\[\\]$#^&*\n\t\r.,;?'\")(]");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].trim().length() > 0 && words[i].trim().matches("[A-Z|a-z]+")) {
                        String key = words[i].toLowerCase();

                        if (treeMap.get(key) != null) {
                            int count = treeMap.get(key);
                            count++;
                            treeMap.put(key, count);
                        }
                        else {
                            treeMap.put(key, 1);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        // Get an entry set for the tree map
        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();

        // Display words in alphabetical order
        System.out.println("\nDisplay words and their count in " +
                " ascending order of the words");
        for (Map.Entry<String, Integer> entry: entrySet)
            System.out.println(entry.getValue() + "\t" + entry.getKey());
    }
}

    public int grepLineNumber(String file, String word) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(file))));

        String line;
        int lineNumber = 0;
        while ((line = buf.readLine()) != null)   {
            lineNumber++;
            if (word.equals(line)) {
                return lineNumber;
            }
        }
        return -1;
    }
*/