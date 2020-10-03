package Programs.DynamicProgramming;

import java.util.Scanner;

/*
 * Find the number of valid parentheses expressions of given length
 */

public class ValidParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0)
		{
			int num = sc.nextInt();
			if(num%2!=0)
				System.out.println(0);
			else
				System.out.println(getCatalan(num/2));
		}
		sc.close();
	}

	public static long getCatalan(int num) {
		
		long[] catalan = new long[num+1];
		
		catalan[0]=1;
		catalan[1]=1;
		
		for(int i=2;i<=num;i++)
		{
			for(int j=0;j<i;j++)
			{
				catalan[i]+=catalan[j]*catalan[i-j-1];
			}
		}
		
		return catalan[num];
		
	}
}
