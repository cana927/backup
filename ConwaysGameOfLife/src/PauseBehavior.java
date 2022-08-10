import java.awt.event.*;

public class PauseBehavior extends KeyAdapter{
	// p --> pause
	public static boolean paused = false;
	
	public void keyReleased (KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_P) {
			paused = !paused;
		}
	}
}
