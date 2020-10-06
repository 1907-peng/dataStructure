package data_Structure1;
import java.lang.reflect.Array;

/*
 * 顺序线性表的定义及基本操作
 * 顺序线性表采用数组实现
 * 顺序线性表的属性有：数组，数组空间大小，元素个数 
 */
public class LinkedListTest {
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
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
