package Queue;

import PublicClass.Node;

public class QueueLinked {
    Node front, rear;

    public QueueLinked() {
        front = rear = null;
    }

    public void enQueue(int item) {
        Node new_node = new Node(item);
        if (front == null) {
            front = rear = new_node;
            return;
        }
        rear.next = new_node;
        rear = new_node;

    }

    public int deQueue() {

        if (rear == null) {
            System.out.println("Is Empty");
            return -1;
        }
        int tmp = front.data;
        front = front.next;
        return tmp;
    }

    public void display() {
        if (front == null || rear == null) {
            return;
        }
        Node tmp = front;
        while (tmp != null) {
            System.out.print(tmp.data + "-->");
            tmp = tmp.next;
        }
        System.out.print("null");
    }
}
