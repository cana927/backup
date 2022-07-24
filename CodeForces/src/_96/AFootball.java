package _96;
import java.util.*;

public class AFootball {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		
		String num = sc.next();
		
		Boolean dangerous = false;
		
		int team = -1;
		int chain = 0;
		
		for (int i = 0; i<num.length(); i++) {
			if (num.charAt(i) -'0' == team ) {
				chain ++;
			}else {
				team = num.charAt(i) - '0';
				chain = 1;
			}
			if (chain ==7) {
				dangerous = true;
			}
		}
		if (dangerous) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}