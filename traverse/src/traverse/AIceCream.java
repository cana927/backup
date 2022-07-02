package traverse;
import java.util.*;

public class AIceCream {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int i = sc.nextInt();
		
		if (n>= i) {
			System.out.println("ICE CREAM");
		} else if (n+k>= i) {
			System.out.println("DRINK WATER");
		} else {
			System.out.println ("CANNOT EAT");
		}
	}
}
