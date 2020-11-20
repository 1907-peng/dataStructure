package dataStructure;
public interface IHFMTree {

    // 哈夫曼树的初始化(将数组data中的权值依次赋值给哈夫曼树的相应结点)
    public void Init(int data[]);

    // 哈夫曼树的创建过程(在指定范围中查询父结点为-1的最小的两个结点，生成父结点)
    public void Create();

    // 输出哈夫曼树
    public void PrintTree();

    // 输出第i个结点的哈夫曼编码
    public void PrintCode(int i);
}
