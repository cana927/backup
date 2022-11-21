
public class Minesweeper {
	public static void main(String[] args) {
		Mindow m = Mindow.getInstance();
		Board b = Board.getInstance();
		Board.setupBoard(10, 10, 10);
		System.out.println(b);
	}
}
