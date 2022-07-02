package Round1;

import java.util.Scanner;

public class bKnishop {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int times = 0; 
		int total = 0; 

		int dx = Math.abs(Math.abs(x1) - Math.abs(x));
		int dy = Math.abs(Math.abs(y1) - Math.abs(y));
		
		while (dx+dy != 3 && dx+dy != 0) {
			times = bishop (x, y, x1, y1); 
			dx = dx - times;
			dy = dy - times; 
			total ++;
		}
		
		if (dx+dy ==3) {
			total ++; 
		}
		System.out.println( total);
	}
	
	public static int bishop (int x, int y, int x1, int y1) {
		int a = 0;
		int b =0;
		
		int times = 0;
		
		if (x1<x) {
			a = -1;
		} else {
			a = 1;
		}
		if (y1<y) {
			b = -1;
		} else {
			b = 1;
		}

		int dx = Math.abs(Math.abs(x1) - Math.abs(x));
		int dy = Math.abs(Math.abs(y1) - Math.abs(y));
		
		while (Math.abs(x1)>=Math.abs(x) && Math.abs(y1)>=Math.abs(y) && dx+dy != 0 && dx+dy != 3) {
			x = x + a;
			y = y+ b;
			times ++; 
			dx --;
			dy --; 
		}
		return times; 
	}
}
