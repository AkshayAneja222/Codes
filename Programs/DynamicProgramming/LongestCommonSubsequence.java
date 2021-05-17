package Programs.DynamicProgramming;

import java.util.ArrayDeque;

public class LongestCommonSubsequence {
	
	//naive solution
	public static int getLCS_Naive(String str1, String str2, int m, int n)
	{
		if(m==0 || n==0) return 0;
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) 
			return 1+getLCS_Naive(str1, str2, m-1, n-1);
		else
			return Math.max(getLCS_Naive(str1, str2, m-1, n), getLCS_Naive(str1, str2, m, n-1));
	}
	
	
	//using memorization in naive solution 
	public static int getLCS_Optimized_Naive(String str1, String str2, int m, int n, int mem[][])
	{
		if(mem[m][n] != -1) return mem[m][n];
		
		if(m==0 || n==0) 
			mem[m][n] = 0;
		else if(str1.charAt(m-1) == str2.charAt(n-1)) 
			mem[m][n] = 1 + getLCS_Optimized_Naive(str1, str2, m-1, n-1, mem);
		else
			mem[m][n] = Math.max(getLCS_Optimized_Naive(str1, str2, m-1, n, mem), getLCS_Optimized_Naive(str1, str2, m, n-1, mem));
		
		return mem[m][n];
	}
	
	//tabloid method for O(n*m)
	public static int getLCS_Tabloid_Method(String str1, String str2, int m, int n, int[][] arr)
	{
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1))
					arr[i][j] = arr[i-1][j-1]+1;
				else
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		return arr[m][n];
	}
	
	
	static void printStringFromTable(String str1, String str2, int m, int n, int[][] arr)
	{
		int i=m, j=n;
		ArrayDeque<Character> deque = new ArrayDeque<Character>();
		
		while(i>0 && j>0)
		{
			//System.out.println("i:"+i+" j:"+j);
			if(str1.charAt(i-1) == str2.charAt(j-1))
			{
				deque.addLast(str1.charAt(i-1));
				i--;
				j--;
			}
			else if(arr[i-1][j] > arr[i][j-1])
				i = i-1;
			else
				j = j-1;
		}
		
		System.out.println("string is :");
		while(!deque.isEmpty())
			System.out.print(deque.pollLast()+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		String str1 = "bbaabb", str2 = "behabi";
		
		int m=str1.length(), n=str2.length();
		/*
		int[][] mem = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++)
				mem[i][j] = -1;
		
		int ans = getLCS_Naive(str1, str2, m, n);
		
		System.out.println("naive soln "+ans);
		
		int ans1 = getLCS_Optimized_Naive(str1, str2, m, n, mem);
		
		System.out.println("optimized naive soln "+ans1);

		*/
		int[][] arr = new int[m+1][n+1];
		
		System.out.println(getLCS_Tabloid_Method(str1, str2, m, n, arr));
		
		printStringFromTable(str1, str2, m, n, arr);
	}
}
