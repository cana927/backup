import java.util.ArrayList;

public class BattleshipTester {
	
	public static final char PLAYER1_TURN = '1';
	public static final char PLAYER2_TURN = '2';
	public static final char PLAYER1_WIN = 'W';
	public static final char PLAYER1_LOSE = 'L';
	
	/*
	 * 0- water
	 * 10- boat
	 * 1- missile
	 * 11- hit missile/hit boat
	 * 100- mouse is over it (only the hundreds place) 
	 */
	
	public static Player p1; // player
	public static CPUPlayer p2; //computer
	
	/*
	 * '1' - player 1's turn
	 * '2' - player 2's turn
	 * 'W' - player 1 wins
	 * 'L' - player 2 wins
	 */
	public static char state; 
	
	public static void main (String [] args) {
		//Player 1
		ArrayList<Boat>boats1 = new ArrayList<Boat>();
		boats1.add(new Boat (0, 0, 5, Boat.HORIZONTAL));
		boats1.add(new Boat (0, 0, 4, Boat.HORIZONTAL));
		boats1.add(new Boat (0, 0, 3, Boat.HORIZONTAL));
		boats1.add(new Boat (0, 0, 3, Boat.HORIZONTAL));
		boats1.add(new Boat (0, 0, 2, Boat.HORIZONTAL));
		Boat.randomizeBoats (boats1);
		/*for (Boat b : boats1) {
			System.out.println(b);
		}*/
		p1 = new Player(boats1);
		
		//Player 2
		ArrayList<Boat>boats2 = new ArrayList<Boat>();
		boats2.add(new Boat (0, 0, 5, Boat.HORIZONTAL));
		boats2.add(new Boat (0, 0, 4, Boat.HORIZONTAL));
		boats2.add(new Boat (0, 0, 3, Boat.HORIZONTAL));
		boats2.add(new Boat (0, 0, 3, Boat.HORIZONTAL));
		boats2.add(new Boat (0, 0, 2, Boat.HORIZONTAL));
		Boat.randomizeBoats (boats2);
		/*System.out.println ("PLAYER 2's BOATS: ");
		for (Boat b : boats2) {
			System.out.println(b);
		}*/
		p2 = new CPUPlayer(boats2, p1);
		
		Battleship b = new Battleship (720, 480); 
		
		state = PLAYER1_TURN;
		while (true) {
			b.updateFrame();
			if (state == PLAYER1_TURN) {
				//does nothing
				//click handling code will change the state
			}
			else if (state == PLAYER2_TURN) {
				p2.chooseBestSpot(); 
			}
			
			//refresh part
			try {
				Thread.sleep(12);
			} catch (InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}
}
