
import java.util.ArrayList;
import java.util.HashSet;

public class CPUPlayer extends Player{
	
	public static final char UP = 'U'; 
	public static final char DOWN = 'D';
	public static final char LEFT = 'L';
	public static final char RIGHT = 'R';
	public static final char INVALID = 'I';
	private Player user;
	
	private HashSet<Integer> availableBoats;
	private boolean removedOne3; 
	private int [] lastHit; 
	private int [] firstHit; 
	private int highestBoatPossible;
	private int countLeftOver;
	private int currentSize;
	private char dir; 
	
	public CPUPlayer(ArrayList<Boat> boats, Player user) {
		super(boats);
		this.user = user;
		
		availableBoats = new HashSet<Integer>();
		availableBoats.add(5);
		availableBoats.add(4);
		availableBoats.add(3);
		availableBoats.add(2);
		
		highestBoatPossible = -1; // no boat found
		
		removedOne3 = false;
	}
	
	public char nextDir (char prevChar) {
		if (prevChar == UP) {
			return DOWN;
		}
		else if (prevChar == DOWN) {
			if (currentSize == 1) {
				return LEFT;
			}
			else {
				return INVALID;
			}
		}
		else if (prevChar == LEFT) {
			return RIGHT;
		}
		else {
			return INVALID; 
		}
	}
	
	public int findHighestPossible() {
		if (availableBoats.contains(5)) {
			return 5;
		}
		else if (availableBoats.contains(4)) {
			return 4; 
		}
		else if (availableBoats.contains(3)) {
			return 3; 
		}
		else {
			return 2; 
		}
	}
	
	public int [] findRandomEmptySpot () {
		int [] pos = new int [2];
		int row = (int)(Math.random()*10);
		int col = (int)(Math.random()*10);
		char av = user.checkAssault(row, col);
		while(av == 'A') {
			row = (int)(Math.random()*10);
			col = (int)(Math.random()*10);
			av = user.checkAssault(row, col);
		}
		pos[0] = row;
		pos[1] = col;
		return pos; 
	}
	
	//smarter AI
	public void randomlyChooseSpot () {
		int [] pos = findRandomEmptySpot();
		int row = pos[0];
		int col = pos[1];
		
		char av = user.tryAssault (row, col);
		if (av =='H') {
			if (BattleshipTester.p1.sunkAllBoats()) {
				BattleshipTester.state = BattleshipTester.PLAYER1_LOSE;
			}
			System.out.println("CPU Hit A Boat!!!");
		}
		if (av == 'M') {
			BattleshipTester.state = BattleshipTester.PLAYER1_TURN;
		}
	}
	
	public void chooseBestSpot() {
		if (highestBoatPossible == -1) {
			int [] posToCheck = findRandomEmptySpot();
			int row = posToCheck[0];
			int col = posToCheck[1];
			
			char av = user.tryAssault(row,col);
			if (av =='H') {
				if (BattleshipTester.p1.sunkAllBoats()) {
					BattleshipTester.state = BattleshipTester.PLAYER1_LOSE;
				}
				else {
					lastHit = new int [2];
					lastHit[0] = row;
					lastHit[1] = col; 
					firstHit = new int [2];
					firstHit[0] = row; 
					firstHit[1] = col; 
					highestBoatPossible = findHighestPossible(); 
					countLeftOver = highestBoatPossible -1; 
					currentSize = 1;
					dir = UP; 
				}
			}
			if (av == 'M') {
				BattleshipTester.state = BattleshipTester.PLAYER1_TURN;
			}
		}
		else {
			if (countLeftOver > 0) {
				int row = -1;
				int col = -1;
				if (dir == UP) {
					row = lastHit[0]-1;
					col = lastHit[1];

				}
				else if (dir == DOWN) {
					row = lastHit[0] + 1;
					col = lastHit[1];
			
				}
				
				else if (dir == LEFT) {
					row = lastHit[0];
					col = lastHit[1]-1;
				}
				else if (dir == RIGHT) {
					row = lastHit[0];
					col = lastHit[1]+1;
				}
				
				if (row ==-1 && col == -1) {
					System.out.println ("Very Wrong Error");
				}
			
				if (row>=0 && row<= user.getBoard().length-1 && 
						col >= 0 && col < user.getBoard()[row].length -1 &&
						user.getBoard()[row][col] %10 == 0) {
					char av = user.tryAssault (row, col);
					if (av =='H') {
						if (BattleshipTester.p1.sunkAllBoats()) {
							BattleshipTester.state = BattleshipTester.PLAYER1_LOSE;
						}
						else {
							lastHit[0] = row;
							lastHit[1] = col;
							countLeftOver --;
							currentSize++; 
						}
					}
					if (av == 'M') {
						dir = nextDir(dir); 
						if (dir == INVALID) {
							highestBoatPossible = -1;
							if (currentSize==3) {
								if (removedOne3) {
									availableBoats.remove(currentSize);
								}
								else {
									removedOne3 = true;
								}
							 
							}	
							else {
								availableBoats.remove (currentSize);
							}
		
						}
						else {
							lastHit[0] = firstHit[0];
							lastHit[1] = firstHit[1];
							
						}
						BattleshipTester.state = BattleshipTester.PLAYER1_TURN;
					}
				}
				else {
					dir = nextDir(dir); 
					if (dir == INVALID) {
						highestBoatPossible = -1;
						if (currentSize==3) {
							if (removedOne3) {
								availableBoats.remove(currentSize);
							}
							else {
								removedOne3 = true;
							}
						 
						}	
						else {
							availableBoats.remove (currentSize);
						}
					}
					else {
						lastHit[0] = firstHit[0];
						lastHit[1] = firstHit[1]; 
					}
				}
			}
			else {
				highestBoatPossible = -1;
				if (currentSize==3) {
					if (removedOne3) {
						availableBoats.remove(currentSize);
					}
					else {
						removedOne3 = true;
					}
				 
				}	
				else {
					availableBoats.remove (currentSize);
				}
			}
		}
	}
}
