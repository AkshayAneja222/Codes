package Programs;

import java.util.Arrays;

public class EfiicientIsPrime {
	//Idea is that every prime number can be represted as 6n-1, 6n+1
	//why check even numbers
	//just check if a number is div by other prime numbers or not
	static boolean isPrime(long num) {
		if(num==1)
			return false;
		if(num==2 || num==3)
			return true;
		
		if(num%2==0 || num%3==0)
			return false;
		
		for(int value=5; value*value<=num; value+=6)
			if(num%value==0 || num%(value+2)==0)
				return false;
		
		return true;
	}
	
	 
	// all the primes that are less than that gievn number 
	static void allPrimeLessThanN(int n){
		
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		
		for(int p=2;p*p<=n;p++)
		{
			if(isPrime(p))
			{
				for(int i=p*p; i<=n; i+=p)
					prime[i]=false;
			}
		}
		
		for(int i=2;i<=n;i++)
			if(prime[i])
				System.out.print(i+" ");
		System.out.println();
	}
	
	
	static void power(int a, int b)
	{
		int i=b;
		long ans=1;
		while(i>=1)
		{
			if((i&1)==0)
			{
				i-=2;
				ans*=(a*a);
			}
			else
			{
				if(i==1) {
					i-=1;
					ans*=a;
				}
				else {
					i-=3;
					ans*=(a*a)*a;
				}
			}
		}
		System.out.println("ans "+ans);
	}
	
	public static void main(String[] args) {
		/*
		 * System.out.println("11 is prime? "+isPrime(11));
		 * System.out.println("111 is prime? "+isPrime(111));
		 * System.out.println("1111 is prime? "+isPrime(1111));
		 */
		//allPrimeLessThanN(131);
		power(10,9);
	}
}
