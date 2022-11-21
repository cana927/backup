import java.awt.*;

public class Board {

	public static final int WIDTH = 500, HEIGHT = 500;

	private static Board instance;

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();

		}
		return instance;
	}

	public static void setupBoard(int width, int height, int numOfBombs) {
		if (instance == null) {
			instance = new Board();

		}
		instance.board = new int[height][width];
		instance.numOfBombs = numOfBombs;
		instance.setBoard();
	}

	public static void drawboard(Graphics g) {
		int boardX = (int) Mindow.SCREEN_SIZE.getWidth() / 2 - WIDTH / 2;
		int boardY = (int) Mindow.SCREEN_SIZE.getHeight() / 2 - HEIGHT / 2;
		g.drawRect(boardX, boardY, WIDTH, HEIGHT);

		int subwidth = WIDTH / instance.board.length;
		int subheight = HEIGHT / instance.board[0].length;
		for (int i = 0; i < instance.board.length; i++) {
			for (int j = 0; j < instance.board[i].length; j++) {
				int subboardX = boardX + j * subwidth;
				int subboardY = boardY + i * subwidth;
				if (instance.board[i][j] / 100 % 10 == 1) {
					if (instance.isBomb(i, j)) {
						Color original = g.getColor();
						g.setColor(Color.red);
						g.drawLine(subboardX, subboardY, subboardX + subwidth, subboardY + subheight);
						g.drawLine(subboardX + subwidth, subboardY, subboardX, subboardY + subheight);
						g.setColor(original);
					} else {
						int p = instance.getProximity(i, j);
						g.drawString(p + "", subboardX + subwidth / 2, subboardY + subheight / 2 + 10);
					}
				}
				g.drawRect(subboardX, subboardY, subwidth, subheight);

			}
		}
	}

	public static void uncoverClick(int x, int y) {
		if (!instance.lost) {
			int boardX = (int) Mindow.SCREEN_SIZE.getWidth() / 2 - WIDTH / 2;
			int boardY = (int) Mindow.SCREEN_SIZE.getHeight() / 2 - HEIGHT / 2;
			if (boardX <= x && x <= boardX + WIDTH && boardY <= y && y <= boardY + HEIGHT) {
				int subwidth = WIDTH / instance.board.length;
				int subheight = HEIGHT / instance.board[0].length;

				x -= boardX;
				y -= boardY;
				x /= subwidth;
				y /= subheight;

				instance.uncover(y, x);
			}
		}
	}

	public static boolean lost() {
		return instance.lost;
	}

	private int[][] board;
	private int numOfBombs;
	private boolean lost;

	private Board() {

	}

	public void setBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		for (int i = 0; i < numOfBombs; i++) {
			int row = (int) (Math.random() * board.length);
			int col = (int) (Math.random() * board[0].length);
			while (isBomb(row, col)) {
				row = (int) (Math.random() * board.length);
				col = (int) (Math.random() * board[0].length);
			}
			board[row][col] = 10;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int bombCount = calcProximity(i, j);
				board[i][j] += bombCount;
			}
		}
	}

	public int calcProximity(int row, int col) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0)
					continue;
				if (0 <= row + i && row + i <= board.length - 1 && 0 <= col + j && col + j <= board.length - 1) {
					if (isBomb(row + i, col + j))
						count++;
				}
			}
		}
		return count;
	}

	public int getProximity(int row, int col) {
		return board[row][col] % 10;
	}

	public boolean isBomb(int row, int col) {
		return board[row][col] / 10 % 10 == 1;
	}

	public void uncover(int row, int col) {
		if (board[row][col] / 100 % 10 == 0) {
			board[row][col] += 100;
		}
		if (isBomb(row, col)) {
			lost = true;
		}
		if (board[row][col] % 10 == 0) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i == 0 && j == 0)
						continue;
					if (0 <= row + i && row + i <= board.length - 1 && 0 <= col + j && col + j <= board[0].length) {
						if (board[row + i][col + j] / 100 % 10 == 0) {
							uncover(row + i, col + j);
						}
					}
				}
			}
		}
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				ret += String.format("%4d", board[i][j]);
			}
			ret += "\n";
		}
		return ret.substring(0, ret.length() - 1);
	}
}
