package Programs;

public class BitMagic {

	// Brian and Kerningham algorithm to get count of set bits. Big-O(set_bits)
	static int getSetBits(int num) {
		int ans = 0;
		while (num > 0) {
			num = (num & (num - 1));
			ans++;
		}
		return ans;
	}

	// power by 2?
	static boolean powOf2(int num) {
		return (num != 0) && (num & (num - 1)) == 0;
	}

	// find only odd occurring number in a list.
	/*
	 * approach is to use XOR as a ^ 0 = a (a^b)^c = a^(b^c)
	 */
	static int onlyOddOccurringNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++)
			ans ^= arr[i];
		return ans;
	}

	// Given the list of N elements from 1 to N+1. Find the missing element.
	/*
	 * The idea is to get answer in O(N) time.
	 */
	static int getMissingElement(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++)
			ans ^= arr[i];
		return ans;
	}

	// find two odd occurring elements in list.
	/*
	 * list = 32 7 7 31
	 * 
	 * xor = 32 31 => 100000^011111 => 111111
	 * 
	 * first set bit = 0..01 xor-1 = 111110 ~(xor-1) = 000001
	 * 
	 * xor & ~(xor-1) = 0..01 (rsb)
	 * 
	 * loop: will divide in two groups using: rsb & arr[i] ==1/0
	 * 
	 */
	static void getTwoOddOccurringElements(int[] arr) {
		int xor = 0, val1 = 0, val2 = 0, rightmostSetBit = 0;

		for (int i = 0; i < arr.length; i++)
			xor ^= arr[i];

		rightmostSetBit = xor & ~(xor - 1);

		for (int i = 0; i < arr.length; i++) {
			if ((rightmostSetBit & arr[i]) == 0)
				val1 = val1 ^ arr[i];
			else
				val2 = val2 ^ arr[i];
		}
		System.out.println("Two odd occuring elements are: " + val1 + " " + val2);
	}

	
	
	/*
	 * 000 001 010 011 100 101 110 111
	 * 
	 * "", "a", "b", "c",.....
	 * 
	 * time complexity: O(2^n * n), n = length of input string
	 */
	static void getPowerSet(String str)
	{
		int len = str.length();
		int setLen = (int)Math.pow(2, len);
		
		for(int i=0;i<=setLen;i++)
		{
			for(int j=0;j<len;j++)
			{
				if((i&(1<<j))>0)
				{
					System.out.print(str.charAt(j));
				}
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		
		 System.out.println("Set bits in 198 are "+getSetBits(198));
		 System.out.println("only odd occurring number in list is "+onlyOddOccurringNumber(new int[]{100, 100, 7, 7, 101}));
		 System.out.println("missing element in list is "+getMissingElement(new int[]{1,2,3,4,5,7}));
		 getTwoOddOccurringElements(new int[]{10, 11, 11, 14, 14, 10, 5, 458});
		 getPowerSet("abc");
		 
	}

}
