package Queue;

import PublicClass.Messages;


import java.util.HashMap;
import java.util.Scanner;

enum  QUEUE_OPERATIONS{
    ENQUEUE ,
    DEQUEUE ,
    DISPLAY ,
    DELETE_ITEM,
    DEFAULT
}


enum  QUEUE_TYPES{
    QUEUE ,
    CQUEUE ,
    QUEUE_LINKED ,
    DEFAULT
}
public class QueueMain {
    public static void main(String[] args) {

    }

    public static void run(Scanner in){
        HashMap<Integer , QUEUE_OPERATIONS>  options = new HashMap<>()  ; HashMap<Integer , QUEUE_TYPES>  queueTypes = new HashMap<>() ;
        options.put(1 , QUEUE_OPERATIONS.ENQUEUE) ;
        options.put(2 , QUEUE_OPERATIONS.DEQUEUE) ;
        options.put(3 , QUEUE_OPERATIONS.DISPLAY) ;
        queueTypes.put(1 , QUEUE_TYPES.QUEUE) ;
        queueTypes.put(2 , QUEUE_TYPES.CQUEUE) ;
        queueTypes.put(3 , QUEUE_TYPES.QUEUE_LINKED) ;

        int choice;
        printMenuOptions();
        while ((choice = in.nextInt()) != 0) {

            switch (queueTypes.getOrDefault(choice, QUEUE_TYPES.DEFAULT)) {
                case QUEUE:
//                    staticStack(in, options);
                    break;
                case CQUEUE:
//                    dynamicStack(in, options);
                    break;
                case QUEUE_LINKED:
//                    dynamicStack(in, options);
                    break;
                default:
                    Messages.printInvalidOptionMessage();
                    break;
            }}
    }

    private static void printMenuOptions() {

    }
}
