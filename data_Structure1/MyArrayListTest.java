package data_Structure1;
public class MyArrayListTest {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(0,1);
        list.add(5);
        list.add(7);
        list.add(-1);
        list.add(0, 3);
        list.add(2, 4);
        list.add(-6);
        list.remove(6);
        list.add(33);
        while (list.size()>0){
            System.out.println(list.remove(0));
        }

    }
}
