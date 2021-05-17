package dataStructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph_Adjacency_List {
	
	private Map<Integer, LinkedList<Integer>> AdjacencyList = new HashMap<>();
	
	private boolean Directed = false;
	
	public Graph_Adjacency_List() {}
	
	public Graph_Adjacency_List(boolean Directed) {
		this.Directed = Directed;
	}
	
	public Set<Integer> getVertices(){
		return AdjacencyList.keySet();
	}
	
	public void addVertex(Integer source) {
		AdjacencyList.put(source, new LinkedList<Integer>());
	}
	
	public void addEdge(Integer source, Integer destination) {
		if(!AdjacencyList.containsKey(source))
			addVertex(source);
		
		AdjacencyList.get(source).add(destination);
		
		if(!Directed)
		{
			if(!AdjacencyList.containsKey(destination))
				addVertex(destination);
			
			AdjacencyList.get(destination).add(source);
		}
	}
	
	public Integer size() {
		return AdjacencyList.size();
	}
	
	public boolean hasVertex(Integer vertex) {
		return AdjacencyList.containsKey(vertex);
	}
	
	public LinkedList<Integer> getNeighbours(Integer vertex){
		return AdjacencyList.get(vertex);
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for(Integer vertex : AdjacencyList.keySet())
		{
			stringBuilder.append(vertex+": ");
			for(Integer neighbor : AdjacencyList.get(vertex))
			{
				stringBuilder.append(neighbor+" ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
