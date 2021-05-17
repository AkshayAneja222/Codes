package dataStructures;

public class Heap {
	int capacity, heapSize;
	int[] heapArray;
	
	Heap(int capacity)
	{
		this.capacity = capacity;
		this.heapSize = 0;
		heapArray = new int[capacity];
	}
	Heap() {
		this.capacity = 1<<10;
		this.heapSize = 0;
		heapArray = new int[capacity];
	}
	
	private int parent(int i) {
		return Math.floorDiv(i-1, 2);
	}
	
	private int left(int i) {
		return i*2+1;
	}
	
	private int right(int i) {
		return i*2+2;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void minHeapify(int[] heapArray, int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		
		if(l<heapSize && heapArray[l]<heapArray[smallest])
			smallest = l;
		if(r<heapSize && heapArray[r]<heapArray[smallest])
			smallest = r;
		
		if(smallest!=i){
			swap(heapArray, i, smallest);
			minHeapify(heapArray, smallest);
		}
	}
	
	public void insertKey(int key) {
		if(heapSize == capacity){
			System.out.println("Overflow!");
			return;
		}
		heapSize++;
		int i = heapSize-1;
		heapArray[i] = key;
		
		while(i!=0 && heapArray[i]<heapArray[parent(i)]) {
			swap(heapArray, i, parent(i));
			i = parent(i);
		}
	}
	
	public void decreaseKey(int[] heapArray, int i, int val) {
		heapArray[i] = val;
		while(i!=0 && heapArray[parent(i)]>heapArray[i]) {
			swap(heapArray, i, parent(i));
			i = parent(i);
		}
	}
	
	public int extractMin() {
		if(heapSize<1) {
			System.out.println("Underflow!");
			return Integer.MIN_VALUE;
		}
		
		if(heapSize == 1) {
			heapSize--;
			return heapArray[0];
		}
		int root = heapArray[0];
		heapArray[0] = heapArray[heapSize-1];
		heapSize--;
		minHeapify(heapArray, 0);
		
		return root;
	}
	
	public void delete(int[] heapArray, int i) {
		decreaseKey(heapArray, i, Integer.MIN_VALUE);
		extractMin();
	}
	
	public void printHeap() {
		for(int i=0;i<heapSize;i++)
			System.out.print(heapArray[i]+" ");
		System.out.println();
	}
	
	public void buildHeap(int[] arr) {
		for(int i=0;i<arr.length;i++)
			heapArray[i] = arr[i];
		
		this.heapSize = arr.length;
		
		int startIndex = arr.length/2-1;
		
		for(int i=startIndex; i>=0; i--)
		{
			minHeapify(heapArray, i);
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		/*
		heap.insertKey(40);
		heap.insertKey(50);
		heap.insertKey(30);
		heap.insertKey(10);
		heap.insertKey(90);
		heap.insertKey(100);
		heap.insertKey(15);
		heap.insertKey(65);
		heap.insertKey(75);
		heap.insertKey(25);
		
		heap.printHeap();
		
		System.out.println("extract min: "+heap.extractMin());
		System.out.println("extract min: "+heap.extractMin());
		System.out.println("extract min: "+heap.extractMin());
		System.out.println("extract min: "+heap.extractMin());
		System.out.println("extract min: "+heap.extractMin());
		*/
		
		int []arr = {7, 8, 9, 5, 4, 3, 2, 9};
		heap.buildHeap(arr);
		heap.printHeap();
	}
}
