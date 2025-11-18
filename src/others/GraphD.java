package others;
import java.util.*;

public class GraphD {
    ArrayList<LinkedList<NodeG>> alist;

    GraphD() {
        alist = new ArrayList<>();
    }

    public void addNode(NodeG node) {
        LinkedList<NodeG> nodeGs = new LinkedList<>();
        nodeGs.add(node);
        alist.add(nodeGs);
    }

    public void addEdge(int frst, int sec) {
        alist.get(frst).add(alist.get(sec).getFirst());
    }

    public void myPrint() {
        for (LinkedList<NodeG> linkedList : alist) {
            for (NodeG itemG : linkedList) {
                System.out.print(itemG.data + "-> ");
            }
            System.out.println();
        }
    }
}
