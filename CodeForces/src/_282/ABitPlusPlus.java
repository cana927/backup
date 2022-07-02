package _282;

import java.util.Scanner;

public class ABitPlusPlus {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int r = 0;
		for (int i= 0; i<n; i++) {
			String q = sc.next();
			char t = q.charAt(0);
			if (t == 'X') {
				t = q.charAt(1); 
			}
			if (t == '+') {
				r++;
			} else {
				r--;
			}
		}
		System.out.print(r); 
	}
}
