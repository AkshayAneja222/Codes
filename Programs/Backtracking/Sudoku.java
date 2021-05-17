package Programs.Backtracking;

public class Sudoku {

	private static boolean isCorrectValue(int[][] sudokuBoard, int N, int a, int b, int value)
	{
		for(int k=0; k<N; k++)
			if(sudokuBoard[a][k]==value || sudokuBoard[k][b]==value)
				return false;

		int size = (int) Math.sqrt(N);
		int row_block_start = a-a%size;
		int column_block_start = b-b%size;

		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				if(sudokuBoard[i+row_block_start][j+column_block_start] == value)
					return false;

		return true;
	}

	private static boolean solveSudoku(int[][] sudokuBoard, int N)
	{
		int i=0, j=0;
		
		for(i=0; i<N; i++) 
		{
			for(j=0; j<N; j++) 
			{
				if(sudokuBoard[i][j] == 0)
					break;
			}
			if(j!=N) break;
		}
			
		if(i==N && j==N) return true;
		
		//System.out.println("i: "+i+"  j: "+j);
		
		for(int n=1; n<=N; n++)
		{
			if(isCorrectValue(sudokuBoard, N, i, j, n))
			{
				sudokuBoard[i][j] = n;
				
				if(solveSudoku(sudokuBoard, N)) return true;
					
				sudokuBoard[i][j] = 0;
			}
		}
		return false;
	}

	private static void printBoard(int[][] sudokuBoard, int N)
	{
		if(solveSudoku(sudokuBoard, N))
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(sudokuBoard[i][j]+" ");
			}System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] sudokuBoard = 
			{{0, 5, 6, 8, 9, 1, 0, 4, 0},
			 {0, 4, 0, 7, 0, 0, 0, 0, 1},
			 {8, 0, 1, 0, 0, 5, 2, 0, 0},
			 {1, 0, 2, 0, 7, 0, 0, 0, 0},
			 {5, 9, 8, 0, 6, 0, 0, 0, 4},
			 {0, 6, 4, 0, 3, 8, 1, 0, 0},
			 {0, 2, 7, 0, 0, 3, 0, 5, 0},
			 {0, 0, 0, 2, 0, 4, 0, 0, 7},
			 {9, 0, 0, 0, 8, 0, 4, 3, 2}};
		
		int N = 9;
		printBoard(sudokuBoard, N);
	}
}
