package Generics.QueueDSG;

public class CQueueG<T> {

    int front, rear;
    T[] elements;

    public CQueueG(int size) {
        elements = (T[]) new Object[size];
        front = rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % elements.length == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enQueue(T item) {
        if (isFull()) {
            System.out.println("Error Is Full");
            return;
        }
        elements[rear] = item;
        rear = (rear + 1) % elements.length;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("Error Is Empty");
            return null;
        }

        T tmp = elements[front];
        front = (front + 1) % elements.length;
        return tmp;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Is Empty");
            return null;
        }
        return elements[rear];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Is Empty");
            return;
        }
        for (int i = front; i != rear; i = (i + 1) % elements.length) {
            System.out.print(elements[i] + ",");
        }
    }

    public void deleteItem(T item) {
        int r = front;
        for (int i = front; i != rear; i = (i + 1) % elements.length) {
            if (elements[i].equals(item)) {
                continue;
            }
            elements[r] = elements[i];
            r = (r + 1) % elements.length;

        }
        rear = r;
    }

}
