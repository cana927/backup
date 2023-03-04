import java.awt.event.*;

public class PointGrabber extends MouseAdapter{
	
	Point focusedPoint;
	
	public void mousePressed(MouseEvent e) {
		Point closestPoint = null;
		double minDistance = 2000;
		for (Point p : Main.mainPoints) {
			double d = Math.sqrt(Math.pow(p.x - e.getX(), 2) + Math.pow(p.y-e.getY(),2));
			if (d<minDistance) {
				closestPoint = p;
				minDistance = d;
			}
		}
		
		if (minDistance <=6) {
			focusedPoint = closestPoint;
		}else {
			focusedPoint = null;
		}
	}
	
	public void mouseDragged (MouseEvent e ) {
		if (focusedPoint != null) {
			focusedPoint.x = e.getX();
			focusedPoint.y = e.getY();
			
			Main.points.clear();
			Point A = Main.mainPoints.get(0);
			Point B = Main.mainPoints.get(1);
			Point C = Main.mainPoints.get(2);
			for (double t = 0; t<=1; t+=0.03) {
				Main.points.add(Point.quadraticInt(t,  A,  B, C));
			
			}
			Main.points.add(C);
		}
	}
}
