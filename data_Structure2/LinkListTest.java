package data_Structure2;

public class LinkListTest {
	public static void main(String[] args) {
		
		LinkList L = new LinkList();
		
		L.Insert_I_E_List(1, 5);
		L.Print_LinkList();
		
		L.Insert_I_E_List(2, 6);
		L.Print_LinkList();
		
		L.Insert_I_E_List(1, 7);
		L.Print_LinkList();
		
		L.Insert_I_E_List(7, 8);
		L.Print_LinkList();
		
		L.Delete_I_List(5);
		L.Print_LinkList();
		
		L.Delete_I_List(2);
		L.Print_LinkList();
		
		L.Update_I_E_List(1, 8);
		L.Print_LinkList();
		
		L.Update_I_E_List(4, 10);
		L.Print_LinkList();
		
		LinkNode p;
		int loc = 3;  
		p = L.Search_I_List(loc);
		if(p!=null)
		System.out.println("位置"+loc+"的值为："+p.getData());
		else
			System.out.println("不存在位置为"+loc+"的结点");
		int e = 1;
		loc = L.Search_E_List(e);
		if(loc==0)
			System.out.println("没有找到值为"+e+"的结点");
		else
		System.out.println("值为"+e+"的结点的位置为："+loc);
		e = 6;
		loc = L.Search_E_List(e);
		if(loc==0)
		System.out.println("没有找到值为"+e+"的结点");
		else
			System.out.println("值为"+e+"的结点的位置为："+loc);
	}
}
