import java.awt.event.*;

public class DrawBehavior extends MouseAdapter{
	//pause and right click --> draw
	
	public void mouseDragged (MouseEvent e) {
		if (PauseBehavior.paused) {
			int row = GraphShower.getBoardRow(e.getY());
			int col = GraphShower.getBoardCol(e.getX());
			
			if (!(row == -1 || col == -1)) {
				Board.board[row][col] = 1;
			}
			GraphShower.render();
		}
	}

}
