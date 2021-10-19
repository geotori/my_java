import java.util.*;
import java.io.*;

public class USCapitals {
    public static void main(String[] args) {
        String filNavn ="USCapitals.txt";
        String linje;
        String[] statHovedstad;
        Map<String, String> map = new HashMap<String, String>();

        try (Scanner input = new Scanner(new File(filNavn))) {
            while (input.hasNextLine()) {
                linje = input.nextLine();
                statHovedstad = linje.split(",");
                statHovedstad[0].trim();
                statHovedstad[1].trim();
                map.put(statHovedstad[0].toLowerCase(), statHovedstad[1].toLowerCase());
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

        Scanner brukerInput = new Scanner(System.in);
        System.out.print("Please enter a state in US: ");
        String stat = brukerInput.nextLine().toLowerCase().trim();
        if (map.containsKey(stat))
            System.out.println("The capital is " + map.get(stat));
        else
            System.out.println("There is no such state.");
    }
}