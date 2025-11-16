package Stack;

import LinkedList.LinkedListDS;;

public class StackLinked extends LinkedListDS {
    StackLinked() {
        super();
    }

    public void push(int item) {
        addFirst(item);
    }

    public int pop() {
        return deleteFirst();
    }

}
