package _71;

import java.util.Scanner;

public class AWayTooLongWords {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in); 
		int n = sc.nextInt(); 
		for (int i= 0; i<n; i++) {
			String word = sc.next();
			if (word.length() < 11) {
				System.out.println (word);
			} 
			else {
				String r = "";
				r = r + word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1);
				System.out.println (r); 
			}
		}
	}
}
