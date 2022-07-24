package _546;
import java.util.*;

public class ASoldierAndBananas {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		int cost = 0;
		
		for (int i = 1; i<= w; i++) {
			cost += k*i;
		}
		
		int borrow = Math.max(0, cost - n);
		System.out.println (borrow);
	}
}
