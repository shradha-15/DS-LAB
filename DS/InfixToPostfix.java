import java.util.Stack;

public class InfixToPostfix {
    
    // Method to check if the character is an operand
    public static boolean checkIfOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // Method to compare precedence of operators
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Method to convert infix expression to postfix expression
    public static void covertInfixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        
        // Loop through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the character is an operand, add it to the output
            if (checkIfOperand(ch)) {
                output.append(ch);
            } 
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            } 
            // If the character is ')', pop and append from the stack until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("Invalid Expression");
                    return; // Invalid expression
                } else {
                    stack.pop(); // Pop '('
                }
            } 
            // If the character is an operator
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        
        // Print the postfix expression
        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        String expression = "((a+(b*c))-d)";
        covertInfixToPostfix(expression);  // Call the method with the input expression
    }
}
