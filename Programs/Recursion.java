package Programs;

public class Recursion {
	//maximum number of cuts of length = (a,b,c) in a rope of size n
	static int maximumRopeCuts(int n, int a, int b, int c){
		if(n<0) return -1;
		if(n==0) return 0;
		
		int ans = 0;

		ans = Math.max(ans, maximumRopeCuts(n-a, a, b, c));
		ans = Math.max(ans, maximumRopeCuts(n-b, a, b, c));
		ans = Math.max(ans, maximumRopeCuts(n-c, a, b, c));
		
		if(ans == -1) return ans;
		return ans+1;
	}
	
	
	//towerOfHanoi
	static void towerOfHanoi(int n, char a, char b, char c) {
		if(n<=0) return;
		towerOfHanoi(n-1, a, c, b);
		System.out.println("move disk "+n+" from tower "+a+" to "+c);
		towerOfHanoi(n-1, b, a, c);
	}
	
	
	//subset sum
	static void subsetSum(int[] arr, int sum)
	{
		System.out.println(subsetSum(arr, sum, 0));
	}
	
	static int loopCount= 0;
	static int subsetSum(int[] arr, int sum, int level)
	{
		loopCount++;
		if(level == arr.length)
			return sum==0?1:0;
		
		if(sum<0) return 0;
		
		int val = 0;
		
		if(sum-arr[level]>=0)
		{
			val+= subsetSum(arr, sum-arr[level], level+1);
		}
		
		if(sum>=0)
		{
			val+= subsetSum(arr, sum, level+1);
		}
		return val;
	}
	
	public static void main(String[] args) {
		//System.out.println(maximumRopeCuts(5, 2, 1, 5));
		//towerOfHanoi(3, 'a', 'b', 'c');
		subsetSum(new int[] {14, 1, 12, 3, 4}, 15);
		System.out.println(loopCount);
	}
}
