package Programs.Tree;

import java.util.TreeSet;

public class FloorAndCeilInBST {
	
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
	
	
	static void ceilLeftSideArray(int[] arr)
	{
		TreeSet<Integer> selfBalancingTree = new TreeSet<Integer>();
		selfBalancingTree.add(arr[0]);
		System.out.print("-1 ");
		
		for(int i=1;i<arr.length;i++)
		{
			Integer ans = selfBalancingTree.ceiling(arr[i]);
			if(ans!=null)
				System.out.print(ans+" ");
			else
				System.out.print("-1 ");
			selfBalancingTree.add(arr[i]);
		}
	}
	
	static void getCeil(Node head, int num)
	{
		Node node = head;
		int ans = -1;
		while(node!=null)
		{
			if(node.data == num)
			{
				ans = node.data;
				break;
			}

			if (node.data > num)
			{
				ans = node.data;
				node = node.left;
			}
			else
				node = node.right;
		}
		System.out.println("floor of "+num+" in tree is "+(ans>=num?ans:-1));
	}
	
	static void getFloor(Node head, int num)
	{
		Node node = head;
		int ans = -1;
		while(node!=null)
		{
			if(node.data == num)
			{
				ans = node.data;
				break;
			}

			if (node.data > num)
				node = node.left;
			else
			{
				ans = node.data;
				node = node.right;
			}
		}
		System.out.println("floor of "+num+" in tree is "+(ans<=num?ans:-1));
	}
	
	
	public static void main(String[] args) {
		/*
		Node head = new Node(50);
		head.left = new Node(30);
		head.right = new Node(70);
		head.left.left = new Node(20);
		head.left.right = new Node(40);
		head.right.left = new Node(60);
		head.right.right = new Node(80);
		head.right.left.left = new Node(55);
		head.right.left.right = new Node(65);
		
		getCeil(head, 38);
		getCeil(head, 10);
		getCeil(head, 50);
		getCeil(head, 90);
		*/
		ceilLeftSideArray(new int[] {2, 8, 30, 15, 25, 12});	
	}
}
