package _158;

import java.util.Scanner;

public class ANextRound {
	public static void main (String [] args) {
		Scanner  sc = new Scanner (System.in) ;
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] a = new int [n];
		for (int i =0; i< n; i++) {
			a [i] = sc.nextInt(); 
		}
		int r = 0;
		for (int i = 0; i< n; i++) {
			if (a[i] > 0 && a[i] >= a[k-1]) {
				r++;
			}
		}
		System.out.println (r); 
	}
}
