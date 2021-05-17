package Programs.Graph;

import java.util.HashSet;

import dataStructures.Graph_Adjacency_List;

public class DetectCycleUndirectedGraph {
	
	static boolean hasCycle(Graph_Adjacency_List graph, HashSet<Integer> visited, Integer vertix, Integer parent)
	{
		visited.add(vertix);
		
		for(Integer neighbour : graph.getNeighbours(vertix))
		{
			if(!visited.contains(neighbour))
			{
				if(hasCycle(graph, visited, neighbour, vertix)) return true;
			}
			else if(parent != neighbour) return true;
		}
		
		return false;
	}
	
	static boolean hasCycle(Graph_Adjacency_List graph)
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for(Integer vertix : graph.getVertices())
		{
			if(!visited.contains(vertix))
				if(hasCycle(graph, visited, vertix, -1)) 
					return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Graph_Adjacency_List graph = new Graph_Adjacency_List(false);
		graph.addEdge(10, 20);
		graph.addEdge(10, 40);
		graph.addEdge(20, 30);
		
		System.out.println("Graph:\n"+graph.toString());
		
		System.out.println("Graph hasCycle?: "+hasCycle(graph));
	}
}
