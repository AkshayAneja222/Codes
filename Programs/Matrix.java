package Programs;

public class Matrix {
	
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, 
				{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25}};
		int[][] arr2 = {{10, 20, 30, 40},{50, 60, 70, 80},
						{90, 100, 110, 120}
						,{130, 140, 150, 160}};
		searchEleInMatrix(arr2, 111);
	}

	static void spiralPattern(int[][] arr)
	{
		int x = arr.length-1, y = arr[0].length-1;
		int loop=0;
		
		while(loop<=Math.min(x, y)-1){
			for(int i=loop;i<=y-loop;i++)
				System.out.print(arr[loop][i]+" ");
			
			for(int i=loop+1;i<=x-loop;i++)
				System.out.print(arr[i][y-loop]+" ");
			
			for(int i=y-loop-1;i>=loop;i--)
				System.out.print(arr[x-loop][i]+" ");
			
			for(int i=x-loop-1;i>loop;i--)
				System.out.print(arr[i][loop]+" ");
			loop++;
		}
	}
	
	static int binarySearch(int[] arr, int x) {
		int low = 0, high = arr.length-1;
		
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(arr[mid]==x) 
				return mid;
			else if(arr[mid] > x)
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}
	
	static void searchEleInMatrix(int[][] arr, int x)
	{
		int start = 0, end = arr.length-1;
		int y=arr[0].length-1;
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			if(x>=arr[mid][0] && x<=arr[mid][y]){
				int val=binarySearch(arr[mid], x);
				if(val==-1)
					System.out.println(val);
				else
					System.out.println(mid+","+val);
				break;
			}
			else if(x>arr[mid][y])
				start=mid+1;
			else
				end=mid-1;
		}
	}
	
}
