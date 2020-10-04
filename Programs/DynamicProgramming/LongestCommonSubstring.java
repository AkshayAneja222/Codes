package Programs.DynamicProgramming;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1 = "ABAC";
		String s2 = "ACLSJKBAC";
		
		System.out.println(longestCommonSubstring(s1, s2));

	}

	public static int longestCommonSubstring(String s1, String s2) {
		
		String ans = "";
		
		int[][] dp = new int[s1.length()][s2.length()];
		
		for(int i=0; i<s1.length(); i++)
		{
			for(int j=0; j<s2.length(); j++)
			{
				if(s1.charAt(i) == s2.charAt(j))
				{
					if(i==0 || j==0)
						dp[i][j]=1;
					else
						dp[i][j] = dp[i-1][j-1]+1;
					
					if(ans.length()<dp[i][j])
						ans = s1.substring(i+1-ans.length(), i+1);
				}
			}
		}
		return ans.length();
	}

}
