package Programs.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SwapSum {

	static void getSum(int[] arr, int num, int k) {
		int sum_till_here = 0, max_sum = Integer.MIN_VALUE;
		int start = 0, s=0, end = 0;
		
		for(int i=0;i<num;i++)
		{
			sum_till_here+=arr[i];
			if(sum_till_here > max_sum) {
				max_sum = sum_till_here;
				start = s;
				end = i;
			}
			if(sum_till_here<0) {
				sum_till_here = 0;
				s = i+1;
			}
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return b-a;
			}
		});
		
		PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>();
		
		int i=0;
		for(i=0; i<num; i++)
		{
			if(i>=start && i<=end) 
			{
				heap1.add(arr[i]);
				continue;
			}
			heap.add(arr[i]);
		}
		
		int top = 0, count=0;
		while(!heap.isEmpty() && count<k)
		{
			top = heap.peek();
			if(max_sum+top > max_sum)
			{	
				max_sum+=top;
				heap.poll();
			}else break;
			count++;
		}
		
		while(count<k){
			top = heap1.poll();
			if(max_sum-top > max_sum){
				max_sum-=top;
			}else break;			
			count++;
		}
		
		System.out.println(max_sum);
	}
	
	public static void main(String[] args) {

	      Scanner sc = new Scanner(System.in);
	      int num = sc.nextInt();
	      int k = sc.nextInt();
	      
	      int[] arr = new int[num];
	      for(int i=0;i<num;i++)
	        arr[i] = sc.nextInt();
	      
	      getSum(arr, num, k);
	      
	      sc.close();
	}
}
