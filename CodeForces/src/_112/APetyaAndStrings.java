package _112;

import java.util.Scanner;

public class APetyaAndStrings {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String one = sc.nextLine();
		String two = sc.nextLine();
		
		one = one.toLowerCase();
		two = two.toLowerCase(); 
		
		int len = one.length();
		int o = 0;
		int t = 0;
		
		int e = 0; 
		
		for(int i=0; i<len; i++) {
			if (one.charAt(i) < two.charAt(i)) {
				System.out.println(-1);
				e++;
				break;
			}
			if (one.charAt(i) > two.charAt(i)) {
				System.out.println(1);
				e++;
				break;
			}
		}
		if (e<1) {
			System.out.println (0); 
		}
	}
}
