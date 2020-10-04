package Programs.DynamicProgramming;

import java.util.Scanner;

public class FormString {

	public static boolean permuteString(String str, String[] arr) {
		if (str.equals(""))
		return true;
		
		System.out.println(str);
		
			for (int i = 0; i < arr.length; i++) {
				if(str.startsWith(arr[i]))
				if (permuteString(str.substring(arr[i].length()), arr))
					return true;
			}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			String str = sc.next();

			int num = sc.nextInt();
			String[] arr = new String[num];

			for (int i = 0; i < num; i++)
				arr[i] = sc.next();

			System.out.println(permuteString(str, arr));
		}
		sc.close();
	}

}
