package Round2;

import java.util.Scanner;

public class aHelloWorld {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		double [] a = new double [n];
		for (int i = 0; i<n; i++) {
			a [i] = sc.nextDouble();
		}
		
		int total = 0;
		
		for (int i = 0; i<n; i++) {
			for (int r = 0; r<n; r++) {
				double t = a[i]/a[r];
				for (int e = 0; e<n; e++) {
					if (t == a[e]) {
						total ++;
					}
				}
			}
		}
		System.out.println((int)total); 
		
	}
}
