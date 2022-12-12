import java.util.*;
import java.io.*;

public class dec11_22_2 {//angle between of 2 vectors
	public static void main (String [] args ) {
		Scanner sc = new Scanner (System.in);
		double ax = sc.nextDouble();
		double ay = sc.nextDouble();
		double bx = sc.nextDouble();
		double by = sc.nextDouble();
		
		double angle1 = Math.atan2(ay, ax);
		double angle2 = Math.atan2(by, bx);
		 
		/*
		 double angle1 = Math.acos(ax/(Math.sqrt(ax*ax + ay*ay)));
		double angle2 = Math.acos(bx/(Math.sqrt(bx*bx + by*by)));
		
		 */
		angle1 = angle1*180/Math.PI;
		angle2 = angle2*180/Math.PI;
		
		System.out.println(angle1);
		System.out.println(angle2);
	}

}
/*
3.1 4 
5 6.5
*/