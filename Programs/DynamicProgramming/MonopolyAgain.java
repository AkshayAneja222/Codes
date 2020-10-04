package Programs.DynamicProgramming;

import java.util.Scanner;
/*
 * There are n nodes, each player can choose as many as X nodes from starting. Where 1<=X<=2*M
 * M is 1 initially
 * 
 * 5
 * 2 7 9 4 4
 * 
 * output : 10
 * 
 * M=1
 * 
 * I choose 2
 * Opp Choose 7 9
 * 
 * 
 * I choose 4 4
 * 
 * 4+4+2=10
 */


public class MonopolyAgain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i=0;i<num;i++)
			arr[i]=sc.nextInt();
		
		
		
		sc.close();
	}
}
