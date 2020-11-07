package dataStructure.graph;

public class ALGraphTest {
    public static void main(String[] args) {
        ALGraph alg1 = new ALGraph(4, 4, false);
        alg1.pntGraph();
        ALGraph alg2 = new ALGraph(5, 7, false); //完善代码
        alg2.pntGraph();
        ALGraph alg3 = new ALGraph(4, 4, true);//完善代码
        alg3.pntGraph();
    }
}