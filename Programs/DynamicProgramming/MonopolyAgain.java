package Programs.DynamicProgramming;

import java.util.Scanner;
/*
 * There are n nodes, each player can choose as many as X nodes from starting. Where 1<=X<=2*M
 * M is 1 initially
 * 
 * 5
 * 2 7 9 4 4
 * 
 * output : 10
 * 
 * M=1
 * 
 * I choose 2
 * Opp Choose 7 9
 * 
 * 
 * I choose 4 4
 * 
 * 4+4+2=10
 */


public class MonopolyAgain {
	
	public static int getMoney(int[] arr, int start, int end, int[][] dp, int m)
	{
		if(start+1==end)
			return Math.max(arr[start], arr[end]);
		
		int val1 = 0, val2 = 0;
		int prev1 = 0, prev2 = 0;
		
		for(int i=start; i<Math.min(end, 2*m); i++)
		{
			prev1+=arr[i];
			for(int j=end ;i>Math.max(i+1, 2*m); j++)
			val1 = prev1+ Math.min(getMoney(arr, i+2, j, dp, Math.max(i, m)), getMoney(arr, i+2, j, dp, Math.max(i, m)));
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		long[] arr = new long[num];
		
		for(int i=0;i<num;i++)
			arr[i]=sc.nextLong();
		
		
		
		sc.close();
	}
}
