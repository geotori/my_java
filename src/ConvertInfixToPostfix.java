public class ConvertInfixToPostfix {

    public static void main(String[] args) {
        System.out.println(infixToPostfix("10*(2+10)*(10/2+5)+(10/(2*(10*2)+2)+8)"));
    }


    public static String infixToPostfix(String expression) {

        StringBuilder sb = new StringBuilder();

        String operators = "()-+*/";

        // Numbers with spaces in-between will be merged,
        // Example (9 3 + 3) * 2, the string will be read as ( 93 + 3 ) * 2
        for (char ch : expression.toCharArray()) {

            if (ch == ' ') continue; // ignore white space

            if (Character.isAlphabetic(ch)) // no letters
                throw new RuntimeException("No characters allowed");

            if (operators.indexOf(ch) >= 0)
                sb.append(" ").append(ch).append(" ");
            else if (Character.isDigit(ch) || ch == '.')
                sb.append(ch);
            else
                throw new RuntimeException("Invalid character! " + ch);
        }

        return PostfixNotation.convertToPostfix(sb.toString().trim());
    }


}