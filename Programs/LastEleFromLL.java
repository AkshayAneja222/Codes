package Programs;
class linkNode{
	int data;
	linkNode next;
	linkNode(int data){
		this.data = data;
		this.next=null;
	}
}

public class LastEleFromLL {
	public static void main(String[] args) {
		linkNode head = new linkNode(5);
		linkNode ln = new linkNode(6);
		linkNode ln2 = new linkNode(7);
		linkNode ln3 = new linkNode(8);
		linkNode ln4 = new linkNode(9);
		linkNode ln5 = new linkNode(10);
		
		head.next=ln;
		ln.next=ln2;
		ln2.next=ln3;
		ln3.next=ln4;
		ln4.next=ln5;
		
		int count=0;
		linkNode advance = head;
		while(advance!=null) {
			count++;
			if(count==3)
				break;
			advance=advance.next;
		}
		
		linkNode slow = head;
		while(advance.next!=null) {
			slow=slow.next;
			advance=advance.next;
		}
		System.out.println(slow.data);
		
		
	}
}
