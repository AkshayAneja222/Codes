import java.util.LinkedList;
import java.util.Queue;

class binarynode{
	int data;
	binarynode left;
	binarynode right;
	binarynode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class IsBinaryTree {
	public static void main(String[] args) {
		binarynode root = new binarynode(4);
		binarynode a1 = new binarynode(2);
		binarynode a2 = new binarynode(7);
		binarynode a3 = new binarynode(1);
		binarynode a4 = new binarynode(3);
		binarynode a5 = new binarynode(5);
		binarynode a6= new binarynode(5);
		
		root.left=a1;
		root.right=a2;
		a1.left=a3;
		a1.right=a4;
		a2.left=a5;
		a2.right=a6;
		
		System.out.println(isBinaryTree(root));
	}

	private static boolean isBinaryTree(binarynode root) {
		
		Queue<binarynode> q = new LinkedList<binarynode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			binarynode current = q.poll();
			if(current.left!=null)
			if(current.data<current.left.data) {
				return false;
			}
			if(current.right!=null)
			if (current.data>current.right.data) {
				return false;
			}
			if(current.left!=null)
			q.add(current.left);
			if(current.right!=null)
			q.add(current.right);
		}
		
		return true;
	}
}
