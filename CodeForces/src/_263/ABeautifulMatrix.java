package _263;

import java.util.Scanner;

public class ABeautifulMatrix {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int [][] a = new int [5][5];
		int i = 0;
		int j = 0;
		for (int r=0; r<5; r++) { 
			for (int c = 0; c<5; c++) {
				a[r][c] = sc.nextInt(); 
				if (a[r][c] == 1) {
					i= r;
					j=c;
				}
			}
		}
		int fin = 0;
		fin += Math.abs (2-i);
		fin += Math.abs(2-j);
		System.out.println(fin);
	}
}
