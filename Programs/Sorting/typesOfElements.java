package Programs.Sorting;

import java.util.Arrays;

public class typesOfElements {
	
	public static void main(String[] args) {
		int[] arr = {2, 2, 2, 0, 0, 1};
		printArray(arr);
		threeTypesOfEle(arr);
		printArray(arr);
	}
	
	static void twoTypesOfEle(int[] arr) {
		//elements may be even/odd or +ve/-ve or 0/1
		//here we will look for even odd
		int i=-1;
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]>=0) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	//considering elements as 0,1,2
	static void threeTypesOfEle(int[] arr) {
		int i=0, j=arr.length-1;
		
		for(int k=0;k<=j;k++)
		{
			if(arr[k]==0)
			{
				swap(arr, i, k);
				i++;
			}
			else if(arr[k]==2)
			{
				swap(arr, j, k);
				j--;
				k--;
			}
			System.out.println("array after "+k+" iterations is "+Arrays.toString(arr));
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void printArray(int[] arr){
		System.out.println("elements of array are: ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}	
	
}
