package Programs.Tree;

public class fixBSTtwoNodeSwapped {

	private static class Node{
		Node left, right;
		int data;
		Node(int data)
		{
			left = null;
			right = null;
			this.data = data;
		}
	}

	static Node first = null, second = null, prev = null;


	static void fixBst(Node node)
	{
		if(node == null) return;
		fixBst(node.left);
		if(prev!=null && node.data < prev.data)
		{
			if(first == null)
				first =prev;
			second = node;
		}
		prev = node;
		fixBst(node.right);
	}

	
	public static void InOrder(Node node)
	{
		if(node!=null)
		{
			InOrder(node.left);
			System.out.print(node.data+" ");
			InOrder(node.right);
		}
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(80);
		head.left = new Node(30);
		head.right = new Node(70);
		head.left.left = new Node(20);
		head.left.right = new Node(40);
		head.right.left = new Node(60);
		head.right.right = new Node(50);
		head.right.left.left = new Node(55);
		head.right.left.right = new Node(65);
	
		fixBst(head);
		System.out.println(first.data+" "+second.data);
		
		//InOrder(head);
	}
}
