import java.io.*;
import java.util.*;

public class billboard2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer (in.readLine());
		int tx1 = Integer.parseInt(st.nextToken());
		int ty1 = Integer.parseInt(st.nextToken());
		int tx2 = Integer.parseInt(st.nextToken());
		int ty2 = Integer.parseInt(st.nextToken());
		
		int xOverlap = Math.min(x2, tx2)- Math.max(x1, tx1);
		if (xOverlap==x2-x1) {
			xOverlap= 1;
		}
		int yOverlap = Math.min(y2, ty2)- Math.max(y1, ty1);
		if (yOverlap==y2-y1) {
			yOverlap= 1;
		}
		int x = x2-x1;
		int y = y2 -y1;
		
		if (yOverlap == 1) {
			out.println ((x-xOverlap) * y);
		}
		else if (xOverlap == 1) {
			out.println((y-yOverlap) * x);
			
		} else if (xOverlap == 1 && yOverlap == 1) {
			out.println (0);
		}else {
			out.println (x*y);
		}
		
		out.close();
		in.close();
	}
}
