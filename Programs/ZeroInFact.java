package Programs;
/*
 * count of trailing zeroes in a factorial of a number.
 */
public class ZeroInFact {

	public static int countZeroes( int n)
	{
		int loop=5, ans = 0;
		
		for(loop=5;loop<=n;loop*=5)
		{
			ans+=(n/loop);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(countZeroes(15));
	}

}
