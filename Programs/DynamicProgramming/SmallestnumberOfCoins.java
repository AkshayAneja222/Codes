package Programs.DynamicProgramming;

/*
 * min num of coins required to make exact x change
 */
public class SmallestnumberOfCoins {
	
	public static int getSmallestCount(int x, int[] coins, int[] dp)
	{
		if(x==0) return 0;
		if(x==1) return 1;
		int min = x;
		
		for(int coin : coins)
		{
			if(x-coin>=0)
			if(dp[x-coin]>0) 
				min = Math.min(min, dp[x-coin]);
			else 
			{
				dp[x-coin]=getSmallestCount(x-coin, coins, dp);
				min = Math.min(min, dp[x-coin]);
			}
			
		}
		return min+1;
	}
	
	public static void main(String[] args) {
		int x = 37;
		int[] coins = {25, 10, 5, 1};
		
		int[] dp = new int[x];
		
		System.out.println(getSmallestCount(x, coins, dp));
	}
}
