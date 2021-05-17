package Programs.Sorting;

public class Sort {
	
	public void insertionSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int j = i-1, key = arr[i];
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
	}
	
	
	
	public void mergeSort(int[] arr, int start, int end)
	{
		if(start<end)
		{
			int mid = start+(end-start)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	
	
	public void merge(int[] arr, int start, int mid, int end)
	{
		int[] first = new int[mid-start+1];
		int[] second = new int[end-mid];
		
		for(int i=0;i<first.length;i++)
			first[i]=arr[i+start];
		for(int i=0;i<second.length;i++)
			second[i]=arr[i+mid+1];
		
		int i=0, j=0, index=start;
		while(i<first.length && j<second.length)
		{
			if(first[i]<=second[j])
				arr[index++]=first[i++];
			else
				arr[index++]=second[j++];
		}	
		
		while(i<first.length)
			arr[index++]=first[i++];
		while(j<second.length)
			arr[index++]=second[j++];
	}
	
	
	
	public void quickSort(int[] arr, int start, int end){
		int pivot;
		if(start<end)
		{
			pivot = hoarePartition(arr, start, end);
			System.out.println("after partitioning pivot: "+pivot+" start: "+start+" end: "+end);
			this.printArray(arr);
			quickSort(arr, start, pivot);
			quickSort(arr, pivot+1, end);
		}
	}
	
	
	
	public int lomutoPartition(int[] arr, int start, int end) {
		
		int pivot = arr[end], i=start-1;
		for(int j=start;j<end;j++)
		{
			if(arr[j]<=pivot)
			{
				swap(arr, ++i, j);
			}
		}
		swap(arr, ++i, end);
		
		return i;
	}
	
	
	public int hoarePartition(int[] arr, int start, int end)
	{
		int pivot=arr[start], i=start-1, j=end+1;

		while(true)
		{
			do {
				i++;
			}while(arr[i]<pivot);

			do {
				j--;
			}while(arr[j]>pivot);

			if(i>=j)return j;
			swap(arr, i, j);
		}
	}


	public void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	public void printArray(int[] arr)
	{
		System.out.println("elements of array are: ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		/*
		int[] arr = new int[50];
		for(int i=0;i<50;i++)
			arr[i]=(int)(1+Math.random()*100);
				
		Sort sort = new Sort(); 
		sort.printArray(arr);
		sort.mergeSort(arr, 0, 49);
		sort.printArray(arr);
		*/
		int[] arr= new int[40];
		
		for(int i=0;i<40;i++)
			arr[i]=(int)(0+Math.random()*40);
		
		Sort sort = new Sort();
		
		sort.printArray(arr);
		sort.quickSort(arr, 0, arr.length-1);
		sort.printArray(arr);
	}
}
