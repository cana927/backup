package traverse;
import java.util.*;

public class ECustomCake {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int k = n;
		int [] a = new int [n];
		
		for (int i =0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i<n; i++) {
			if (i<n-1) {
				for (int r = i+1; r<n; r++) {
					if (a[i] == a[r]) {
						if (i+1 != r) {
							int w =0;
							for (int e = i+1; e<r; e++) {
								if (a[e] <= a[i]) {
									w++;
								}
							}
							if (w==0) {
								k--;
							}
						} else  {
							if (k!= 1) {
								k--;
							}
				
						}
					}
				}
			}
		}

		System.out.println(k); 
		
	} 
}
