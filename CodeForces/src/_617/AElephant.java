package _617;
import java.util.*;

public class AElephant {
	public static void main(String[]args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		int steps = 0;
		int where = 0;
		while (where < x) {
			steps ++;
			where += 5;
		}
		System.out.println(steps);
	}
}
