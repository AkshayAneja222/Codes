package Programs.hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

public class Hashing {
	
	static void getIntersection(int[] a, int[] b) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<a.length;i++) set.add(a[i]);
		
		for(int i=0;i<b.length;i++) {
			if(set.contains(b[i]))
			{
				System.out.print(b[i]+" ");
				set.remove(b[i]);
			}
		}
		System.out.println();
	}
	
	static void getUnion(int[] a, int[] b){
		HashSet<Integer> set = new HashSet<Integer>();
		int i=0, j=0;
		
		while(i<a.length && j<b.length) {
			set.add(a[i++]);
			set.add(b[j++]);
		}
		while(i<a.length) set.add(a[i++]);
		while(j<b.length) set.add(b[j++]);
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
		
		System.out.println();
	}
	
	
	static void pairSumUnsrtdArr(int[] a, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<a.length;i++)
		{
			if(map.containsKey(k-a[i]))
			{
				System.out.println(i+" "+map.get(k-a[i]));
				return;
			}
			else
				map.put(a[i], i);
		}
	}
	
	
	static void maxLenSubArrZeroSum(int[] a)
	{
		int sum = 0, maxLength=0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i];
			if(map.containsKey(sum)) {
				int len = i-map.get(sum);
				maxLength = Math.max(maxLength, len);
			}
			else if(sum==0){
				maxLength = Math.max(maxLength, i+1);
			}
			else map.put(sum, i);
		}
		
		System.out.println(maxLength);
	}
	
	//O(n)
	static boolean subArrGivnSum(int[] a, int k)
	{
		int pSum=-1, sIndex=-1;
		for(int i=0;i<a.length;i++)
		{
			if(pSum==-1 && sIndex==-1) {
				pSum=a[i];
				sIndex=i;
				continue;
			}	
			if(a[i]==k){
				return true;
			}
			else if(a[i]>k){
				pSum=-1;
				sIndex=-1;
			}else
			{
				pSum+=a[i];
				
				while(pSum>k) {
					pSum-=a[sIndex++];
				}
				if(pSum==k)
					return true;
			}
		}
		return false;
	}
	
	
	static boolean subArrayGivenSum(int[] a, int k) {
		int sum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i];
			
			if(sum==k)
				return true;
			if(set.contains(sum-k))
				return true;
			
			set.add(sum);
		}
		return false;
	}
	
	
	
	static void subArrayGvnSumLongestLength(int[] a, int k) {
		int sum = 0, len=0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			sum+=a[i];
			if(sum==k)
			{
				len=Math.max(len, i+1);
			}
			if(map.containsKey(sum-k))
			{
				len=Math.max(len, i-map.get(sum-k));
			}
			if(!map.containsKey(sum))
			map.put(sum, i);
		}
		System.out.println("max length is "+len);
	}
	
	
	
	static void maxSubArrayWithEqualOneAndZero(int[] arr)
	{
		int maxLen = 0, sum=0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i]==0)
				sum+=-1;
			else
				sum+=1;
			
			if(sum==0)
				maxLen=Math.max(maxLen, i+1);
			if(map.containsKey(sum))
				maxLen=Math.max(maxLen, i-map.get(sum));
			if(!map.containsKey(sum))
				map.put(sum, i);
		}
		System.out.println(maxLen);
	}
	
	
	
	static void longestConsqSubsq(int[] arr)
	{
		int ans = 0,curr=1;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++) set.add(arr[i]);
		
		for(int i=0;i<arr.length;i++) 
		{
			if(!set.contains(arr[i]-1))
			{
				curr=1;
				while(set.contains(arr[i]+curr))
					curr++;
				ans = Math.max(curr, ans);
			}
		}
		System.out.println(ans);
	}
	
	
	static void distinctEleInWindowK(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(k);
		
		for(int i=0;i<k;i++)
		{
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
		}
		
		System.out.print(map.size()+" ");
		for(int i=k;i<arr.length;i++)
		{
			if(map.get(arr[i-k])==1)
				map.remove(arr[i-k]);
			else
				map.put(arr[i-k], map.get(arr[i-k])-1);
			
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
			System.out.print(map.size()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,-3,-2,-1,4,1, 0, 1};
		int[] b = {1, 3, 8, 3, 3};
		/*
		getIntersection(a, b);
		getUnion(a,b);
		pairSumUnsrtdArr(a, 6);
		maxLenSubArrZeroSum(a);
		subArrayGvnSumLongestLength(a, 3);
		maxSubArrayWithEqualOneAndZero(new int[]{1, 0, 1, 0, 1, 0, 0, 1});
		longestConsqSubsq(new int[] {9, 100, 101, 105, 6, 8, 7});
		*/
		distinctEleInWindowK(new int[] {1, 1, 1, 1}, 4);
	}
}

//

