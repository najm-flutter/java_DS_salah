package Queue;

public class CQueue {
    int front, rear;
    int[] elements;

    public CQueue(int size) {
        elements = new int[size];
        front = rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % elements.length == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enQueue(int item) {
        if (isFull()) {
            System.out.println("Error Is Full");
            return;
        }
        elements[rear] = item;
        rear = (rear + 1) % elements.length;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Error Is Empty");
            return -1;
        }

        int tmp = elements[front];
        front = (front + 1) % elements.length;
        return tmp;
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

    public void deleteItem(int item) {
        int r = front;
        for (int i = front; i != rear; i = (i + 1) % elements.length) {
            if (elements[i] == item) {
                continue;
            }
            elements[r] = elements[i];
            r = (r + 1) % elements.length;

        }
        rear = r;
    }

}
