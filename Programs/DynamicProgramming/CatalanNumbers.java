package Programs.DynamicProgramming;
/*
 * find the catalan number
 * 
 * using DP:
 * 			1 create an array and traverse thru to get catalan array while storing prev values. O(n2)
 * 
 * using binomial coefficient:
 * 			2 1/(num+1)*(2nCn)
 * 
 */
public class CatalanNumbers {

	public static int usingDP(int num)
	{
		int catalan[] = new int[num+2];
		
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
	
	public static int nCr(int n, int r)
	{	
		if(r>n-r)
		n= n-r;
		
		int ans = 1;
		for(int i=0;i<r;i++)
		{
			ans*=(n-i);
			ans/=(i+1);
		}
		
		return ans;
	}
	
	public static int usingBinomialCoefficient(int num)
	{
		// catalan number for binomial coefficient is 1/(num+1)*(2nCn)
		int ans = nCr(2*num, num);
		return ans/(num+1);
	}
	
	public static void main(String[] args) {
		System.out.println(usingDP(10));
		System.out.println(usingBinomialCoefficient(10));
	}
}
