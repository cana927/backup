package acmicpc9012;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		for (int r =0; r<n; r++) {
			Boolean bad = false;
			Stack <Integer> s = new Stack <Integer> ();
			
			String p = sc.next(); 
			
			for (int i =0; i<p.length(); i++) {
				if (p.charAt(i) == '(') {
					s.push(1);
				}
				else {
					if (s.isEmpty()) {
						bad = true;
						break;
					} 
					else {
						s.pop();
					}
				}
			}
			if (bad || !s.isEmpty()) {
				System.out.println ("NO");
			}
			else {
				System.out.println ("YES");
			}
			
		}
	}
}
