package SALAM;

public class Queue {
    int front, rear, size;
    int items[];

    Queue(int size) {
        front = rear = -1;
        this.size = size;
        items = new int[size];
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public void enqueue(int item) {

        if (isFull()) {
            System.out.println("error");
            return;
        }
        if (front == -1)
            front = 0;
        items[++rear] = item;

    }

    public int dequeue() {

        if (isEmpty()) {
            System.out.println("error");
            return -1;
        }

        int tmp = items[front++];
        if (front > rear)
            front = rear = -1;
        return tmp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(items[i] + ",");
        }

        System.out.println();

    }
}

class QueueLinked {
    Node front, rear;

    QueueLinked() {
        front = rear = null;
    }

    public void enqueue(int item) {
        Node tmp = new Node(item);
        if (rear == null) {
            front = rear = tmp;
        }
        rear.next = tmp;
        rear = tmp;

    }

    public void dequeue() {

        if (front == null) {
            System.out.println("empty");
            return;
        }
        System.out.print(front.data + ",");
        front = front.next;

    }

    public void display() {
        if (front == null) {
            System.out.println("empty");
            return;
        }
        for (Node i = front; i != null; i = i.next) {
            System.out.print(i.data + "-->");
        }
    }
}
