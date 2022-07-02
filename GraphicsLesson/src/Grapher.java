import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grapher extends JPanel{
	
	private JFrame window;
	
	public Grapher (int w, int h) {
		window = new JFrame("Grapher");
		
		this.setPreferredSize(new Dimension (w,h));
		this.setMinimumSize(new Dimension (w,h));
		this.setMaximumSize(new Dimension (w,h));
		window.add(this);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void paint(Graphics g) {
		for(int i=0; i<150; i++) {
			g.drawLine(i*100, -1, i*100, 2000);
			g.drawLine(-1, i*100, 2000, i*100);
			
		}
		for (int i=0; i<10000; i=i+100) {
			for (int r = 0; r<10000; r=r+100) {
				g.fillOval(i,r,99,99);
			}
		}
	}
}
