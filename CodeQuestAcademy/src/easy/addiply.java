package easy;
import java.util.*;

public class addiply {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		int times = sc.nextInt();
		
		for (int i =0; i<times; i++) {
			int one = sc.nextInt();
			int two = sc.nextInt(); 
			System.out.println (one+two + " " + one*two);
		}
	}
}

/*
3
2 2
5 4
3 8
*/