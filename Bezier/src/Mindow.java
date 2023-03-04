import javax.swing.*;
import java.awt.*;

public class Mindow extends JPanel{
	private JFrame window;
	
	public Mindow () {
		window = new JFrame ("Bezier");
		
		this.setPreferredSize(new Dimension(700,700));
		this.setMinimumSize(new Dimension(700,700));
		this.setMaximumSize(new Dimension(700,700));

		window.setContentPane(this);
		window.pack();
		
		PointGrabber p= new PointGrabber();
		this.addMouseListener(p);;
		this.addMouseMotionListener(p);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Point p : Main.mainPoints) {
			g.fillOval((int)p.x-5, (int)p.y-5, 10,10);
			
		}
		for (int i =0; i<Main.points.size()-1; i++) {
			Point p1 = Main.points.get(i);
			Point p2 = Main.points.get(i+1);
			g.drawLine((int)p1.x, (int)p1.y, (int)p2.x, (int)p2.y);
			
		}
	}
}
