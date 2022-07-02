package _281;

import java.util.Scanner;

public class AWordCapitalization {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		
		String r = sc.next();
		
		String e = Character.toUpperCase(r.charAt(0)) + r.substring (1);
		
		System.out.println (e); 
	}
}
