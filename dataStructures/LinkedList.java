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
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head=newNode;
			return;
		}
		Node temp = head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=newNode;
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
	
	public void reverseLinkedList() {
		Node prev=null, current=head, nxt=null;
		
		while(current!=null) {
			nxt=current.next;
			current.next=prev;
			prev=current;
			current=nxt;
		}
		head=prev;
		
	}

	
}
