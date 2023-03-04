
public class Point {
	double x, y;
	

	public static Point linearInt (double t, Point A, Point B) {
		return A.multiply(1-t).combine(B.multiply(t));
	}
	
	public static Point quadraticInt(double t, Point A, Point B, Point C) {
		Point p1 = linearInt(t, A, B);
		Point p2 = linearInt(t, B, C);
		return linearInt (t, p1, p2);
	}
	
	
	public Point (double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Point multiply (double c) {
		return new Point(c*x, c*y);
	}
	
	public Point combine (Point o) {
		return new Point (x+o.x, y+o.y);
	}
	
}
