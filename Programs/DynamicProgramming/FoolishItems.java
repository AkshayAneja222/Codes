package Programs.DynamicProgramming;

import java.util.Scanner;

/*
 * maximum product of all elements that could sum upto a given number.
 */

public class FoolishItems {
	
	public static int getMaximumValue(int num, int[] dp)
	{
		if(num==0) return 0;
		if(num==1) return 1;
		
		if(dp[num]!=0)
		return dp[num];
		
		int ans = Integer.MIN_VALUE;
		
		int length = num/2;
		
		for(int i=1;i<=length;i++)
		{
			ans=Math.max(ans, Math.max(getMaximumValue(i, dp),i)*Math.max(getMaximumValue(num-i, dp),num-i));
		}
		
		dp[num]=ans;
		
		return ans;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[] dp = new int[101];
		dp[1] = 1;
		
		while(t-->0)
		{
			int num = sc.nextInt();
			System.out.println(getMaximumValue(num, dp));
		}
		sc.close();
	}
}
