package Programs.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class mergeKSortedArrays {
	
	private class ValueAndPosition{
		int val, pos, posArr;
		ValueAndPosition(int val, int pos, int posArr){
			this.val = val;
			this.pos = pos;
			this.posArr = posArr;
		}
	}
	
	ArrayList<Integer> mergedLists(ArrayList<ArrayList<Integer>> arrayList){
		int arrayListLen = arrayList.size();
		
		PriorityQueue<ValueAndPosition> heap = new PriorityQueue<>( new Comparator<ValueAndPosition>() {
			public int compare(ValueAndPosition a, ValueAndPosition b) {
				return a.val-b.val;
			}
		});
		for(int i=0;i<arrayListLen;i++) {
			heap.add(new ValueAndPosition(arrayList.get(i).get(0), 0, i));
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(!heap.isEmpty()) {
			ValueAndPosition value = heap.poll();
			list.add(value.val);
			
			if(arrayList.get(value.posArr).size()>value.pos+1)
			heap.add(new ValueAndPosition(arrayList.get(value.posArr).get(value.pos+1), value.pos+1, value.posArr));
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(12);
		arr.add(20);
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(3);
		arr1.add(15);
		arr1.add(25);
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(5);
		arr2.add(9);
		arr2.add(22);
		
		arrayList.add(arr2);
		arrayList.add(arr1);
		arrayList.add(arr);
		
		mergeKSortedArrays merge = new mergeKSortedArrays();
		
		ArrayList<Integer> list = merge.mergedLists(arrayList);
		
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
	}
}
