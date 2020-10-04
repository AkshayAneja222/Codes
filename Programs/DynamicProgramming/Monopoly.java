package Programs.DynamicProgramming;

/*
 * a game in which you can choose a coin from either side of row
 * your opponent will also choose the maximum coin from either side
 * you have to select in a manner so as to increase the over all value
 * 
 * 	6
 *	19 10 23 24 66 79
 *
 *	output : 122
 *
 *	10
 *  1 3 5 7 9 10 8 11 4 10
 * 
 * 	output : 41
 * 
 */

import java.util.Scanner;

public class Monopoly {
	
	public static long amountOfMoney(long[] arr, int start, int end, long[][] dp)
	{
		if(end==start+1)
			return Math.max(arr[start], arr[end]);
		
		if(dp[start][end]!=0) return dp[start][end];
		
		long val1 = arr[start]+Math.min(amountOfMoney(arr, start+2, end, dp), amountOfMoney(arr, start+1, end-1, dp));
		
		long val2 = arr[end]+Math.min(amountOfMoney(arr, start+1, end-1, dp), amountOfMoney(arr, start, end-2, dp));
		
		dp[start][end] = Math.max(val1, val2);
		
		return dp[start][end];
	}
	
	public static long amountOfMoney(long[] arr, int start, int end, long sum, int turn, long[][] dp)
	{
		if(start>end)
			return sum;
		
		long val = 0;
		
		if(turn %2 ==0)
		{
			if(arr[start]>arr[end])
				start++;
			else
				end--;
			val = amountOfMoney(arr, start, end, sum, turn+1, dp);
		}
		else
		{
			if(dp[start][end]==0) {
				long val1 = amountOfMoney(arr, start+1, end, sum+arr[start], turn+1, dp);
				long val2 = amountOfMoney(arr, start, end-1, sum+arr[end], turn+1, dp);
				dp[start][end] = Math.max(val1, val2);				
			}
			
			val = dp[start][end];
		}
		
		return val;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0)
		{
			int num = sc.nextInt();
			long[] arr = new long[num];
			
			for(int i=0;i<num;i++)
				arr[i]=sc.nextInt();
			
			long[][] dp = new long[num][num];
			
			System.out.println(amountOfMoney(arr, 0, arr.length-1, dp));
		}
		
		sc.close();
	}
}
