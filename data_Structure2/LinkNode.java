package data_Structure2;

/*
 * 结点
 * 含有一个整型数值，一个引用类型，相当于C语言中的指针
 */
public class LinkNode {
	private int data;   //结点中存放一个整型的值
	private LinkNode next;   //下一个结点的引用
	//默认构造方法，值为0，下一个结点为空
	LinkNode()
	{
		data = 0;
		next = null;		
	}
	//带一个参数的构造方法
	LinkNode(int data)
	{
		this.data = data;
		next = null;
	}
	//get和set方法
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
}
