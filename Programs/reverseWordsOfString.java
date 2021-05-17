package Programs;

public class reverseWordsOfString {

	static void reverseWord(char[] arr, int start, int end) {
		while(start<=end){
			char c = arr[start];
			arr[start] = arr[end];
			arr[end] = c;
			start++;
			end--;
		}
	}	
	
	static void reverseWordsString(char[] arr) {
		int start = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==' ') {
				reverseWord(arr, start, i-1);
				start = i+1;
			}
		}
		
		reverseWord(arr, start, arr.length-1);
		reverseWord(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		char[] arr = "akshay is great".toCharArray();
		reverseWordsString(arr);
		System.out.println(arr);
	}

}
