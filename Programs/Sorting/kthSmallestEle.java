package Programs.Sorting;

public class kthSmallestEle {
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int getElement(int []arr, int k)
	{
		int start=0, end=arr.length-1;
		while(start<end) 
		{
			int pivot = getPivotElement(arr, start, end);
			if(pivot == k-1) return arr[pivot];
			else if(pivot>k-1) 
				end=pivot-1;
			else
				start=pivot+1;
		}
		return end;
	}
	
	static int getPivotElement(int[] arr, int start, int end) {
		int pivot=arr[end], i=start-1;
		
		for(int j=start; j<end; j++){
			if(arr[j]<=pivot)
				swap(arr, ++i, j);
		}
		swap(arr, ++i, end);
		
		return i;
	}
	
	public static void main(String[] args) {
		
		int[] arr =  {9, 10, 11, 56, 55, 8, 4, 14};
		
		int ans = getElement(arr, 5);
		
		System.out.println(ans);
		
	}
}
