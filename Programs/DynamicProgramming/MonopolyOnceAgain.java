package Programs.DynamicProgramming;

import java.util.Scanner;

public class MonopolyOnceAgain {
	
    static long sum(int arr[], int start, int end)  
    {
        long sum = 0;  
        for (int i = start; i <= end; i++) 
        {  
            sum += arr[i];  
        }
        return sum;
    }  
	
	public static long getMoney(int[] arr, int num, int start, int end, int k, long[][] dp)
	{
		if(start-end+1<=k) return sum(arr, start, end);
		
		if(dp[start][end]!=0) return dp[start][end];
		
		long sum = sum(arr, start, end);
		
		long ans = 0;
		
		for(int i=0; i<=k; i++)
		{
			//int sumTillHere = sum(arr, i+start, i+end-k);
			ans = Math.max(ans, sum - getMoney(arr, num, i+start, i+end-k, k, dp));
		}
			
		dp[start][end]=ans;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++)
			arr[i]=sc.nextInt();
		
		long[][] dp = new long[num][num];
		
		System.out.println(getMoney(arr, num, 0, arr.length-1, k, dp));
		
		sc.close();
	}
}
