
import java.io.*;
import java.util.*;

public class lostCow2 {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int x, y;
	static int output;
	public static void main (String [] args) throws IOException {
		init();
		solve();
		output();
	}
	public static void init() throws IOException {
		in = new BufferedReader(new FileReader("lostcow.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		st = new StringTokenizer(in.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		output = 0;
	}
	public static void solve() {
		int r = 1;
		int keep = 0;
		int curr = x;
		
		while (keep == 0) {
			output += Math.abs(curr - (x+r));
			curr = x+r;
			if (y-x >0) {
				if (curr - y >= 0) {
					keep = 1;
					output -= (curr - y);
				}
			} else {
				if (y - curr >= 0) {
					keep = 1;
					output -= Math.abs(curr - y);
				}
			}
			//System.out.println ( r + " " + curr + " " + output) ; 
			r= r*-2;
		}
	}
	public static void output () throws IOException {
		out.print(output);
		in.close();
		out.close();
	}
}
