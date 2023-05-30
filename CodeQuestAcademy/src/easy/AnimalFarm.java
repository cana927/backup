package easy;
import java.util.*;

public class AnimalFarm {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		for (int i =0; i<n; i++) {
			int t = sc.nextInt();
			int four = sc.nextInt() + sc.nextInt();
			
			System.out.println (2*t + 4*four);
		}
	}
}
