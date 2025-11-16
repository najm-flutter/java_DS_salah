package Queue;

public class Queue {
    char[] elements;
    int front, rear;

    Queue(int size) {
        elements = new char[size];
        front = rear = -1;
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return rear == elements.length - 1;
    }

    public void EnQueue(char element) {
        if (isFull()) {
            System.out.print("is Full");
            return;
        }

        if (front == -1)
            front = 0;
        elements[++rear] = element;
    }

    public char deQueue() {
        if (isEmpty()) {
            System.out.print("is Empty");
            return '-';
        }
        char tmp = elements[front++];
        if (front > rear) {
            front = rear = -1;
        }
        return tmp;
    }

    public char getReare() {
        if (isEmpty()) {
            return '-';
        }

        return elements[rear];
    }

    public int getSize() {
        return (front - rear) + 1;
    }

    public void deleteItem(char val) {
        if (isEmpty()) {
            System.out.println("is Empty\n");
        }

        for (int i = front + 1; i <= rear; i++) {
            if (elements[i] == val) {

            }
        }
    }

}