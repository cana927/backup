package Round1;

import java.util.Arrays;
import java.util.Scanner;

public class cBashyMath {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		int [] a = new int [n];
		
		int total = 0; 
		
		for (int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		
		for (int i = 0; i<n-1; i++) {
			for (int r = i+1; r<n; r++) {
				if (a[i]>=1 && a[r] <= n && a[r] != a[i] && a[r]%a[i] == 0) {
					total ++; 
				}
			}
		}
		System.out.println(total);
	}
}
