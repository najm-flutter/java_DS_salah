package Generics.QueueDSG;

public class QueueG<T> {

    T[] elements;
    int front, rear;

    QueueG(int size) {
        elements = (T[]) new Object[size];
        front = rear = -1;
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return rear == elements.length - 1;
    }

    public void enQueue(T element) {
        if (isFull()) {
            System.out.print("is Full");
            return;
        }

        if (front == -1)
            front = 0;
        elements[++rear] = element;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.print("is Empty");
            return null;
        }
        T tmp = elements[front++];
        if (front > rear) {
            front = rear = -1;
        }
        return tmp;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return elements[rear];
    }

    public int getSize() {
        return (front - rear) + 1;
    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(elements[i] + ",");
        }
    }

    public void deleteItem(T val) {
        if (isEmpty()) {
            System.out.println("is Empty\n");
            return;
        }

        for (int i = front; i <= rear; i++) {
            if (elements[i].equals(val)) {
                for (int j = i; j < rear; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[rear--] = null;

            }
        }
    }

}