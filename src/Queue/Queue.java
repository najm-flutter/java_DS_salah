package Queue;

public class Queue {
    int[] elements;
    int front, rear;

    Queue(int size) {
        elements = new int[size];
        front = rear = -1;
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return rear == elements.length - 1;
    }

    public void EnQueue(int element) {
        if (isFull()) {
            System.out.print("is Full");
            return;
        }

        if (front == -1)
            front = 0;
        elements[++rear] = element;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.print("is Empty");
            return -1;
        }
        int tmp = elements[front++];
        if (front > rear) {
            front = rear = -1;
        }
        return tmp;
    }

    public int getReare() {
        if (isEmpty()) {
            return -1;
        }

        return elements[rear];
    }

    public int getSize() {
        return (front - rear) + 1;
    }

    public void deleteItem(int val) {
        if (isEmpty()) {
            System.out.println("is Empty\n");
            return;
        }

        for (int i = front; i <= rear; i++) {
            if (elements[i] == val) {
                for (int j = i; j < rear; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[rear--] = 0;

            }
        }
    }

}