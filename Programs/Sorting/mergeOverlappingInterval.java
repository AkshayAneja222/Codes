package Programs.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//given time interval, user is required to get the merged Overlapping Intervals
public class mergeOverlappingInterval {
	
	static class Pair{
		int i, j;
		Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static void mergeOverlapping(ArrayList<Pair> list){
		
		Collections.sort(list,  new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				if(a.i == b.i)
					return a.j-b.j;
				return a.i-b.i;
			}
		});
		
		ArrayList<Pair> answer = new ArrayList<Pair>();
		answer.add(list.get(0));
		
		Pair temp1 , temp2;
		for(int i=1;i<list.size();i++)
		{
			temp1 = answer.get(answer.size()-1);
			temp2 = list.get(i);
			
			if(canMerged(temp1, temp2))
			{
				answer.remove(answer.size()-1);
				answer.add(new Pair(Math.min(temp1.i, temp2.i), Math.max(temp1.i, temp2.j)));
			}
			else
			{
				answer.add(temp2);
			}
		}
		
		for(Pair p: answer)
		{
			System.out.println(p.i+" "+p.j);
		}
	}
	
	static boolean canMerged(Pair a, Pair b){
		return ((a.i<=b.i && b.i<=a.j) || (b.i<=a.i && a.i<=b.j));
	}
	
	public static void main(String[] args) {
		ArrayList<Pair> heap = new ArrayList<Pair>();
		heap.add(new Pair(9, 10));
		heap.add(new Pair(1, 6));
		heap.add(new Pair(9, 11));
		heap.add(new Pair(5, 8));
		
		mergeOverlapping(heap);
	}
}
