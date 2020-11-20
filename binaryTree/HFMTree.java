package dataStructure;

import javax.swing.text.html.HTMLEditorKit;

/*
 * 哈夫曼树
 */
public class HFMTree implements IHFMTree {
    //属性
    private int n;   //叶子结点数
    private HFMTreeNode[] HFMArra;  //结点数组

    //get和set方法
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public HFMTreeNode[] getHFMArra() {
        return HFMArra;
    }

    public void setHFMArra(HFMTreeNode[] hFMArra) {
        HFMArra = hFMArra;
    }

    //构造方法（给哈夫曼树分配结点数n的结点，大小为2n-1，注意每个结点要创建对象）
    public HFMTree(int n) {
        setN(n);
        HFMArra = new HFMTreeNode[2 * n - 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            HFMArra[i] = new HFMTreeNode();
        }

    }

    //哈夫曼树的初始化(将数组data中的权值依次赋值给哈夫曼树的相应结点)
    public void Init(int data[]) {
        for (int i = 0; i < data.length; i++) {
            HFMArra[i].setWeight(data[i]);
        }
    }

    //哈夫曼树的创建过程(在指定范围中查询父结点为-1的最小的两个结点，生成父结点)
    public void Create() {
        int m1, m2, x1, x2;
        for (int i = 0; i < n - 1; ++i) {
            m1 = m2 = Integer.MAX_VALUE;
            x1 = x2 = 0;
            for (int j = 0; j < n + i; ++j) {
                if ((HFMArra[j].getWeight() < m1) && (HFMArra[j].getParent() == -1)) {
                    m2 = m1;
                    x2 = x1;
                    m1 = HFMArra[j].getWeight();
                    x1 = j;
                } else if ((HFMArra[j].getWeight() < m2) && (HFMArra[j].getParent() == -1)) {
                    m2 = HFMArra[j].getWeight();
                    x2 = j;
                }
            }
            HFMArra[n + i].setWeight(HFMArra[x1].getWeight() + HFMArra[x2].getWeight());
            HFMArra[n + i].setLchild(x1);
            HFMArra[n + i].setRchild(x2);
            HFMArra[x1].setParent(n + i);
            HFMArra[x2].setParent(n + i);
        }
    }

    //输出哈夫曼树（即输出各结点的值）
    public void PrintTree() {
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.println(i + "\t" +"权值："+ HFMArra[i].getWeight() + "\t" +"左孩子："+ HFMArra[i].getLchild() + "\t" +"右孩子："+ HFMArra[i].getRchild() + "\t" +"父亲："+ HFMArra[i].getParent());
        }
    }

    //输出第i个结点的哈夫曼编码（左孩子输出0，右孩子输出1）
    public void PrintCode(int i) {
        String str = "";
        int temp = i;
        while (HFMArra[temp].getParent() != -1) {
            if (HFMArra[HFMArra[temp].getParent()].getLchild() == temp) {
                str = "0" + str;
            }
            if (HFMArra[HFMArra[temp].getParent()].getRchild() == temp) {
                str = "1" + str;
            }
            temp = HFMArra[temp].getParent();
        }
        System.out.println(str);
    }
}
