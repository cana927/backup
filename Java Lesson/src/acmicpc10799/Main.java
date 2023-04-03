package acmicpc10799;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		Stack <Integer> s = new Stack <Integer> ();
		Scanner sc  = new Scanner (System.in);
		
		String p = sc.next();
		int num = 0;
		
		for (int i = 0; i<p.length(); i++) {
			if (i < p.length()-1) {
				if (p.charAt(i) == '(' && p.charAt(i+1) == ')') {
					if (!s.isEmpty()) {
						num += s.size();
					}
					i++;
				}
				else {
					if (p.charAt(i) == '(') {
						s.push(1);
						num++;
					}else {
						s.pop();
					}
				}
			}
			else  {
				if (p.charAt(i) == '(') {
					s.push(1);
				}else {
					s.pop();
				}
			}
		}
		System.out.println (num);
	}
}
