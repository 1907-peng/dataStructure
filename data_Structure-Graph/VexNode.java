package dataStructure.graph;

public class VexNode {
    Vex vex;
    int indegree;       //顶点的入度数
    EdgeNode firstedge;//顶点的邻接边

    VexNode(Vex vex) {
        this.vex = vex;
        firstedge = null;
    }
}