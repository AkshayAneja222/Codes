package Programs.Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimMST {
	
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        
        boolean[] visited = new boolean[V];
        int[] key = new int[V];
        int[] answer = new int[V];
        
        Arrays.fill(key, Integer.MAX_VALUE);
        
        key[0] = 0;
        answer[0] = -1;
        
        for(int loop=1; loop<=V-1; loop++)
        {
            int min_index = -1, min = Integer.MAX_VALUE;
            
            for(int v=0; v<V; v++)
            {
                if(!visited[v] && key[v]<min)
                {
                    min = key[v];
                    min_index = v;
                }
            }
           // System.out.println("min index: "+min_index);
            
            visited[min_index] = true;
            
            for(int v=0; v<V; v++)
            {
                if( graph.get(min_index).get(v)!=0 && !visited[v] && graph.get(min_index).get(v)<key[v] )
                {
                    answer[v] = min_index;
                    key[v] = graph.get(min_index).get(v);
                   // System.out.println("v: "+v+"  answer[v]: "+answer[v]+"  key[v]: "+key[v]);
                }
            }
        }
        
        int ans = 0;
        
        for(int i=1;i<V;i++)
        ans+=graph.get(i).get(answer[i]);
        
        return ans;
    }
    
    public static void main(String[] args) {
		int v = 3;
		int e = 3;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(5);
		a.add(1);
		list.add(a);
		
		ArrayList<Integer> a1 = new ArrayList<>();
		a1.add(5);
		a1.add(0);
		a1.add(3);
		list.add(a1);
		
		ArrayList<Integer> a2 = new ArrayList<>();
		a2.add(1);
		a2.add(3);
		a2.add(0);
		list.add(a2);
		
		System.out.println("min spanning tree: "+spanningTree(v, e, list));
	}
}

/*
 * 
Input:
2
3 3
0 1 5 1 2 3 0 2 1
2 1
0 1 5

Output:
4
5
 * 
 * 
 */

