import java.util.*;

public class PostfixNotasjon {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: Java PostfixNotasjon \"expression\"");
            System.exit(1);
        }

        try {
            System.out.println(evaluateExpression(args[0]));
        }
        catch (Exception ex) {
            System.out.println("Wrong expression: " + args[0]);
        }
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> operandStack = new Stack<>();
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression, "+-/*%", true);

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0) {
                continue;
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*'
                        || token.charAt(0) == '/') {
                processAnOperator(token.charAt(0), operandStack);
            }
            else {
                operandStack.push(new Integer(token));
            }
        }

        return ((Integer)(operandStack.pop())).intValue();
    }

    public static void processAnOperator(char op, Stack<Integer> operandStack) {
        if (op == '+') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 + op1));
        }
        else if (op == '-') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 - op1));
        }
        else if ((op == '*')) {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 * op1));
        }
        else if (op == '/') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 / op1));
        }
    }
}
