package dataStructures;

public class DisjointSetDataStructure {
	
	private int V;
	private int[] rank, parent;
	DisjointSetDataStructure(int V)
	{
		this.V = V;
		rank = new int[V];
		parent = new int[V];
		
		for(int i=0;i<V;i++)
			parent[i]=i;
	}
	
	public int find(int x)
	{
		if(parent[x]!=x)
		return parent[x] = find(parent[x]);
		return x;
	}
	
	public void union(int x, int y)
	{
		int x_rep = find(x);
		int y_rep = find(y);
		
		if(x_rep==y_rep)
		{
			System.out.println("Adding this edge will cause Cycle");
			return;
		}
		
		if(rank[x] < rank[y])
		{
			parent[x]=y;
		}
		else if(rank[x] > rank[y])
		{
			parent[y]=x;
		}else
		{
			parent[x]=y;
			rank[y]++;
		}
	}
	
}
