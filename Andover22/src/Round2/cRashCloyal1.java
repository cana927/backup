package Round2;
import java.util.Arrays;
import java.util.Scanner;

public class cRashCloyal1 {
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
		
		int diff = -5000;
		int a1 = 0;
		int b1= 0;
		int num = 0;
		int total = 0;
		
		for (int i=0; i<n; i++) {
			if (Math.abs(over-a[i])<Math.abs(diff)) {
				diff = a[i] - over;
				a1 = a[i];
				num = i;
			}
		}
		int aover = over - diff; 
		for (int i =0; i<n; i++) {
			if (b[i] >= aover ) {
				b1 = b[i];
				break; 
			}
		}
		if (b1 == 0) {
			a1 = a[num-1];
			diff = a[num-1] - over;
			int bover = over - diff; 
			for (int r =0; r<n; r++) {
				if (b[r] >= bover) {
					b1 = b[r];
				}
			}
		}
		total = a1 + b1; 
		
		System.out.println(total); 
	}
}
