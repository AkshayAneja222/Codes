package Programs.Sorting;

public class IntersectionAndUnion {
	int[] arr = {2, 2, 5, 8, 8, 13, 15};
	int[] arrr = {2, 3, 8, 8, 11, 13};
	
	public void intersect()
	{
		int i=0, j=0, prev=-1;
		while(i<arr.length && j<arrr.length)
		{
			if(arr[i]==arrr[j])
			{
				if(prev!=arr[i]) {
					System.out.print(arr[i]+" ");
					prev=arr[i];
				}
				i++;
				j++;
			}
			else if(arr[i]>arrr[j])
			{
				j++;
			}
			else
			{
				i++;
			}
		}
		System.out.println();
	}
	
	public void union()
	{
		int i=0,j=0, prev=-1;
		while(i<arr.length && j<arrr.length)
		{
			if(arr[i]==arrr[j]) {
				if(prev!=arr[i]){
					System.out.print(arr[i]+" ");
					prev=arr[i];
				}
				i++;
				j++;
			}
			else if(arr[i]<arrr[j]) {
				if(prev!=arr[i]) {
					System.out.print(arr[i]+" ");
					prev=arr[i];
				}
				i++;
			}
			else {
				if(prev!=arrr[j]){
					System.out.print(arrr[j]+" ");
					prev=arrr[j];
				}
				j++;
			}
		}
		while(i<arr.length)
			System.out.print(arr[i++]+" ");
		while(j<arrr.length)
			System.out.print(arrr[j++]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		new IntersectionAndUnion().intersect();
		new IntersectionAndUnion().union();
	}
}
