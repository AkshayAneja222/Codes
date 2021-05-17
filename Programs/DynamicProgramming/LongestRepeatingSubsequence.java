package Programs.DynamicProgramming;

public class LongestRepeatingSubsequence {

	public static void lrs(String str) {
		String str1 = str, str2 = str, output="";
		int m=str1.length(), n=str2.length();
		int[][] arr = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++)
		{
			for(int j=1; j<=n ; j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1) && i!=j) {
					arr[i][j] = arr[i-1][j-1] + 1;
					output+=str1.charAt(i-1);
				}else {
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		
		System.out.println(arr[m][n]+" "+output);
	}

	public static void main(String[] args) {
		lrs("aabbcdc");
	}
}
