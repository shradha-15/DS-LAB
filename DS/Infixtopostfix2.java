import java.util.Stack;

public class Infixtopostfix2 {

    // Utility function to check if the character is an operand
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
    static String convertInfixToPostfix(String expression) {
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

    public static void main(String[] args) {
        String expression = "((a+(b*c))-d)";
        String result = convertInfixToPostfix(expression);
        System.out.println("Postfix expression: " + result);
    }
}
