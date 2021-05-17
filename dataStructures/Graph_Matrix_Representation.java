package dataStructures;

public class Graph_Matrix_Representation {
	
	private Integer size;
	private int[][] AdjacencyMatrix;
	private boolean directed = false;
	
	public Graph_Matrix_Representation(){
		this.size = 12;
		AdjacencyMatrix = new int[size][size];
	}
	
	public Graph_Matrix_Representation(Integer size){
		this.size = size;
		AdjacencyMatrix = new int[size][size];
	}
	
	public Graph_Matrix_Representation(Integer size, boolean directed) {
		this.size = size;
		this.directed = directed;
		AdjacencyMatrix = new int[size][size];
	}
	
	public void addEdge(Integer source, Integer destination) {
		AdjacencyMatrix[source][destination] = 1;
		if(!directed)
		AdjacencyMatrix[destination][source] = 1;
	}
	
	public int[] getNeighbours(Integer source) {
		return AdjacencyMatrix[source];
	}

	public Integer getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int vertex=0; vertex<size; vertex++)
		{
			stringBuilder.append(vertex+": ");
			for(int neighbours=0; neighbours<size; neighbours++) 
			{
				if(AdjacencyMatrix[vertex][neighbours] == 1)
				{
					stringBuilder.append(neighbours+" ");
				}
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
