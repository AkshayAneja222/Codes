package Programs.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.Graph_Adjacency_List;

public class ShortestPathUnweightedGraph {

	private static class StoreValue{
		int value, distance;
		StoreValue(int value, int distance){
			this.value = value;
			this.distance = distance;
		}
	}
	
	static void printShortestPath(Graph_Adjacency_List graph, Integer source) {
		
		HashSet<Integer> set = new HashSet<>();
		Queue<StoreValue> queue = new LinkedList<StoreValue>();
		
		queue.add(new StoreValue(source, 0));
		set.add(source);
		
		while(!queue.isEmpty())
		{
			StoreValue temp = queue.poll();
			int dis = temp.distance;
			
			System.out.println(temp.value+": "+temp.distance);
			
			for(int val : graph.getNeighbours(temp.value))
			{
				if(!set.contains(val))
				{
					queue.add(new StoreValue(val, dis+1));
					set.add(val);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph_Adjacency_List graph = new Graph_Adjacency_List(true);
		graph.addEdge(10, 20); 
		graph.addEdge(10, 40); 
		graph.addEdge(20, 10); 
		graph.addEdge(20, 30); 
		graph.addEdge(20, 40);
		graph.addEdge(30, 20); 
		graph.addEdge(30, 40); 
		graph.addEdge(40, 10); 
		graph.addEdge(40, 20); 
		graph.addEdge(40, 30);
		
		System.out.println("Graph:\n"+graph.toString());
		
		printShortestPath(graph, 10);
	}
}
