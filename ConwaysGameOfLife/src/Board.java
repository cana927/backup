
public class Board {
	public static final int WIDTH = 100, HEIGHT = 100;
	
	public static int[][] board;
	public static int [][] future;
	
	public static void init() {
		board = new int [HEIGHT][WIDTH];
		future = new int [HEIGHT][WIDTH];
		
		/* glider
		board[72][71]=1;
		board[73][72]=1;
		board[71][73]=1;
		board[72][73]=1;
		board[73][73]=1;
		*/
	}
	
	public static void next () {
		for (int i =0; i<HEIGHT; i++) {
			for (int j=0; j<WIDTH; j++) {
				int nc = neighborCount(i,j);
				if (board[i][j] == 1) {
					if (nc<2 || nc >3) {
						future[i][j] =0;
					}else {
						future [i][j] = 1;
					}
				}
				else {
					if (nc ==3) {
						future[i][j] =1;
					}
				}
			}
		}
		
		for (int i =0; i<HEIGHT; i++) {
			for (int j =0; j<WIDTH; j++) {
				board[i][j] = future[i][j];
				future[i][j] = 0;
			}
		}
	}
	
	public static int neighborCount (int row, int col) {
		int count = 0;
		for (int i = -1; i<=1; i++) {
			for (int j = -1; j<=1; j++) {
				if (!(i== 0 && j== 0)) {
					int newRow = row+i;
					if (newRow<0) {
						newRow += HEIGHT;
					}
					else if (newRow >= HEIGHT) {
						newRow -= HEIGHT;
					}
					
					int newCol = col +j;
					if (newCol< 0) {
						newCol += WIDTH;
					}
					else if (newCol >= WIDTH) {
						newCol-= WIDTH;
					}
					
					if (isCell (newRow, newCol)) {
						count ++;
					}
				}
			}
		}
		return count;
	}
	public static boolean isCell(int row, int col) {
		return board[row][col] == 1;
	}
}
