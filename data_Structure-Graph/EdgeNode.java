package dataStructure.graph;

public class EdgeNode {
    int adjvexindex;//邻接顶点的序号
    int data;//边的权值
    EdgeNode next;

    EdgeNode(int adj, int data) {
        next = null;       //与顶点节点相连的另外一个边缘节点的地址
        adjvexindex = adj;//为与这个节点相连的顶点节点
        this.data = data; //权值
    }
}