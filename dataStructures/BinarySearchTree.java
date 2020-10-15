package dataStructures;

public class BinarySearchTree {
	Node root;
	
	
	private static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	void insert(int data) {
		if(root!=null) {
			root=insertHelper(root,data);
		}
	}
	private Node insertHelper(Node root,int data) {
		if(root ==null) {
			Node node = new Node(data);
			return node;
		}else {
			if(root.data<data) {
				root.right=insertHelper(root.right,data);
			}else {
				root.left=insertHelper(root.left,data);
			}
		}
		return root;
	}
	
	public void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	public Node getPredecessor(Node root) {
		while(root.right!=null)
			root=root.right;
		return root;	
		}	
	
	public void Delete(int data) {
		if(root!=null) {
			root=deleteHelper(root,data);
		}
		else {
			return;
		}
	}
	
	private Node deleteHelper(Node root, int data) {
		if(root.data==data) {
			if(root.left==null && root.right==null)
				return null;
			else if(root.left==null && root.right!=null)
				return root.right;
			else if(root.right==null && root.left!=null)
				return root.left;
			else {
				Node pre= getPredecessor(root.left);
				root.data=pre.data;
				root.left=deleteHelper(root.left,pre.data);
				return root;
			}
		}else {
			if(root.data<data) {
				root.right=deleteHelper(root.right,data);
			}else {
				root.left=deleteHelper(root.left,data);
			}
		}
		return root;
	}
	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		Node node= new Node(4);
		bst.root=node;
		bst.root.left=new Node(1);
		bst.root.right=new Node(7);
		bst.root.left.left=new Node(0);
		bst.root.left.right=new Node(3);
		bst.root.right.right=new Node(8);
		bst.insert(5);
		
		System.out.println("before deletion: ");
		bst.inorder(bst.root);
		System.out.println();
		bst.Delete(4);
		bst.insert(2);
		System.out.println("after insertion: ");
		bst.inorder(bst.root);
		
		
	}
	
}
