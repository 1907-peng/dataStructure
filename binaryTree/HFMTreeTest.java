package dataStructure;

public class HFMTreeTest {
    public static void main(String args[]) {
        int n = 8;
        String str = "abcdefgh";
        int data[] = {5, 29, 7, 8, 14, 23, 3, 11};
        HFMTree ht = new HFMTree(n);
        ht.Init(data);
        ht.Create();
        ht.PrintTree();
        for (int i = 0; i < n; i++) {
            System.out.print(str.charAt(i) + ":");
            ht.PrintCode(i);
            System.out.println();
        }
    }
}
