// Queue class to represent a queue
public class Queue {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    // Constructor to create a queue of given capacity
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[this.capacity];
    }

    // Other methods for queue operations can be added here (e.g., enqueue, dequeue, etc.)
    
    // For demonstration, you can add methods like enqueue and dequeue
    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        array[rear] = item;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Return a sentinel value for an empty queue
        }
        int item = array[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return item;
    }

    // Method to get the front item
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Return a sentinel value for an empty queue
        }
        return array[front];
    }

    // Method to get the rear item
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1; // Return a sentinel value for an empty queue
        }
        return array[rear];
    }

    // Method to display the queue (for testing purposes)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            System.out.print(array[i] + " ");
        }
        System.out.println(array[rear]);
    }
}

// Main class to demonstrate the queue
public class Main {
    public static void main(String[] args) {
        // Create a queue of capacity 5
        Queue queue = new Queue(5);
        
        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        // Display the queue
        queue.display();

        // Dequeue an element and display
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
