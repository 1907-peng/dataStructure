package data_Structure2;
/*
 * 链表
 * 在此为单链表
 */

public class LinkList implements List{
	private LinkNode Head;   //头结点，以后没有特别说明，建立的都有带头结点的链表
	int size = 0;
	
	//get和set方法
	public LinkNode getHead() {
		return Head;
	}
	public void setHead(LinkNode head) {
		Head = head;
	}
	//默认构造方法，也是单链表的初始化
	LinkList()
	{
		Init_List();
	}
	 
    public void Init_List() { //创建了一个为空值de头节点
	   Head = new LinkNode();
	}
	 
	
	//单链表的基本操作
	public void Insert_I_E_List(int i,int e){//单链表第i位置插入值为e的结点
		LinkNode current ;
		LinkNode previous ;
		LinkNode newNode = new LinkNode(e);
		if(i<1 || i>size+1) {
			
			System.out.println("位置不合法，插入失败");
			
		}else
			
		if(i==1 && Head.getNext()==null){	//插在头节点的后面且链表只有头节点一个节点
			Head.setNext(newNode);
			size++;
			
		}else 
			if(i==size+1 && Head.getNext()!=null){		//此处是指将新节点插在最后
			LinkNode pointer  = Head;
			while(pointer.getNext()!=null) {
				pointer = pointer.getNext();
			}
			
			pointer.setNext(newNode);
			size++;
			
			
		}else{
			
			current = Head.getNext();	//这里是指插在链表中间，不包括链表尾部
			previous = Head;
			
			for(int j = 1;j < i; j++){
				previous = current;			 //1 -> i-1
				current = current.getNext(); //2 -> i
			}
			
			newNode.setNext(current);
			previous.setNext(newNode);
			size++;
		}
			
	}
	
	public void Print_LinkList(){ //输出链表
		LinkNode pointer = Head.getNext();
		while( pointer != null ){
			System.out.print(pointer.getData()+" ");
			pointer = pointer.getNext();
		}
		System.out.println("");
	}
	
	public void Delete_I_List(int i){//单链表删除第i位置的结点
		LinkNode current = Head.getNext();
		LinkNode previous = Head;
		
		if(i<=size) {
			
			for(int j = 0;j < i-1;j++){
				previous = current;
				current = current.getNext();
			}
		previous.setNext(current.getNext());
		current = null;
		previous = null;
		size--;
		}else {
			System.out.println("位置不合法，删除失败");
		}
	}
	
	public void Update_I_E_List(int i,int e){ //单链表的修改（将第i个结点的值改为e）
		LinkNode pointer = Head;
		if(i<=size) {
		for(int j = 1 ;j <=i ; j++) {
			pointer = pointer.getNext();
		}
		pointer.setData(e);
		}else {
			System.out.println("位置不合法，修改失败");
		}
	}
	
	public LinkNode Search_I_List(int i){ //单链表查询第i位置的结点，如果不存在，返回null
		LinkNode pointer = Head;
		if(i<0 || i>size) {
			return null;
		}
		else {
			for(int j = 0;j < i-1 ;j++) {
				pointer = pointer.getNext();
			}
			return pointer;
		}
		
	}
	
	public int Search_E_List(int e){//单链表中第一次出现值为e的位置，如果没有，返回0
		LinkNode pointer  = Head;
		int flag = 0;
		int temp = 0;	//用来储存找到的值
		for(int i = 1; i <= size+1; i++) {
			if(pointer.getData()==e) {
				flag = 1;
				temp = i;
				break;
			}
		    pointer = pointer.getNext();
		}
		if(flag==1) {
			return temp;
		}
		else
		{
			return 0;
		}
		
	}



	public void Insert_H_List(int e) {//单链表开头插入值为e的结点
		LinkNode newNode= new LinkNode(e);
		newNode.setNext(Head);
		Head = newNode;
	}

	public void Insert_R_List(int e) {//单链表尾部插入值为e的结点
		LinkNode pointer = Head;
		LinkNode newNode = new LinkNode(e);
		while(pointer.getNext()!=null) {
			pointer = pointer.getNext();
		}
		pointer.setNext(newNode);
		newNode.setNext(null);
	}
}

