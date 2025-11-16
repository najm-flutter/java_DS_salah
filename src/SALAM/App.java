package SALAM;

public class App {
    public static void main(String[] args) {
        // LinkedList linkedList = new LinkedList();

        // linkedList.addFirst(4);
        // linkedList.addFirst(5);
        // linkedList.addFirst(3);
        // linkedList.addFirst(6);

        // linkedList.display();
        // linkedList.deleteAt(3);
        // System.out.println();
        // linkedList.display();
        // System.out.println();

        QueueLinked q = new QueueLinked();

        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(7);
        q.enqueue(3);
        q.display();
        System.out.println();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.display();
    }
}
