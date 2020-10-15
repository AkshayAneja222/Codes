package Programs;

public class PatternSearching {
	public static void main(String[] args) {
		rabinCarp("aaaaaaaaab", "aab");
	}
	
	
	public static void knuthMorrisPrat(String str, String ptr) {
		
	}
	
	
	public static void rabinCarp(String str, String ptr){
		int strLen = str.length();
		int ptrLen = ptr.length();
		int hashStr=0, hashPtr=0, d=256;
		int base = 1;
		int limit = 1000000007;
		
		//base = 256 power m-1
		for(int i=1;i<=ptrLen-1;i++)
			base= (base*d)%limit;
		
		//if d=10, 10*prev_value+char_ascii
		for(int i=0;i<ptrLen;i++)
		{
			hashPtr = (d*hashPtr + ptr.charAt(i))%limit;
			hashStr = (d*hashStr + str.charAt(i))%limit;
		}
		
		for(int i=0;i<=strLen-ptrLen;i++)
		{
			//System.out.println("str pattern: "+hashStr+" ptr pattern: "+hashPtr);
			//when hash values are equal we need to check both string are equal.
			if(hashPtr == hashStr)
			{
				int j = 0;
				for(j=0;j<ptrLen;j++) {
					if(str.charAt(j+i)!=ptr.charAt(j)) {
						break;
					}
				}
				if(j==ptrLen) System.out.println("pattern found at: "+(i));
			}
			if(i<strLen-ptrLen) 
			{
				hashStr = (d*(hashStr - str.charAt(i)*base) + (str.charAt(i+ptrLen)))%limit;
				
				if(hashStr<0)
					hashStr+= limit;
			}
		}
	}
	
	
	public static void naiveApproach(String str, String ptr) {
		int strLen = str.length();
		int ptrLen = ptr.length();
		boolean flag = false;
		
		for(int i=0;i<=strLen-ptrLen;i++)
		{
			int j=0, strIndex=i;
			while(j<ptrLen && str.charAt(strIndex)==ptr.charAt(j))
			{
				j++;
				strIndex++;
				if(j==ptrLen) {
					System.out.println("pattern found at position : "+(i+1));
					flag = true;
				}
			}
		}
		if(!flag)System.out.println("pattern doesnot exist");
	}
	
}
