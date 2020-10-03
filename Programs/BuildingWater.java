package Programs;


public class BuildingWater {
	
	public static void main(String[] aargs) {
		
		int[] arr= {0,4,5,3,2,4};
		int[] rightArr= new int[arr.length];
		int[] leftArr= new int[arr.length];
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			leftArr[i]=max;
			if(max<arr[i])
				max=arr[i];
		}
		
		max=arr[arr.length-1];
		for (int i=arr.length-1;i>=0;i--) {
			rightArr[i]=max;
			if(max<arr[i])
				max=arr[i];
		}
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			int temp=(Math.min(leftArr[i], rightArr[i]))-arr[i];
			sum+=temp>0?temp:0;
		}
		System.out.println(sum);
	}
	
}
