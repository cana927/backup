import java.util.ArrayList;

public class Main {
	public static ArrayList <Point> mainPoints;
	public static ArrayList<Point> points;
	
	public static void main (String [] args) {
		mainPoints = new ArrayList<Point>();
		mainPoints.add(new Point(126, 134));
		mainPoints.add(new Point(72, 600));
		mainPoints.add(new Point(567, 630));
		
		points = new ArrayList<Point>();
		
		for (double t = 0; t<= 1; t+=0.03) {
			points.add(Point.quadraticInt(t, mainPoints.get(0), mainPoints.get(1), mainPoints.get(2)));
		}
		points.add(new Point(567, 630));
		
		Mindow m = new Mindow();
		
		while (true) {
			try {
				Thread.sleep(12);
				m.repaint();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
