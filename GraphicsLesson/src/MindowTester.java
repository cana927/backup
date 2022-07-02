
public class MindowTester {
	public static void main(String[] args) {
		Mindow m = new Mindow(720, 480);
		m.open();
		while (true) {
			m.move();
			m.repaint(); 
			
			try {
				Thread.sleep(12); //greater number = slower
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
