package easy;
import java.util.*;

public class AEIOU {
	public static void main (String [] args) { 
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i<n; i++) {
			String line = sc.nextLine();
			int v = 0;
			for (int r = 0; r<line.length(); r++) {
				if (line.charAt(r) == 'a' || line.charAt(r) == 'e' || line.charAt(r) == 'i' || line.charAt(r) == 'o' || line.charAt(r) == 'u') {
					v ++;
				}
			}
			System.out.println (v);
		}
	}
}
