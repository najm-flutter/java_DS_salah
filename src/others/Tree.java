package others;
public class Tree {
    NodeT root;

    public void insert(int data) {
        NodeT new_node = new NodeT(data);
        root = insertHelper(root, new_node);
    }

    /*
    
     */
    public NodeT insertHelper(NodeT root, NodeT node) {

        if (root == null) {
            root = node;
        } else if (root.data > node.data) {
            root.left = insertHelper(root.left, node);
        } else if (root.data < node.data) {
            root.right = insertHelper(root.right, node);
        }

        return root;
    }

    public void dispaly() {
        dispalyHelper(root);
    }

    public void dispalyHelper(NodeT root) {
        if (root != null) {
            dispalyHelper(root.right);
            System.out.println(root.data);
            dispalyHelper(root.left);
        }
    }
}

class NodeT {
    int data;
    NodeT left;
    NodeT right;

    NodeT(int data) {
        this.data = data;
        this.left = null;
        this.right = null;

    }
}