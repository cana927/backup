package _231;

import java.util.Scanner;

public class ATeam {
	public static void main (String [] args) {
		int sol = 0;
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		for (int i= 0; i<n; i++) {
			int r = 0;
			r = r+ sc.nextInt () + sc.nextInt() + sc.nextInt();
			if (r>1) {
				sol++;
			}
		}
		
		System.out.println (sol); 
	}
}
