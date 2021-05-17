package Programs.Tree;

public class IsBst {
	
	static class wrapAns{
		int answer=Integer.MIN_VALUE;
	}
	
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
	//using range to find if each node follows the condition or not? 
	static boolean isBstRangeMethod(Node node, int left, int right)
	{
		if(node == null) return true;
		return (node.data>left && node.data<right && isBstRangeMethod(node.left, left, node.data) && isBstRangeMethod(node.right, node.data, right));
	}
	
	
	static boolean isBstInorderMethod(Node node, wrapAns ans) {
		if(node == null) return true;
		
		if(!isBstInorderMethod(node.left, ans))
			return false;
		if(node.data<ans.answer) return false;
		ans.answer = node.data;
		return isBstInorderMethod(node.right, ans);
	}
	
	public static void main(String[] args) {
		Node head = new Node(50);
		head.left = new Node(30);
		head.right = new Node(70);	
		head.left.left = new Node(20);
		head.left.right = new Node(40);
		head.right.left = new Node(60);
		head.right.right = new Node(80);
		head.right.left.left = new Node(55);
		head.right.left.right = new Node(65);
		
		wrapAns ans = new wrapAns();
		
		boolean val = isBstInorderMethod(head, ans);
		System.out.println(val);
	}
	
}
