package Programs.DynamicProgramming;

import java.util.Scanner;

/*
 * given a nXm matrix where you have to choose choclate from each row
 * but u can choose a choclate from (i+1)th with a catch that 
 * it is from different section from that of (i)th section.
 * 
 * sections are decided on the basis of M/3
 * 
 */

public class MaximumChoclate {
	
	static class Ignore
	{
		int x;
		int y;
		Ignore(int x, int y)
		{
			this.x=x;
			this.y=y;
		}
		Ignore(){}
	}
	
    public static long maxSweetness(int[][] arr, int n, int m, Ignore ignore, int len, long[][] dp)
    {
      if(len==n)
      return 0;
      
      long ans = 0;
      
      Ignore ignoreTemp = null;
      
      for(int j=0;j<m;j++)
      {
      	if(j<ignore.x || j>ignore.y)
      	{
	    	if(j%(m/3)==0)
	    	{
	    		ignoreTemp =  new Ignore(j, j+(m/3)-1);
	    	}

        	long curr;
       	
        	if(dp[len][j]!=0) {
        		curr = dp[len][j];
        	}
        	else {
        		curr = arr[len][j] + maxSweetness(arr, n, m, ignoreTemp, len+1, dp);
        		dp[len][j]=curr;
        	}
            ans =  Math.max(curr, ans);
    	}
      }
      return ans;
    }	
	
	public static void main(String[] args) {

	      Scanner sc = new Scanner(System.in);
	      
	      int n = sc.nextInt();
	      int m = sc.nextInt();
	      
	      int[][] arr = new int[n][m];
	      
	      for(int i=0;i<n;i++)
		      for(int j=0;j<m;j++)
			      arr[i][j]=sc.nextInt();
	      
	      long[][] dp = new long[n][m];
	      
		System.out.println(maxSweetness(arr, n, m, new Ignore(-1, -1), 0, dp));

	      sc.close();
	}
}
