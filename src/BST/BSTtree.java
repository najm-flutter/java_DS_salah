package BST;

public class BSTtree {
    TNode root;

    public BSTtree() {
        root = null;
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    public TNode insertHelper(TNode node, int data) {
        if (node == null) {
            return new TNode(data);
        }
        if (node.getData() < data) {
            node.setRigth(insertHelper(node.getRigth(), data));
        }
        if (node.getData() > data) {
            node.setLeft(insertHelper(node.getLeft(), data));
        } else if (node.getData() == data)
            node.count++;
        return node;
    }

    public void deleteNode(int data) {
        root = deleteHeleper(root, data);
    }

    public TNode deleteHeleper(TNode node, int data) {
        if (node == null) {
            return null;
        }
        if (node.getData() < data) {
            node.setRigth(deleteHeleper(node.getRigth(), data));
        } else if (node.getData() > data) {
            node.setLeft(deleteHeleper(node.getLeft(), data));
        } else if (node.count > 1) {
            node.count--;
        } else if (node.hasLift() && node.hasRight()) {
            int minData = min(node.getRigth());
            node.setData(minData);
            node.setRigth(deleteHeleper(node.getRigth(), minData));
        } else if (node.hasLift() || node.hasRight()) {
            TNode deleteNode = node;
            node = node.hasLift() ? node.getLeft() : node.getRigth();
            deleteNode = null;
        } else {
            node = null;
        }

        return node;
    }

    public int min(TNode node) {
        if (!node.hasLift()) {
            return node.getData();
        }
        return min(node.getLeft());

    }

    public void display() {
        System.out.println("InOrder");
        displayInOrder(root);
        System.out.println("---------");
        System.out.println("PreOrder");
        displayPreOrder(root);
        System.out.println("---------");
        System.out.println("PostOrder");
        displayPostOrder(root);

    }

    public void displayInOrder(TNode node) {
        if (node == null) {
            return;
        }
        displayInOrder(node.getLeft());
        System.out.println(node);
        displayInOrder(node.getRigth());
    }

    public void displayPreOrder(TNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        displayInOrder(node.getLeft());
        displayInOrder(node.getRigth());
    }

    public void displayPostOrder(TNode node) {
        if (node == null) {
            return;
        }
        displayInOrder(node.getLeft());
        displayInOrder(node.getRigth());
        System.out.println(node);

    }

}
