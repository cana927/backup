import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Mindow extends JPanel{//inheritance- Mindow acts like jpanel 
//child of parent(Jpanel)
	
	private JFrame window;
	
	private int ballX, ballY; // the ball's (x,y) location respectively
	
	public Mindow(int w, int h) {
		window = new JFrame();
		
		this.setPreferredSize(new Dimension(w,h));
		this.setMinimumSize(new Dimension(w,h));
		this.setMaximumSize(new Dimension(w,h));
		
		window.add(this);
		window.pack();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ballX = 0;
		ballY = 0;
	}
	
	
	
	public void open() {
		window.setVisible(true);
	}
	
	public void move() {
		ballX ++;
		ballY = ballX; //(int)(20*Math.sin(ballX/10.0));
	}
	
	public void paint (Graphics g) { //overrides parent class behavior
		super.paint(g);
		g.fillOval(ballX,ballY,20,20);
		
	}
}
