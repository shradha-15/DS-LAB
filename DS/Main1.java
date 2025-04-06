// QNode class to represent a queue node
class QNode {
    int key;
    QNode next;

    // Constructor to create a new linked list node
    public QNode(int key) {
        this.key = key;
        this.next = null;
    }
}

// Queue class to represent the queue
class Queue {
    private QNode front, rear;

    // Constructor to create an empty queue
    public Queue() {
        this.front = this.rear = null;
    }

    // Method to add an item to the queue (enqueue)
    public void enqueue(int key) {
        // Create a new node with the given key
        QNode temp = new QNode(key);

        // If the queue is empty, both front and rear should point to the new node
        if (rear == null) {
            front = rear = temp;
            return;
        }

        // Otherwise, add the new node at the end and update the rear
        rear.next = temp;
        rear = temp;
    }

    // Method to remove an item from the queue (dequeue)
    public int dequeue() {
        // If the queue is empty, return -1
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }

        // Get the front node and move the front pointer to the next node
        int item = front.key;
        front = front.next;

        // If the queue becomes empty, set rear to null as well
        if (front == null) {
            rear = null;
        }

        return item;
    }

    // Method to get the front item
    public int front() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.key;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to display the queue (for testing purposes)
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        QNode current = front;
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the queue
public class Main1 {
    public static void main(String[] args) {
        // Create a new queue
        Queue queue = new Queue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue
        queue.display();

        // Dequeue an element and display
        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        // Show the front element
        System.out.println("Front element: " + queue.front());
    }
}
