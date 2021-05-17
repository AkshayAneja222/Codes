package Programs.DynamicProgramming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1 = "ABAC";
		String s2 = "ACLSJKBAC";
		
		System.out.println(longestCommonSubstring(s1, s2));

	}

	public static int longestCommonSubstring(String s1, String s2) {
		
		int ans = 0;
		
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		for(int i=0; i<=s1.length(); i++)
		{
			for(int j=0; j<=s2.length(); j++)
			{
				if(i==0 || j==0)
					dp[i][j] = 0;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1]+1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		return ans;
	}

}
/*
 * 		a b c d a d
 * a	1 0 0 0 0 0
 * b 	0 2 0 0 0 0
 * d 	0 0 0 1 0 1
 * a 	1 0 0 0 2 0
 * d 	0 0 0 1 0 3
 * f 	0 0 0 0 0 0
 * 
 */






