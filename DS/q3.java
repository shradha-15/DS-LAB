// QNode class to represent a queue node
class q3 {
    int data;
    QNode next;

    // Constructor to create a new linked list node
    public q3(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class to represent the queue
class Queue {
    private QNode front;

    // Constructor to create an empty queue
    public Queue() {
        this.front = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to enqueue an item to the queue (add to rear)
    public void enqueue(int item) {
        QNode newNode = new QNode(item);
        
        if (isEmpty()) {
            front = newNode; // If the queue is empty, the new node becomes both front and rear
        } else {
            QNode temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode; // Add the new node to the end of the queue
        }
    }

    // Method to get the rear item in the queue (last item)
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Return -1 to indicate the queue is empty
        }

        QNode temp = front;
        while (temp.next != null) {
            temp = temp.next; // Traverse to the last node
        }
        return temp.data; // Return the data of the last node
    }

    // Method to display the queue (for testing purposes)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        QNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the queue
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue
        queue.display();

        // Get the rear element of the queue
        System.out.println("Rear element: " + queue.rear());
    }
}
