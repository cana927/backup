import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UIBehavior extends MouseAdapter{
	
	public void mouseClicked (MouseEvent e) {
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				Point p = Battleship.ENEMY_POINTS[i][j];
				if ((p.x - 12 <= e.getX() && e.getX() <p.x + 12) &&
						(p.y - 12 <= e.getY() && e.getY() <=p.y + 12 )) {
					//try assault
					if (BattleshipTester.state == BattleshipTester.PLAYER1_TURN) {
						char aRet = BattleshipTester.p2.tryAssault(i,j);
						/*
						 * 'H' - hit
						 * 'M' - miss
						 * 'A' - already tried
						 */
						if (aRet == 'A') {
							System.out.println("Do an assault somewhere new");
						}
						else if (aRet == 'H') {
							if (BattleshipTester.p2.sunkAllBoats()) {
								BattleshipTester.state = BattleshipTester.PLAYER1_WIN;
							}
							System.out.println("HIT");
						}
						else if (aRet == 'M') {
							BattleshipTester.state = BattleshipTester.PLAYER2_TURN;
							System.out.println("MISS");
						}
					}
				}
			}
		}
		
	}
	
	public void mouseMoved (MouseEvent e) {
		//System.out.println ("MOVED!" + e.getX() + " " + e.getY());
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				Point p = Battleship.ENEMY_POINTS[i][j];
				if ((p.x - 12 <= e.getX() && e.getX() <p.x + 12) &&
						(p.y - 12 <= e.getY() && e.getY() <=p.y + 12 )){
					if (BattleshipTester.p2.getBoard()[i][j] < 100) {
						BattleshipTester.p2.getBoard()[i][j] += 100;
					}
				}
				else {
					if (BattleshipTester.p2.getBoard()[i][j] >= 100) {
						BattleshipTester.p2.getBoard()[i][j] -= 100;
					}
				}
			}
		}
	}
}
