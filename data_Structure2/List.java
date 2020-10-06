package data_Structure2;

public interface List {
	//单链表的初始化（带头结点）
	public void Init_List();
	
	//单链表开头插入值为e的结点
	public void Insert_H_List(int e);
	
	//单链表尾部插入值为e的结点
	public void Insert_R_List(int e);
	
	//单链表第i位置插入值为e的结点
	public void Insert_I_E_List(int i,int e);
	
	//单链表删除第i位置的结点
	public void Delete_I_List(int i);
	
	//单链表中第一次出现值为e的位置，如果没有，返回0
	public int Search_E_List(int e);
	
	//单链表查询第i位置的结点，如果不存在，返回null
	public LinkNode Search_I_List(int i);
	
	//单链表的修改（将第i个结点的值改为e）
	public void Update_I_E_List(int i,int e);
}