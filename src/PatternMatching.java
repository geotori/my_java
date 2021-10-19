import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();

        int index = matching(s1, s2);
        if (index >= 0)
            System.out.printf("Match found at index %d%n", index);
        else
            System.out.println("No match found");
    }

    public static int matching(String s, String pattern) {
        int matchingLength = 0;
        for (int k = 0; k < s.length(); k++) {
            if (matchingLength == pattern.length()) {
                return k - pattern.length();
            } else if (s.charAt(k) == pattern.charAt(matchingLength)) {
                matchingLength++;
            } else {
                if (matchingLength > 0) {
                    k--;
                }
                matchingLength = 0;
            }
        }
        if (matchingLength == pattern.length()) {
            return s.length() - pattern.length();
        } else
            return -1;
    }
}