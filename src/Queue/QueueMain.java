package Queue;

public class QueueMain {
    public static void main(String[] args) {
        CQueue cQueue  = new CQueue(10) ;

        cQueue.enQueue(1);
        cQueue.enQueue(5);
        cQueue.enQueue(8);
        cQueue.enQueue(5);
        cQueue.enQueue(8);
        cQueue.enQueue(7);
        cQueue.enQueue(8);
        cQueue.enQueue(8);
        cQueue.enQueue(9);
      cQueue.deleteitem(5);

        cQueue.display();
    }
}
