package Programs.Backtracking;

public class NQueen {

	private static boolean correctPosition(int[][] board, int N, int i, int j)
	{
		for(int a=i,b=j; a>=0 && b>=0; a--,b--)
			if(board[a][b] == 1)
				return false;
		
		for(int a=i,b=j; a<N && b>=0; a++,b--)
			if(board[a][b] == 1)
				return false;
		
		for(int b=j; b>=0; b--)
			if(board[i][b]==1)
				return false;
		
		return true;
	}

	private static boolean generateNQueen(int[][] board, int N, int col)
	{
		if(col==N)
		return true;
		
		for(int row=0; row<N; row++)
		{
			if(correctPosition(board, N, row, col))
			{
				board[row][col] = 1;
				if(generateNQueen(board, N, col+1)) return true;
				board[row][col] = 0;
			}
		}
		return false;	
	}

	private static void printBoard(int[][] board, int N)
	{
		if(generateNQueen(board, N, 0))
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(board[i][j]+" ");
			}System.out.println();
		}
	}

	public static void main(String[] args) {
		int N = 6;
		int[][] board = new int[N][N];
		printBoard(board, N);
	}
}
