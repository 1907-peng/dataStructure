package dataStructure.graph;

import java.util.Scanner;

public class ALGraph {
    VexNode[] vextex;//存顶点数组
    int vexnum;
    int edgenum;
    boolean isdirection;

    ALGraph(int vexnum, int edgenum, boolean isdirection) {
        this.vexnum = vexnum;
        this.edgenum = edgenum;
        this.isdirection = isdirection;
        vextex = new VexNode[vexnum];  //该数组用来指向顶点节点  vextex[0]指向第一个顶点
        create_Graph();
    }


    private void create_Graph() {
        int i, j, k, vi, vj;
        char ch;
        Scanner in = new Scanner(System.in);
        System.out.println("请使用一行连续输入图的" + this.vexnum + "顶点名称字符如ABCD...：");
        char[] vname = in.nextLine().toCharArray();
        //初始化顶点表
        for (i = 0; i < vexnum; i++) {
            vextex[i] = new VexNode(new Vex(vname[i]));
        }
        //初始化邻接表
        System.out.println("请输入" + edgenum + "边信息，使用顶点的序号输入，如(i,j)为第i顶点到第j顶点的边的权值，输入i j weight,第一个顶点序号为0：");
        EdgeNode p;
        int w = 0;
        for (i = 0; i < edgenum; i++) {
            vi = in.nextInt(); //顶点
            vj = in.nextInt(); //边节点
            w = in.nextInt();  //权值
            //完善代码
            //如果为有向图
            if (isdirection) {
                p = vextex[vi].firstedge;
                if (p == null) {
                    vextex[vi].firstedge = new EdgeNode(vj, w);
                    p = vextex[vj].firstedge;
                } else {
                    while(true){
                        if(p.next == null)
                            break;
                        p = p.next;
                    }
                    p.next = new EdgeNode(vj,w);

                }

            }

            //如果为无向图
            if (!isdirection) {
                //完善代码
                p = vextex[vi].firstedge;
                if (p == null) {
                    vextex[vi].firstedge = new EdgeNode(vj, w);
                } else {
                    while(true){
                        if(p.next == null)
                            break;
                        p = p.next;
                    }
                    p.next = new EdgeNode(vj, w);
                }

                p = vextex[vj].firstedge;
                if (p == null) {
                    vextex[vj].firstedge = new EdgeNode(vi, w);
                } else {
                    while(true){
                        if(p.next == null)
                            break;
                        p = p.next;
                    }
                    p.next = new EdgeNode(vi, w);
                }
            }
        }

    }

    public void pntGraph() {
        EdgeNode p;
        for (int i = 0; i < vexnum; i++) {
            System.out.print(vextex[i].vex.vname + " ");
            //完善代码
            p = vextex[i].firstedge;

            while (p != null) {
                System.out.print("->" + p.adjvexindex);
                p = p.next;
            }
            System.out.println("^");
        }
    }

}