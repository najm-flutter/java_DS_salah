package others;
public class MyLinkedList {
    Node head;

    MyLinkedList() {
        head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        // head->next->he->fff
        if (head == null) {
            head = newNode;
            return;
        }

        Node currenNode = head;
        while (currenNode.next != null) {
            currenNode = currenNode.next;
        }
        currenNode.next = newNode;
    }

    public void printMy() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
    }

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;

    }

}
