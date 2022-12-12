import java.util.*;
import java.io.*;

public class dec11_22 {//distance of 2 vectors
	public static void main (String [] args ) {
		Scanner sc = new Scanner (System.in);
		double ax = sc.nextDouble();
		double ay = sc.nextDouble();
		double bx = sc.nextDouble();
		double by = sc.nextDouble();
		
		double distance = Math.sqrt((ax-bx)*(ax-bx) + (ay-by)*(ay-by));
		
		System.out.println(distance);
	}

}
/*
3.1 4 
5 6.5
*/