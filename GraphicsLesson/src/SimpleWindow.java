import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleWindow {
	
	public static JFrame window;//hover red underline==imports
	public static JPanel content;
	
	public static void main(String [] args) {
		window = new JFrame("HelloWorld");//name
		
		content = new JPanel () {//new JPanel no title bc invis
			public void paint(Graphics g) { //overrides in class paint and imports graphic
				super.paint(g); //combine old with new
				g.drawLine (50, 50, 100, 100); //draws line from 50,50 to 100,100
				g.drawOval (100,100,50,50);
			}
		}; 
		content.setMinimumSize(new Dimension(1080, 720));//size, import dimensions
		content.setPreferredSize(new Dimension(1080, 720));
		content.setMaximumSize(new Dimension(1080, 720)); //makes sure of constant size
		window.add(content); //adds content of JPanel
		
		window.pack();//wraps Frame around panel to fit size
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//operation
		window.setVisible(true);//shows it
		//always need these 3 things
	}
	//constant copy and paste of these things 
}
