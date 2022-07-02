import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Battleship extends JPanel {//10 rows, 10 columns
	
	public static Point[][] PLAYER_POINTS;
	public static Point [][] ENEMY_POINTS;
	
	static {
		PLAYER_POINTS = new Point [10][10];
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				PLAYER_POINTS [i][j] = new Point (24*j + 112, 24*i + 132);
			}
		}
		ENEMY_POINTS = new Point [10][10];
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				ENEMY_POINTS [i][j] = new Point (24*j + 392, 24*i + 132);
			}
		}
	}
	
	private JFrame window;
	
	public Battleship (int w, int h) {
		window = new JFrame("Battleship");
		
		this.setPreferredSize(new Dimension (w,h));
		this.setMinimumSize(new Dimension (w,h));
		this.setMaximumSize(new Dimension (w,h));
		window.add(this);
		
		UIBehavior mouseBehavior = new UIBehavior();
		this.addMouseListener (mouseBehavior);
		this.addMouseMotionListener(mouseBehavior);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		//placeMarker(3,4);
	}
	
	//public void placeMarker (int row, int col) {
		//myBoard [row][col] = 1;
		
	//}
	
	public void updateFrame() {
		window.repaint();
	}
			
	public void paint(Graphics g) {
		
		//player's board
		g.drawRect (100, 120, 240, 240);
		for(int i=0; i<10; i++) {
			g.drawLine(i*24+100, 120, i*24+100, 360);			
		}
		for(int i=0; i<10; i++) {
			g.drawLine(100, i*24+120, 340, i*24+120);			
		}
		
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				Point p = PLAYER_POINTS[i][j];
				if (BattleshipTester.p1.getBoard()[i][j]/10%10 ==1) {
					Color originalColor = g.getColor();
					g.setColor(new Color(125,125,125));
					g.fillOval(p.x-5, p.y-5, 10, 10);
					g.setColor(originalColor);
				}
				//red x
				if (BattleshipTester.p1.getBoard()[i][j] % 10 ==1) {
					Color originalColor = g.getColor();
					g.setColor(new Color(255,0 ,0));
					g.drawLine(p.x-12, p.y-12, p.x+12, p.y+12);
					g.drawLine(p.x+12, p.y-12, p.x-12, p.y+12);
					g.setColor(originalColor);
				}
			}
		}
		
		
		//enemy's board
	    g.drawRect (380, 120, 240, 240);
		for(int i=0; i<10; i++) {
			g.drawLine(i*24+380, 120, i*24+380, 360);			
		}
		for(int i=0; i<10; i++) {
			g.drawLine(380, i*24+120, 620, i*24+120);			
		}
				
		/*for (int i = 0; i<10; i++) {
			for (int j=0; j<10;j++) {
				if (board[i][j] % 10 == 1) {
					int yloc = 40 + i*40;
					int xloc = 160 + j*40;
					g.fillOval (xloc+5, yloc+5, 30, 30);
				}
			}
		}*/
		
		for (int i=0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				Point p = ENEMY_POINTS[i][j];
				//g.fillOval (p.x-5, p.y-5, 10, 10);
				if (BattleshipTester.p2.getBoard()[i][j] % 100 == 11) {
					Color originalColor = g.getColor();
					g.setColor(new Color(125,125,125));
					g.fillOval(p.x-5, p.y-5, 10, 10);
					g.setColor(originalColor);
				}
				//red x
				if (BattleshipTester.p2.getBoard()[i][j] % 10 ==1) {
					Color originalColor = g.getColor();
					g.setColor(new Color(255,0 ,0));
					g.drawLine(p.x-12, p.y-12, p.x+12, p.y+12);
					g.drawLine(p.x+12, p.y-12, p.x-12, p.y+12);
					g.setColor(originalColor);
				}
				//highlighting
				if (BattleshipTester.p2.getBoard()[i][j] >= 100) {
					Color originalColor = g.getColor();
					g.setColor(new Color(255,0,0,64));
					g.fillRect(p.x-12, p.y-12, 24, 24);
					g.setColor(originalColor);
				}
			}
		}
		
		g.drawString ("BATTLESHIP", 335, 100); 
		
		//display information
		if (BattleshipTester.state == BattleshipTester.PLAYER1_TURN) {
			g.drawString("Player 1's turn", 320, 400);
		}
		else if (BattleshipTester.state == BattleshipTester.PLAYER2_TURN) {
			g.drawString("Player 2's turn", 320, 400);
		}
		else if (BattleshipTester.state == BattleshipTester.PLAYER1_WIN) {
			g.drawString("YOU WIN! :)", 330, 400);
		}
		else if (BattleshipTester.state == BattleshipTester.PLAYER1_LOSE) {
			g.drawString("YOU LOSE! :(", 330, 400);
		}
				
	}
	
}
