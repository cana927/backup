
public class GameOfLife {
	public static void main (String [] args) {
		Board.init();
		GraphShower.init();
		
		while(true) {
			try {
				if (!PauseBehavior.paused) {
					Board.next();
				}
				GraphShower.render();
				Thread.sleep(50);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}
