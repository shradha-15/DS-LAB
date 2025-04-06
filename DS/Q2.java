// Queue class to represent a queue
public class Q2 {
    private int front, rear, size;
    private int capacity;
    private int[] array;

    // Constructor to create a queue of given capacity
    public Q2(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.array = new int[this.capacity];
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to add an item to the queue (enqueue)
    public void enqueue(int item) {
        // Check if the queue is full
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + item);
            return;
        }

        // Update rear in a circular manner
        rear = (rear + 1) % capacity;

        // Add the item to the rear of the queue
        array[rear] = item;

        // Increase the size of the queue
        size++;

        // Print the item enqueued
        System.out.println(item + " enqueued to queue");
    }

    // Method to remove an item from the queue (dequeue)
    public int dequeue() {
        // If the queue is empty, return -1
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        // Get the front item and update the front pointer
        int item = array[front];
        front = (front + 1) % capacity;  // Circular increment

        // Decrease the size of the queue
        size--;

        return item;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display the queue (for testing purposes)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.print(array[current] + " ");
            current = (current + 1) % capacity;  // Circular increment
        }
        System.out.println();
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
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);  // This will print "Queue is full, cannot enqueue 60"

        // Display the queue
        queue.display();
        
        // Dequeue an element and display
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
