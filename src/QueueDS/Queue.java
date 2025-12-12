package QueueDS;

public class Queue {
    int[] elements;
    int front, rear;

    public Queue(int size) {
        elements = new int[size];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == elements.length - 1;
    }

    public void enQueue(int element) {
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

    public int peek() {
        if (isEmpty()) {
            return -1;
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

    public boolean deleteItemHelper(int val) {
        if (isEmpty()) {
            System.out.println("is Empty\n");
            return false;
        }
        boolean isFound = false;
        for (int i = front; i <= rear; i++) {
            if (elements[i] == val) {
                isFound = true;
                for (int j = i; j < rear; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[rear--] = 0;
                break;

            }
        }
        return isFound;
    }

    public void deleteAll(int val) {
        while (deleteItemHelper(val))
            ;
    }

}