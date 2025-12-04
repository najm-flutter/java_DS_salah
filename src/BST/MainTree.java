package BST;

public class MainTree {
    public static void main(String[] args) {
        MYTree tree = new MYTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);

        tree.print();

    }
}
