package others;

import Array.Array2D;
import QueueDS.CQueue;
import QueueDS.Queue;

public class Test {
    public static void main(String[] args) {
        Array2D array2d = new Array2D(3, 3);
        array2d.addAll(new double[] { 6, 6, 6, 6, 6, 6 });
        array2d.deleteWithSkipAt(6, 1);
        array2d.print();
        // Queue queue = new Queue(array2d.length);

        // for (int i = 0; i < array2d.length; i++) {
        // queue.enQueue((int) array2d.getAt(array2d.getRow(i), array2d.getCol(i)));
        // }

        // queue.deleteAll(6);
        // array2d.rest();
        // while (!queue.isEmpty()) {

        // array2d.add(queue.deQueue());

        // }

        // array2d.print();

        // CQueue cQueue = new CQueue(10);
        // cQueue.enQueue(1);
        // cQueue.enQueue(3);
        // cQueue.enQueue(1);
        // cQueue.enQueue(3);
        // cQueue.enQueue(1);
        // cQueue.deQueue();
        // cQueue.deQueue();
        // cQueue.enQueue(3);
        // cQueue.enQueue(1);
        // cQueue.enQueue(3);
        // cQueue.enQueue(1);
        // cQueue.enQueue(1);
        // System.out.println(cQueue.getSize());

    }

}
