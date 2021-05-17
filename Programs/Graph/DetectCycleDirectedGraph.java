package Programs.Graph;

import dataStructures.Graph_Matrix_Representation;

public class DetectCycleDirectedGraph {

	static boolean hasCycle(Graph_Matrix_Representation graph)
	{
		int[] visited = new int[graph.getSize()];
		int[] recurVisited = new int[graph.getSize()];
		
		for(int vertices=0; vertices<graph.getSize(); vertices++) 
		{
			if(visited[vertices] == 0)
			if(hasCycle(graph, vertices, visited, recurVisited)) return true;
		}
		return false;
	}
	
	static boolean hasCycle(Graph_Matrix_Representation graph, int source, int[] 
	visited, int[] recurVisited)
	{
		System.out.println("source "+source);
		visited[source] = 1;
		recurVisited[source] = 1;
		
		int[] neighbours = graph.getNeighbours(source);
		for(int neighbour=0; neighbour<graph.getSize(); neighbour++)
		{
			if(neighbours[neighbour] == 1)
			if(visited[neighbour] == 0 && hasCycle(graph, neighbour, visited, recurVisited))
					return true;
			else if(recurVisited[neighbour] == 1)
					return true;
		}
		recurVisited[source] = 0;
		return false;
	}
	
	public static void main(String[] args) {
		Graph_Matrix_Representation graph = new Graph_Matrix_Representation(5, true);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		//graph.addEdge(4, 2);
		
		System.out.println("Graph:\n"+graph.toString());
		
		System.out.println("hasCycle?: "+hasCycle(graph));
	}
}
