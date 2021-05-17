package Programs.LinkedList;

public class MiddleOfLL {
	
	static class NodeClass{
		int data;
		NodeClass next;
		NodeClass(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public static void removeCycle(NodeClass head) {
		NodeClass node = head, fast = head, prev = null;
		while(node!=null && fast.next!=null)
		{
			node = node.next;
			fast = fast.next.next;
			if(fast == node)
			{
				break;
			}
		}
		
		if(node==null || fast.next==null)
			return;
		
		node = head;
		while(node!=fast) {
			node = node.next;
			prev = fast;
			fast = fast.next;
		}
		prev.next = null;
	}
	
	static void printList(NodeClass head) {
		for(NodeClass node = head; node!=null; node=node.next)
			System.out.print(node.data+"->");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		NodeClass node = new NodeClass(1);
		NodeClass node2 = new NodeClass(2);
		NodeClass node3 = new NodeClass(3);
		NodeClass node4 = new NodeClass(4);
		NodeClass node5 = new NodeClass(5);
		
		node.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node2;
		
		removeCycle(node);
		printList(node);
	}
}
