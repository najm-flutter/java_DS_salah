package Queue;

import LinkedList.LinkedListDS;
import PublicClass.Node;

public class QueueLinked  {
    Node front , rear ;
    public QueueLinked() {
        front = rear = null ;
    }

    public void  enQueue(int item){
         Node new_node = new Node(item) ;
          if (front== null){
              front = rear = new_node ;
              return;
          }
          rear.next = new_node ;
          rear = new_node ;

    }
    public void  deQueue(int item){

        if (rear== null){
            System.out.println("Is Empty");
            return;
        }
        front = front.next ;
    }
    public  void display(){
        if(front==null|| rear == null){
            return;
        }
        Node tmp =  front ;
        while (tmp!=null){
            System.out.print(tmp.data +"-->");
            tmp = tmp.next ;
        }
        System.out.print("null");
    }
}
