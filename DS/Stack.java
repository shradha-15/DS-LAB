public class Stack {

    private int top;
    private int capacity;
    private int[] array;

    // Constructor to create a stack of given capacity
    // Initializes size of stack as 0
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[capacity];
    }

    // Stack is full when top is equal to the last index
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Stack is empty when top is equal to -1
    public boolean isEmpty() {
        return top == -1;
    }

    // Function to add an item to stack. It increases top by 1
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + item);
            return;
        }
        array[++top] = item;
        System.out.println(item + " pushed to stack");
    }

    // Function to remove an item from stack. It decreases top by 1
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return Integer.MIN_VALUE;
        }
        return array[top--];
    }

    // Function to return the top from stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return Integer.MIN_VALUE;
        }
