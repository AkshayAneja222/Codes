package Programs.DynamicProgramming;

public class LongestSquareSubmatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,0,0,0,0},{1,1,0,0,0},{1,1,1,0,0},{1,1,1,0,0},{1,1,1,0,0}};
		
		int[][] dp = new int[arr.length][arr[0].length];
		
		int max = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[i][j]==1)
				{
					if(i==0 || j==0)
						dp[i][j]=1;
					else
					{
						if(dp[i-1][j]>0 && dp[i][j-1]>0 && dp[i-1][j-1]>0)
						{
							int min = Math.min(dp[i-1][j], dp[i][j-1]);
							min = Math.min(dp[i-1][j-1], min);
							dp[i][j]=min+1;
						}else
						{
							dp[i][j]=1;
						}
					}
					if(max < dp[i][j]) max = dp[i][j];
				}
			}
		}
		System.out.println(max);
	}

}
