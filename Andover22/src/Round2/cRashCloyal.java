package Round2;

import java.util.Arrays;
import java.util.Scanner;

public class cRashCloyal {
	public static void main (String []args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		int [] a = new int [n];
		int [] b = new int [n];
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i<n; i++) {
			b[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		Arrays.sort(b); 
		
		int max = Math.max(a[n-1], b[n-1]);
		int over = max / 2;
		if (max %2 == 1) {
			over ++; 
		}
		
		int diffa = -500000000;
		int diffb = -500000000; 
		int a1 = 0;
		int b1= 0;
		int a2=0;
		int b2 = 0;
		int anum = 0;
		int bnum = 0; 
		int total1 = 0;
		int total2 = 0;
		
		for (int i=0; i<n; i++) {
			if (Math.abs(over-a[i])<=Math.abs(diffa)) {
				diffa = a[i] - over;
				a1 = a[i];
				anum = i;
			}
		}
		int aover = over - diffa; 
		for (int i =0; i<n; i++) {
			if (b[i] >= aover) {
				b1 = b[i];
			}
		}
		if (b1 == 0) {
			a1 = a[anum-1];
			diffa = over - a[anum-1];
			over = over - diffa; 
			for (int r =0; r<n; r++) {
				if (b[r] >= over) {
					b1 = b[r];
				}
			}
		}
		total1 = a1 + b1; 
		
		
		
		
		for (int i=0; i<n; i++) {
			if (Math.abs(over-b[i])<=Math.abs(diffb)) {
				diffb = b[i] - over;
				b2 = b[i];
				bnum = i;
			}
		}
		int bover = over - diffb; 
		for (int i =0; i<n; i++) {
			if (a[i] >= bover) {
				a2 = a[i];
			}
		}
		if (b2==0) {
			b2 = b[bnum-1];
			diffb = over - b[bnum-1];
			bover = over - diffb; 
			for (int r =0; r<n; r++) {
				if (a[r] >= bover) {
					a2 = a[r];
				}
			}
		}
		total2 = a2 + b2; 
		
		int last = Math.min(total2, total1);
		System.out.println(last); 
	}
}
