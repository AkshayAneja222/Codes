package Programs;

import java.util.*;

class MinFallingPath
 {
	
    public int minFallingPathSum(int[][] a) {

    	int ans = 1000000000;
    	
    	boolean[][] visited = new boolean[a.length][a[0].length];
    	int[][] value = new int[a.length][a[0].length];
    	
    	for(int j=0;j<a[0].length;j++)
    	{
    		ans = Math.min(minFallingPathSumImpl(a, 0, j, visited, value), ans);
    	}
    	return ans;
    }
	
    
	public int minFallingPathSumImpl(int[][] a, int i, int j, boolean[][] visited, int[][] value) {
		
		if(j==-1 || j>=a[0].length)
			return 1000000000;
		
		if(i==a.length)
			return 0;
		
		if(visited[i][j])
			return value[i][j];
		
		visited[i][j]=true;
		
		int ans = 1000000000;
		
		ans = Math.min(ans, minFallingPathSumImpl(a, i+1, j-1, visited, value)+a[i][j]);
		
		ans = Math.min(ans, minFallingPathSumImpl(a, i+1, j+1, visited, value)+a[i][j]);
		
		value[i][j]=ans;
		
		return ans;
	}

	
	public static void main (String[] args)
	 {
    	int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
    	
    	System.out.println(new MinFallingPath().minFallingPathSum(arr));
	 }
}