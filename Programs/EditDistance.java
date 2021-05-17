package Programs;

public class EditDistance {

	static int getDistance(String str1, String str2, int m, int n, int[][] mem) {
		
		if(m==0) return mem[m][n] = n;
		if(n==0) return mem[m][n] = m;
		
		if(mem[m][n]!=0) return mem[m][n];
		
		if(str1.charAt(m-1) == str2.charAt(n-1)) {
			mem[m][n] = getDistance(str1, str2, m-1, n-1, mem);
		}
		else {
			mem[m][n] = 1 + Math.min(getDistance(str1, str2, m-1, n, mem), 
					Math.min(getDistance(str1, str2, m, n-1, mem), getDistance(str1, str2, m-1, n-1, mem)));
		}
		return mem[m][n];
	}
	
	public static void main(String[] args) {
		String s1 = "abcd", s2 = "zwesa";
		
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		
		System.out.println(getDistance(s1, s2, s1.length()
				, s2.length(), mem));
	}

}
