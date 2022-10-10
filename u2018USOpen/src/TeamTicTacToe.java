import java.util.*;
import java.io.*;

public class TeamTicTacToe {
	static char [][] board;
	static int indiv, team;
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList <Integer> one, two;
	
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader ("tttt.in"));
		out = new PrintWriter (new BufferedWriter (new FileWriter ("tttt.out")));
		board = new char [3][3];
		for (int c = 0; c<3; c++) {
			st = new StringTokenizer (in.readLine());
			String full = st.nextToken();
			for (int r = 0; r<3; r++) {
				board [c][r] = full.charAt(r);
			}
		}
		indiv = 0;
		team = 0;
	}
	public static void solve () {
		one = new ArrayList<Integer> ();
		two = new ArrayList<Integer> ();
		
		for (int i = 'a'; i<='z'; i++) {
			boolean onewin = false; 
			for (int r = 'a'; r<='z'; r++) {
				for (int v = 0; v<3; v++) {
					int e =check(board[v][0], board[r][1],board[r][2], (char)i, (char)r); 
					if (e == 1 && !onewin) {
						onewin = true;
						indiv ++;
					}
					if (e==2 && !use(i,r) && !use (r, i)) {
						team++;
						one.add(i);
						two.add(r);
					}
				}
				for (int h = 0; h<3; h++) {
					int e =check(board[0][h], board[1][h],board[2][h], (char)i, (char)r); 
					if (e == 1 && !onewin) {
						onewin = true;
						indiv ++;
					}
					if (e==2 && !use(i,r) && !use (r, i)) {
						team++;
						one.add(i);
						two.add(r);
					}
				}
				int e =check(board[0][0], board[1][1],board[2][2], (char)i, (char)r); 
				if (e == 1 && !onewin) {
					onewin = true;
					indiv ++;
				}
				if (e==2 && !use(i,r) && !use (r, i)) {
					team++;
					one.add(i);
					two.add(r);
				}
				e =check(board[2][0], board[1][1],board[0][2], (char)i, (char)r); 
				if (e == 1 && !onewin) {
					onewin = true;
					indiv ++;
				}
				if (e==2 && !use(i,r) && !use (r, i)) {
					team++;
					one.add(i);
					two.add(r);
				}
			}
		}
	}
	public static int check (char a, char b, char c, char one, char two) {
		if (a == b && b==c && c == one) {
			return 1;
		}
		else if (a == b && b == one && c == two) {
			return 2;
		}
		else if (a == b && b == two && c == one) {
			return 2;
		}
		return 0;
	}
		
		/*one = new ArrayList<Character> ();
		two = new ArrayList<Character> ();
		
		//horizontal
		for (int r = 0; r<3; r++) {
			if (board[r][0] == board[r][1] && board[r][1] == board[r][2] ) {
				indiv ++;
			}
			else if (board[r][0] == board[r][1] || board[r][1] == board[r][2] || board[r][0] == board[r][2]) {
				char a = board[r][0];
				char b =board [r][1];
				if (board[r][1] == board[r][0]) {
					b = board[r][2];
				}
				if (!use(a,b)) {
					team ++;
					one.add(a);
					two.add(b);
				}
				
			}
		}
		
		//vertical
		for (int c = 0; c<3; c++) {
			if (board[0][c] == board[1][c] && board[1][c] == board[2][c] ) {
				indiv ++;
			}
			else if (board[0][c] == board[1][c] || board[1][c] == board[2][c] || board[0][c] == board[2][c]) {
				char a = board[0][c];
				char b =board [1][c];
				if (board[0][c] == board[1][c]) {
					b = board[2][c];
				}
				if (!use(a,b)) {
					team ++;
					one.add(a);
					two.add(b);
				}
			}
		}
		
		//diagonal top left to bot right
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] ) {
			indiv ++;
		}
		else if (board[0][0] == board[1][1] || board[1][1] == board[2][2] || board[0][0] == board[2][2]) {
			char a = board[0][0];
			char b =board [1][1];
			if (board[0][0] == board[1][1]) {
				b = board[2][2];
			}
			if (!use(a,b)) {
				team ++;
				one.add(a);
				two.add(b);
			}
		}
		
		//other diagonal
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] ) {
			indiv ++;
		}
		else if (board[0][2] == board[1][1] || board[1][1] == board[2][0] || board[0][2] == board[2][0]) {
			char a = board[0][2];
			char b =board [1][1];
			if (board[0][2] == board[1][1]) {
				b = board[2][0];
			}
			if (!use(a,b)) {
				team ++;
				one.add(a);
				two.add(b);
			}
		}
		*/
	public static void output () throws IOException {
		out.print(indiv);
		out.println ();
		out.println(team);
		in.close();
		out.close();
	}
	
	public static boolean use (int a , int b) {
		for (int i =0; i<one.size(); i++) {
			if (one.get(i) == a && two.get(i) == b) {
				return true;
			} else if (one.get(i) == b && two.get(i) == a){
				return true;
			}
		}
		return false;
	}
}	
