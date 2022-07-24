package _236;
import java.util.*;

public class ABoyOrGirl {
	public static void main (String [] args) {
		String letters = "";
		Scanner sc = new Scanner (System.in);
		String name = sc.nextLine();
		for (int i = 0; i<name.length(); i++) {
			char let = name.charAt(i);
			Boolean distinct = true; 
			for (int e = 0; e<letters.length(); e++) {
				if (let == letters.charAt(e)) {
					distinct = false; 
				}
			}
			if (distinct) {
				letters += let; 
			}
		}
		if (letters.length() %2 == 1) {
			System.out.println ("IGNORE HIM!");
		}else {
			System.out.println ("CHAT WITH HER!");
		}
	}
}
