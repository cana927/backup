package easy;
import java.util.*;

public class AntiAsteroidWeapon {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		
		for (int i =0; i<n; i++) {
			int a = sc.nextInt();
			int [][] asteroids = new int [a][3];
			
			for (int r = 0; r<a; r++) {
				asteroids[r][0] = sc.nextInt();
				asteroids[r][1] = sc.nextInt();
				asteroids[r][2] = (int) Math.sqrt(asteroids[r][0]*asteroids[r][0] + asteroids[r][1]*asteroids[r][1]);
				
			}
			
			
			Arrays.sort (asteroids, new Comparator<int[]>() {
				public int compare(int []a, int[]b) {
					return a[2]-b[2];
				}
			});
			for (int e =0; e<a; e++) {
				System.out.println (asteroids[e][0] + " " + asteroids[e][1]);
			}
		}
		
	}
}
