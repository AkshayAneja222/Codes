package Programs.DynamicProgramming;
/*
 *	A person i cheats from a person j
 * 	then we draw a line segment between them. We need to find the number of ways in which N
 *	people giving the exam(in a circular table) can cheat in pairs provided there is no crossover (Two lines intersecting each other).
 *	
 *	find the number of possible ways to cheat without any intersection.
 */

import java.util.Scanner;

public class NumberOfPossibleArrangements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	      int t = sc.nextInt();
	      
	      while(t-->0)
	      {
	        int num = sc.nextInt();
	        
	        num/=2;
	        
	        long[] dp = new long[num+1];
	        
	        dp[0]=1;
	        dp[1]=1;
	        
	        for(int i=2;i<=num;i++)
	        {
	          for(int j=0;j<i;j++)
	          {
	            dp[i]+=dp[j]*dp[i-j-1];
	          }
	        }
	        
	        System.out.println(dp[num]);
	      }
	      
	      sc.close();
	    
	}

}
