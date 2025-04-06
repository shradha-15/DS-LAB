// Java program for linked list implementation of stack
public class Stack2 {
    // A structure to represent a stack node
    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // A utility method to check if the stack is empty
    static boolean isEmpty(StackNode root) {
        return root == null;
    }

    // Push a new data element to the stack
    static void push(StackNode[] root, int data) {
        StackNode stackNode = new StackNode(data);
        stackNode.next = *root;
        *root = stackNode;
        System.out.println(data + " pushed to stack");
    }

    // Pop an element from the stack
    static int pop(StackNode[] root) {
        if (isEmpty(*root)) {
            return Integer.MIN_VALUE;
        }
        StackNode temp = *root;
        *root = (*root).next;
        int popped = temp.data;
        temp = null; // free memory
        return popped;
    }

    // Peek the top element of the stack
    static int peek(StackNode root) {
        if (isEmpty(root)) {
            return Integer.MIN_VALUE;
        }
        return root.data;
    }

    public static void main(String[] args) {
        StackNode root = null;
        push(root, 10);
        push(root, 20);
        push(root, 30);
        System.out.println(pop(root) + " popped from stack");
        System.out.println("Top element is " + peek(root));
    }
}
