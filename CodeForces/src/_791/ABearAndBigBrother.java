package _791;
import java.util.*;

public class ABearAndBigBrother {
	public static void main(String[]args) {
		Scanner sc = new Scanner (System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int years =0;
		while (a<=b) {
			years++;
			a = a*3;
			b = b*2;
		}
		System.out.println(years);
	}
}
