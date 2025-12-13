package BST;

public class MainTree {
    public static void main(String[] args) {
        BSTtree bTtree = new BSTtree();
        bTtree.insert(2);
       
        bTtree.deleteNode(2);
        bTtree.display();

    }
}
