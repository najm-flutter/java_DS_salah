package BST;

public class TNode {
    private int data;
    private TNode left;
    private TNode rigth;
    private TNode pref;
    int count = 1;

    public TNode getPref() {
        return pref;
    }

    public void setPref(TNode pref) {
        this.pref = pref;
    }

    public TNode(int data) {
        this.data = data;
        rigth = left = pref = null;
    }

    public int getData() {
        return this.data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRigth() {
        return this.rigth;
    }

    public void setRigth(TNode rigth) {
        this.rigth = rigth;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean hasLift() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.rigth != null;
    }

    public boolean isFree() {
        return (!hasLift() && !hasRight());
    }

    @Override
    public String toString() {
        return "[" + data + ":" + count + "]";
    }

}
