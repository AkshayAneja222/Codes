package Programs;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.io.*;

class node{
	int x;
	int y;
	node(int x,int y){
		this.x=x;
		this.y=y;
}}

public class MineSweeper {
  public static void main(String args[]) throws IOException { 
	
	  int [][]arr =  {{-1,1,0,0},
					  {1,1,0,0},
					  {0,0,1,1},
					  {0,0,0,1}};
	  MineSweeper t = new MineSweeper();
	  t.click(arr, 4, 4, 1, 3);

  }
  

  public void click(int[][]arr,int rows,int columns,int click_x,int click_y) {
	  
	  ConcurrentLinkedQueue<node> queue = new ConcurrentLinkedQueue<node>();
	  //get neighbors and update them with -2 (if val==0) simultaneously.
	  node n1 = new node(click_x,click_y);
	  queue.add(n1);
	  
	  while(!queue.isEmpty()) {
		  
		  node temp=queue.remove();
		  int i=temp.x;
		  int j=temp.y;
		  arr[i][j]=-2;
		  
		  for ( int k=i-1;k<=i+1;k++) {
			  for ( int l=j-1;l<=j+1;l++) {
				  if((0<=k && k<rows) && (0<=l && l<columns)) {
					  if (arr[k][l]==0) {
						  node n3 = new node(k,l);
						
						  queue.add(n3);
					  }
				  }
			  }
		  }
		  
	  }
	  for (int i=0;i<rows;i++) {
		  for ( int j=0;j<columns;j++) {
			  System.out.print(arr[i][j]+" ");
		  }System.out.println();
	  }
	  
  }
  
}
