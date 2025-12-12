package BST;

public class BSTtree {
    TNode root;

    public BSTtree() {
        root = null;
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    public TNode insertHelper(TNode root, int data) {
        if (root == null) {
            return new TNode(data);
        }
        if (root.getData() < data) {
            root.setRigth(insertHelper(root.getRigth(), data));
        }
        if (root.getData() > data) {
            root.setLeft(insertHelper(root.getLeft(), data));
        } else if (root.getData() == data)
            root.count++;
        return root;
    }

    public void display() {
        displayInOrder(root);
        System.out.println("-------");
        displayPreOrder(root);
        System.out.println("-------");

        displayPostOrder(root);
    }

    public void displayInOrder(TNode root) {
        if (root == null) {
            return;
        }
        displayInOrder(root.getLeft());
        System.out.println(root);
        displayInOrder(root.getRigth());
    }

    public void displayPreOrder(TNode root) {
        if (root == null) {
            return;
        }
        displayInOrder(root.getLeft());
        displayInOrder(root.getRigth());
        System.out.println(root);
    }

    public void displayPostOrder(TNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        displayInOrder(root.getLeft());
        displayInOrder(root.getRigth());
    }

}
