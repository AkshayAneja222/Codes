package Programs.Sorting;

//find count of cases where i<j and arr[i]>arr[j] in the given area
//below mentioned code has O(n logn) time complexity
public class CountInversion {
	    
	    static int countInversion(int[] arr, int start, int end)
	    {
	      int ans = 0;
	      if(start<end)
	      {
	          int mid = start+(end-start)/2;
	          ans+=countInversion(arr, start, mid);
	          ans+=countInversion(arr, mid+1, end);
	          ans+=mergeAndCount(arr, start, mid, end);
	      }
	      return ans;
	    }
	    
	    static int mergeAndCount(int[] arr, int s, int m, int e)
	    {
	        int ans = 0;
	        
	        int[] first = new int[m-s+1];
	        int[] second = new int[e-m];
	        
	        for(int i=0;i<first.length;i++)
	            first[i]=arr[i+s];
	        for(int j=0;j<second.length;j++)
	            second[j]=arr[j+m+1];
	        
	        int i=0, j=0, index=s;
	        while(i<first.length && j<second.length)
	        {
	            if(first[i]>second[j]){
	                ans++;
	                arr[index++]=second[j++];
	            }
	            else if (first[i]<=second[j]){
	                arr[index++]=first[i++];
	            }
	        }
	        
	        while(i<first.length)
	        arr[index++]=first[i++];
	        
	        while(j<second.length)
	        arr[index++]=second[j++];
	        
	        return ans;
	    }
	    
		public static void main (String[] args) {
	        int ar2[] = {1, 0, 3, 1, 2, 4};
	        System.out.print(countInversion(ar2, 0, ar2.length-1));
		}
}
