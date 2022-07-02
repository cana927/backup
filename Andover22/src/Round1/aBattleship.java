package Round1;

import java.util.Scanner;

public class aBattleship {
	public static void main (String [] args){
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		String [][] a = new String [n][n]; 
		for (int i = 0; i<n; i++) {
			for (int j =0; j<n; j++) {
				a[i][j] = sc.next();
			}
		}
		
		if (a[x][y].equals ("S")) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes"); 
		}
	}
}
