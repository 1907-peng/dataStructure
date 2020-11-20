package dataStructure;

/*
 * 哈夫曼树结点
 */
public class HFMTreeNode {
    private int weight;  //权值
    private int parent;  //父结点所在的下标
    private int lchild;  //左孩子所在的下标
    private int rchild;  //右孩子所在的下标

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getLchild() {
        return lchild;
    }

    public void setLchild(int lchild) {
        this.lchild = lchild;
    }

    public int getRchild() {
        return rchild;
    }

    public void setRchild(int rchild) {
        this.rchild = rchild;
    }

    public HFMTreeNode() {
        weight = 0;
        parent = -1;
        lchild = -1;
        rchild = -1;
    }
}
