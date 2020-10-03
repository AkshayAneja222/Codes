package Programs;

public class BinomialCoefficient {

	public static int nCr(int n, int r)
	{
		int ans = 1;
		
		if(r>n-r)
			r=n-r;
		
		for(int i=0;i<r;i++)
		{
			ans*=(n-i);
			ans/=(i+1);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		System.out.println(nCr(4, 2));
		
	}
}
