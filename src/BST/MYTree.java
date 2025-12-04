package BST;

public class MYTree {

    MyNode root;

    public MYTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    public void print() {
        printHelper(root);
    }

    public void printHelper(MyNode root) {
        if (root == null) {
            return;
        }

        printHelper(root.left);
        printHelper(root.right);
        System.out.println(root.data);

    }

    public MyNode insertHelper(MyNode root, int data) {
        if (root == null)
            return new MyNode(data);
        if (root.data < data) {
            root.right = insertHelper(root.right, data);
        } else if (root.data > data)
            root.left = insertHelper(root.left, data);

        return root;

    }
}