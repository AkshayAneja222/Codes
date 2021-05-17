package Programs;

public class CoinChangeCount {

	//naive slution
	static int getCoinCount(int[] arr, int sum, int n){
		if(sum == 0) return 1;

		if(n == 0) return 0;

		int answer = getCoinCount(arr, sum, n-1);
		if(arr[n-1]<=sum)
			answer = answer + getCoinCount(arr, sum-arr[n-1], n);

		return answer;
	}

	public static void main(String[] args) {
		int[] arr = {6, 5, 3, 2};
		int sum = 10;
		//op: 5

		int ans = getCoinCount(arr, sum, arr.length);
		System.out.println(ans);
	}

}
