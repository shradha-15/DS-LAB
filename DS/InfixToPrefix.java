import java.util.Stack;

public class InfixToPrefix {

    // Utility function to check if the given character is operand
    static boolean checkIfOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // Function to compare precedence of operators
    // Higher precedence means a larger value
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix
    static String getPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is an operand, add it to the result
            if (checkIfOperand(ch)) {
                result.append(ch);
            } 
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If the character is ')', pop from the stack until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";  // Invalid expression
                } else {
                    stack.pop();  // pop the '('
                }
            } 
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Function to reverse the string
    static void reverse(StringBuilder exp) {
        int size = exp.length();
        int i = 0, j = size - 1;
        while (i < j) {
            char temp = exp.charAt(i);
            exp.setCharAt(i, exp.charAt(j));
            exp.setCharAt(j, temp);
            i++;
            j--;
        }
    }

    // Function to swap brackets in the expression
    static void brackets(StringBuilder exp) {
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                exp.setCharAt(i, ')');
            } else if (exp.charAt(i) == ')') {
                exp.setCharAt(i, '(');
            }
        }
    }

    // Function to convert infix expression to prefix
    static void infixToPrefix(StringBuilder exp) {
        // Reverse the string
        reverse(exp);
        // Change brackets
        brackets(exp);
        // Get postfix of the reversed expression
        String postfix = getPostfix(exp.toString());
        // Set the postfix result back into the expression
        exp.setLength(0);  // Clear the original expression
        exp.append(postfix);
        // Reverse the result again to get the prefix expression
        reverse(exp);
    }

    public static void main(String[] args) {
        StringBuilder expression = new StringBuilder("((a/b)+c)-(d+(e*f))");
        System.out.println("The infix is: " + expression);
        
        infixToPrefix(expression);
        
        System.out.println("The prefix is: " + expression);
    }
}
