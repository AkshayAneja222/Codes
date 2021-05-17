package Programs.Tree;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class verticalSum {
	
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

	
	
	static void updateMapVerticalSum(Node node, int val, LinkedHashMap<Integer, Integer> map) {
		if(node==null) return;
		
		updateMapVerticalSum(node.left, val-1, map);
		map.put(val ,node.data+map.getOrDefault(val, 0));
		updateMapVerticalSum(node.right, val+1, map);
	}
	
	
	
	static void printMap(LinkedHashMap<Integer, Integer> map)
	{
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer, Integer> entry = itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
	
	
	static void verticalElements(Node head, int val, TreeMap<Integer, LinkedList<Integer>> map)
	{
		if(head == null)return;
		
		LinkedList<Integer> list = map.getOrDefault(val, new LinkedList<Integer>());
		list.add(head.data);
		map.put(val, list);

		verticalElements(head.left, val-1, map);
		verticalElements(head.right, val+1, map);
	}
	
	
	
	static void printTreeMap(TreeMap<Integer, LinkedList<Integer>> map)
	{
		Iterator<Map.Entry<Integer, LinkedList<Integer>>> itr = map.entrySet().iterator();
		while(itr.hasNext())
		{
			LinkedList<Integer> list = itr.next().getValue();
			for(Integer val : list)
				System.out.print(val+" ");
			System.out.println();
		}
	}
	
	
	
	static void topView(Node node, int val, LinkedHashMap<Integer, Integer> map)
	{
		if(node == null) return;
		
		if(!map.containsKey(val))
			map.put(val, node.data);
		topView(node.left, val-1, map);
		topView(node.right, val+1, map);
	}
	
	
	
	static void downView(Node node, int val, TreeMap<Integer, Integer> map)
	{
		if(node != null)
		{
			downView(node.left, val-1, map);
			map.put(val, node.data);
			downView(node.right, val+1, map);
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
		//head.right.left.left = new Node(55);
		//head.right.left.right = new Node(65);
		
		/*
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		
		updateMapVerticalSum(head, 0, map);
		printMap(map);
		
		TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
		verticalElements(head, 0, map);
		printTreeMap(map);
		
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		topView(head, 0, map);
		printMap(map);
		*/
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		downView(head, 0, map);
		
		Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext())
			System.out.println(itr.next().getValue());
	}
}
