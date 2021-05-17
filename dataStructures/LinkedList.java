package dataStructures;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

public class LinkedList{
	Node head;
	
	public void insertAtStart(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	
	public Node insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return newNode;
		}
		Node temp = head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newNode;
		return newNode;
	}
	
	public void insert(int num, int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp = head;
		while(temp!=null && temp.data!=num) 
			temp=temp.next;
		if(temp==null)
			return;
		newNode.next=temp.next;
		temp.next=newNode;
	}
	
	public void printList() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}System.out.println();
	}
	
	public void delete(int data) {
		if(head==null)
			return;
		Node temp = head, prev = null;
		while(temp!=null && temp.data!=data) {
			prev=temp;
			temp=temp.next;
		}
		if(temp==null) return;
		if(temp==head) {
			head=head.next;
			return;
		}
		prev.next=temp.next;
		
	}
	
	public Node reverseLinkedList(Node p, Node c) {
		Node prev=p, current=c, nxt=null;
		
		while(current!=null) {
			nxt=current.next;
			current.next=prev;
			prev=current;
			current=nxt;
		}
		return prev;
	}

	private Node reverseRecursively(Node prev, Node curr) {
		if(curr.next == null)
		{
			curr.next = prev;
			return curr;
		}
	
		Node temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr= temp;	
		
		return reverseRecursively(prev, curr);
	}

	public void reverseRecursively() {
		head = reverseRecursively(null, head);
	}


	public void midOfLL() {
		Node fast = head, slow = head;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		System.out.println("mid is "+slow.data);
	}
	
	public void reverseOfSize(int k) {
		head = reverseOfSize(k, null, head);
	}

	public Node reverseOfSize(int k, Node p, Node h)
	{
		if(h==null)
			return h;
		Node prev = p, curr = h;
		int count = 0;
		
		while(count<k && curr!=null)
		{
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count++;
		}
		h.next = reverseOfSize(k, null, curr);
		return prev;
	}
	
	public boolean hasCycle()
	{
		Node node = head, fast = head;
		while(node!=null && fast.next!=null)
		{
			System.out.print(node.data+"->");
			node = node.next;
			fast = fast.next.next;
			if(fast == node) return true;
		}
		return false;
	}

	public void removeCycle() {
		Node node = head, fast = head, prev = null;
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
	
	public void sgtEvenOdd()
	{
		Node odd = head, even = head;
		
		while(odd!=null && even!=null)
		{
			if((even.data&1)==0)
			{
				int temp = odd.data;
				odd.data = even.data;
				even.data = temp;
				
				odd = odd.next;
			}
			even = even.next;
		}
	}
	
	public void pairWiseSwap()
	{
		Node first = head, second = head.next, prev = null;
		
		while(first!=null && second!=null)
		{
			first.next = second.next;
			second.next = first;

			if(prev==null)
				head = second;
			else
				prev.next = second;
			
			prev = first;
			first = first.next;
			
			if(first!=null)
				second = first.next;
			else
				second = null;
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);
		ll.insertAtEnd(8);
		 
		ll.pairWiseSwap();
		
		ll.printList();
	}
}
