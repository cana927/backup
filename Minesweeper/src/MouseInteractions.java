import java.awt.event.*;

public class MouseInteractions extends MouseAdapter {

	private static MouseInteractions instance;

	public static MouseInteractions getInstance() {
		if (instance == null) {
			instance = new MouseInteractions();
		}
		return instance;
	}

	private MouseInteractions() {

	}

	public void mouseReleased(MouseEvent e) {
		Board.uncoverClick(e.getX(), e.getY());

		Mindow.getInstance().repaint();
		System.out.println(Board.getInstance());
	}
}
