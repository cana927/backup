package _1216;
import java.util.*;

public class CWhiteSheet {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		Rect w, a, b;
		
		w = new Rect (sc.nextInt(), sc.nextInt(), sc.nextInt(),sc.nextInt());
		a = new Rect (sc.nextInt(), sc.nextInt(), sc.nextInt(),sc.nextInt());
		b = new Rect (sc.nextInt(), sc.nextInt(), sc.nextInt(),sc.nextInt());
		
		long warea = (w.x2 - w.x1) * (w.y2 - w.y1);
		
		long xOverlap = Math.min(Math.min(a.x2, b.x2), w.x2)- Math.max(w.x1,Math.max(a.x1, b.x1));
		if (xOverlap<0) {
			xOverlap= 0;
		}
		long yOverlap = Math.min(w.y2, Math.min(a.y2, b.y2))- Math.max(w.y1,Math.max(a.y1, b.y1));
		if (yOverlap<0) {
			yOverlap= 0;
		}
		long triple =  xOverlap * yOverlap;
		
		long leftover = warea - intersect (w, a) - intersect (w,b) + triple;
		if (leftover >0) {
			System.out.println ("YES");
		}else {
			System.out.println("NO");
		}

	}
	public static long intersect (Rect a, Rect b) {
		long xOverlap = Math.min(a.x2, b.x2)- Math.max(a.x1, b.x1);
		if (xOverlap<0) {
			xOverlap= 0;
		}
		long yOverlap = Math.min(a.y2, b.y2)- Math.max(a.y1, b.y1);
		if (yOverlap<0) {
			yOverlap= 0;
		}
		return xOverlap * yOverlap; 
	}
}

class Rect {
	long x1, y1, x2, y2;
	
	Rect(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}