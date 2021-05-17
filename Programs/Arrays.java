package Programs;

public class Arrays {
	
	static void removeDuplSortedAray(int[] arr)
	{
		int size = 0, len = arr.length;
		for(int i=1;i<len;i++)
		{
			if(arr[i]!=arr[size]) {
				arr[++size]=arr[i];
				arr[i]=0;
			}
			else
				arr[i]=0;
		}
		
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	
	static void moveZerosToEnd(int[] arr)
	{
		int size = -1;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
				int temp = arr[i];
				arr[i] = 0;
				arr[++size]=temp;
			}
		}

		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();		
	}
	
	
	
	static void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	static void rotateArrayByD(int[] arr, int D) {
		int start=0, end=D-1;
		while(start<end) {
			swap(arr, start, end);
			start++;
			end--;
		}
		
		start=D;
		end=arr.length-1;
		while(start<end) {
			swap(arr, start, end);
			start++;
			end--;
		}
		
		start=0;
		end=arr.length-1;
		while(start<end) {
			swap(arr, start, end);
			start++;
			end--;
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();				
	}
	
	
	static void MaximumDifference(int[] arr){
		int ans = arr[1]-arr[0], minVal=arr[0];
		
		for( int i=1; i<arr.length;i++)
		{
			ans = Math.max(ans, arr[i]-minVal);
			minVal = Math.min(minVal, arr[i]);
		}
		System.out.println(ans);
	}

	
	static void freqSortedArray(int[] arr){
		int count=1;
		for(int i=1;i<arr.length;i++){
			if(arr[i]!=arr[i-1])
			{
				System.out.println(arr[i-1]+" "+count);
				count=1;
			}
			else
			{
				count++;
			}
		}
		System.out.println(arr[arr.length-1]+" "+count);
	}
	
	
	//kadane's algorithm
	static void maxSubArray(int[] arr)
	{
		int sumTillHere=arr[0], max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			sumTillHere = Math.max(arr[i], sumTillHere+arr[i]);
			max = Math.max(sumTillHere, max);
		}
		System.out.println("max sum is "+max);
	}
	
	
	static void maxEvenOddLen(int[] arr)
	{
		int len = 1, ans=1;
		for(int i=1;i<arr.length;i++)
		{
			if(((arr[i]&1)!=1 && (arr[i-1]&1)==1) || ((arr[i]&1)==1 && (arr[i-1]&1)!=1))
				len++;
			else
				len=1;
			ans=Math.max(ans, len);
		}
		System.out.println(ans);
	}
	
	static void minGroupFlip(int[] arr)
	{
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]!=arr[i-1])
			if(arr[i]!=arr[0])
			{
				System.out.print("From "+i);
			}
			else
			{
				System.out.println(" To "+(i-1));
			}
		}
		if(arr[arr.length-1]!=arr[0])
			System.out.println(" To "+(arr.length-1));
	}
	
	public static void main(String[] args) {
		/*
		removeDuplSortedAray(new int[] {1,1,1,2,2,3});
		moveZerosToEnd(new int[] {10, 0, 15, 16, 0, 18});
		rotateArrayByD(new int[] {7, 6, 3, 4, 2, 1}, 2);
		MaximumDifference(new int[] {30, 10, 8, 2});
		freqSortedArray(new int[] {1,1,1,2,2,3,3,3,3});
		maxSubArray(new int[] {1, 2, 3, -2, 5});
		maxEvenOddLen(new int[] {1,2,5,7,8,9,10,5,5,10,8});*/
		minGroupFlip(new int[] {1, 1, 0, 0, 1, 0, 0, 0});
	}
}
