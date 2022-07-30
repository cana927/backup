package _118;
import java.util.*;

public class AStringTask {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String word = sc.next();
		word = word.toLowerCase();
		String out = "";
		for (int i = 0; i<word.length(); i++) {
			if (word.charAt(i) == 'y'||word.charAt(i) == 'a'||word.charAt(i) == 'e'||word.charAt(i) == 'i'||word.charAt(i) == 'o'||word.charAt(i) == 'u') {
				
			} else {
				out = out + "." + word.charAt(i);
			}
		}
		System.out.println(out);
	}
}
