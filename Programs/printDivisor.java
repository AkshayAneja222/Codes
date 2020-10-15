package Programs;

public class printDivisor {
	
	static void recurse(int n, int i){
		if(i*i<=n)
		{
			if(n%i==0)
				System.out.print(i+" ");
			
			recurse(n, i+1);
			
			if(n%i==0 && n/i!=i)
				System.out.print(n/i+" ");
		}
	}
	
	static void iterative(int n)
	{
		int i=1;
		for(i=1;i*i<=n;i++)
			if(n%i==0) System.out.print(i+" ");
		
		for(;i>=1;i--)
			if(n%i==0) System.out.print(n/i+" ");
	}

	
	public static void main(String[] args) {
		iterative(100);
		System.out.println();
		recurse(100, 1);
	}
}
