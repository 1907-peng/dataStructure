package data_Structure2;

public class LinkListMerge {
	public static void main(String[] args) {
		LinkList LA = new LinkList();
		LinkList LB = new LinkList();
		LA.Insert_I_E_List(1, 5);
		LA.Insert_I_E_List(2, 6);
		LA.Insert_I_E_List(3, 7);
		LA.Insert_I_E_List(4, 8);
		LA.Print_LinkList();
		LB.Insert_I_E_List(1, 4);
		LB.Insert_I_E_List(2, 6);
		LB.Insert_I_E_List(3, 10);
		LB.Insert_I_E_List(4, 15);
		LB.Print_LinkList();
		
		LinkList LC = new LinkList();
		Merge_LinkList(LA,LB,LC);
		
		LC.Print_LinkList();

	}

	private static void Merge_LinkList(LinkList LA, LinkList LB, LinkList LC) {
		LinkNode pointer = LA.getHead();
		for(int i=1;i<=LA.size;i++) {
			pointer = pointer.getNext();
		}
		pointer.setNext(LB.getHead().getNext());  //将链表A和B链接起来

		
		int[] arr = new int[LA.size+LA.size];
		pointer  = LA.getHead().getNext();
		for(int i=0;i<arr.length;i++) {
			arr[i] = pointer.getData();
			pointer = pointer.getNext();
		}
		for(int i = 0;i < LA.size+LB.size;i++) {
			for(int j = 0;j<LA.size+LB.size-i-1;j++) {
				int temp=0;
				if(arr[j]<arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		for(int i =0;i<LA.size+LB.size;i++)
		LC.Insert_I_E_List(i+1, arr[i]);
		
	}

}
    
