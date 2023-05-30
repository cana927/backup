package easy;
import java.util.*;

public class AnagramChecker {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt ();
		
		for (int i =0; i<n; i++) {
			String line = sc.next();
			String one = line.substring(0, line.length()/2);
			String two = line.substring(line.length()/2+1);
			Boolean yes = true;
			if (one.equals(two)) {
				yes = false;
			}
			for (int r = 0; r<one.length(); r++) {
				for (int t = 0; t<two.length(); t++) {
					if (one.charAt(r) == two.charAt(t)) {
						two = two.substring(0,t) + two.substring (t+1);
						break;
					}
				}
			}
			if (two.length()!=0) {
				yes = false;
			}
			
			if (yes) {
				System.out.println (line + " = ANAGRAM");
			}
			else {
				System.out.println (line + " = NOT AN ANAGRAM");
			}
		}
	}
}
