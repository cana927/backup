import java.util.ArrayList;

public class Player {
	
	private int [][]board; 
	
	public Player(ArrayList<Boat> boats) {
		board = new int [10][10];
		for (Boat b : boats) {
			if (b.getOrientation() == Boat.HORIZONTAL) {
				for (int i=0; i<b.getSize(); i++) {
					board[b.getY()][b.getX()+i] = 10;
				}
			} 
			else {
				for (int i=0; i<b.getSize(); i++) {
					board[b.getY()+i][b.getX()] = 10;
				}
			}
		}
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public boolean sunkAllBoats() {
		for (int i=0; i<=9; i++) {
			for (int j=0; j<10; j++) {
				if (board[i][j] /10 %10 ==1) {
					if (board[i][j] %10 == 0) {
						return false;
					}
				}
			}
		}
		return true; 
	}
	
	/*
	 * 'H' - hit
	 * 'M' - miss
	 * 'A' - already tried
	 */
	public char checkAssault (int row, int col) {
		
		/*
		 * 0- water
		 * 10- boat
		 * 1- missile
		 * 11- hit missile/hit boat
		 * 100- mouse is over it (only the hundreds place) 
		 */
		int spot = board [row][col];
		if (spot%10 == 1) {
			return 'A';
		}
		boolean isBoat = spot/10%10 ==1;
		if (isBoat) {
			return 'H';
		} else {
			return 'M';
		}
	}
	
	//returns true if assault was successful
    public char tryAssault (int row, int col) {
    	char aRet = checkAssault (row, col);
    	if (aRet == 'H' || aRet == 'M') {
    		board[row][col] += 1; 
    	}
    	//don't do anything for 'A'
    	return aRet;
	}
}

