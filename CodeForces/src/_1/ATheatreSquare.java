package _1;
import java.util.*;

public class ATheatreSquare {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		long a = sc.nextInt();
		
		long sidea = 0;
		long sideb = 0;
		
		sidea = n/a;
		if (n > sidea*a) {
			sidea++;
		}
		sideb = m/a;
		if (m > sideb*a) {
			sideb++;
		}
		
		System.out.println (sidea*sideb);
	}
}