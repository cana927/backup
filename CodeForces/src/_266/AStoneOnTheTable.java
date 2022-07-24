package _266;
import java.util.*;

public class AStoneOnTheTable {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		int num = sc.nextInt();
		String stones = sc.next();
		int take = 0;
		for (int i =0; i<num-1; i++) {
			if (stones.charAt(i) == stones.charAt(i+1)) {
				take++;
			}
		}
		System.out.println(take);
	}
}
