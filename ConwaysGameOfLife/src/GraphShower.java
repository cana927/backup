import javax.swing.*;
import java.awt.*;

public class GraphShower extends JPanel{
	public static final int SCREEN_WIDTH = 1280, SCREEN_HEIGHT = 800;
	public static final int WIDTH = 800, HEIGHT = 800;
	
	public static GraphShower gs;
	
	public static int[][][] points = new int [Board.HEIGHT][Board.WIDTH][2];	
	public static void init () {
		for (int i =0;i<Board.HEIGHT; i++) {
			for (int j = 0; j<Board.WIDTH; j++) {
				points[i][j][0]= SCREEN_WIDTH/2 - WIDTH/2 + j*WIDTH/Board.HEIGHT;
				points [i][j][1] = SCREEN_HEIGHT/2 - HEIGHT/2 + i*HEIGHT/Board.HEIGHT;
			}
		}
		gs =  new GraphShower();
	}
	
	public static int getBoardRow (int y) {
		if (y< SCREEN_HEIGHT/2 - HEIGHT/2 || y> SCREEN_HEIGHT/2 + HEIGHT/2) return -1;
		y-= SCREEN_HEIGHT/2 - HEIGHT/2;
		y/= HEIGHT/Board.HEIGHT;
		return y;
	}
	public static int getBoardCol (int x) {
		if (x < SCREEN_WIDTH/2 - WIDTH/2 || x > SCREEN_WIDTH/2 + WIDTH/2) return -1;
		x-= SCREEN_WIDTH/2 - WIDTH/2;
		x/= WIDTH / Board.WIDTH;
		return x;
	}
	
	public static void render () { 
		if (PauseBehavior.paused ) {
			gs.window.setTitle("Game of Life (Paused)");
		}else {
			gs.window.setTitle("Game of Life");

		}
		gs.repaint();

	}
	
	private JFrame window;
	
	public GraphShower () {
		window = new JFrame ("Game of Life");
		
		this.setPreferredSize(new Dimension (SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setMinimumSize(new Dimension (SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setMaximumSize(new Dimension (SCREEN_WIDTH,SCREEN_HEIGHT));
		window.setContentPane(this);
		window.pack();
		
		window.addKeyListener(new PauseBehavior());
		DrawBehavior db = new DrawBehavior();
		this.addMouseListener (db);
		this.addMouseMotionListener(db);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.toFront();
		window.requestFocus();
	}
	public void paint (Graphics g) {
		super.paint(g);
		
		g.drawRect(SCREEN_WIDTH/2 - WIDTH/2, SCREEN_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT); 
		
		for (int i = 0; i<Board.HEIGHT; i++) {
			for (int j = 0; j<Board.WIDTH; j++) {
				int x = points[i][j][0];
				int y = points[i][j][1];
				if (Board.board[i][j] == 1) {
					g.setColor(Color.black);
					g.fillRect(x, y, WIDTH/Board.WIDTH+1, HEIGHT/Board.HEIGHT+1);
				}else {
					g.setColor(new Color(0,0,0,20));
					g.drawRect(x, y, WIDTH/Board.WIDTH, HEIGHT/Board.HEIGHT );
				}
			}
		}
	}
}
