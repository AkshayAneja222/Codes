
public class RotateMatrix {

	
	public static node rotateIndex(int x,int y,int m) {
		return new node(y,m-1-x);
		
	}
	
	public static void main(String[]  args) 
	{
		  int [][]arr =  {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		 
		  for(int i=0;i<arr.length/2;i++) {
			  for(int j=0;j<arr[0].length/2;j++) {
				  int temp=arr[i][j];
				  node n = rotateIndex(i,j,arr.length);
				  arr[i][j]=arr[n.x][n.y];
				  node n2 = rotateIndex(n.x,n.y,arr.length);
				  arr[n.x][n.y]=arr[n2.x][n2.y];
				  node n3 = rotateIndex(n2.x,n2.y,arr.length);
				  arr[n2.x][n2.y]=arr[n3.x][n3.y];
				  arr[n3.x][n3.y]=temp;
			  }
		  }
		  for(int i=0;i<arr.length;i++) {
			  for(int j=0;j<arr[0].length;j++) {
				  System.out.print(arr[i][j]+" ");
			  }System.out.println();
		  }
			  }
		  
	}
