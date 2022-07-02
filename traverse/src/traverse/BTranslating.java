package traverse;
import java.util.*;

public class BTranslating {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int w = sc.nextInt();
		
		String a = "";
		
		for (int i = 0; i<w/2; i++) {
			String r = sc.next();
			String t = sc.next();
			
			if (r.compareTo(t) > 1) {
				a=  t + "-" + r + " " + a;
			} else if (r.compareTo(t) <0) {
				a=  r + "-" + t +" " + a;
			} else {
				a = t + "-" + r + " " + a;
			}
		}
		System.out.println (a);
	}
}
