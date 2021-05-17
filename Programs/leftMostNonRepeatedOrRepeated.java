package Programs;


public class leftMostNonRepeatedOrRepeated {

	static void leftmostRepeated(String str) {
		final int CHARS = 256;
		boolean[] visited = new boolean[CHARS];
		int ans = 0;
		
		for(int i=str.length()-1;i>=0;i--)
		{
			if(visited[str.charAt(i)])
				ans=i;
			else
				visited[str.charAt(i)]=true;
		}
		
		System.out.println(str.charAt(ans));
	}
	
	
	static void leftmostNonRepeated(String str) {
		final int CHARS = 256;
		int[] count = new int[CHARS];
		
		for(int i=0;i<CHARS;i++)
			count[i]=-1;
		
		for(int i=0;i<str.length()-1;i++) {
			if(count[str.charAt(i)]==-1)
				count[str.charAt(i)]=i;
			else
				count[str.charAt(i)]=-2;
		}
		
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<CHARS;i++) {
			if(count[i]>=0)
			{
				ans=Math.min(ans, count[i]);
			}
		}
		System.out.println(str.charAt(ans));
	}
	
	public static void main(String[] args) {
		leftmostNonRepeated("akshay");
	}
}
