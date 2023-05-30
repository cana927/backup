package easy;
import java.util.*;

public class AreYouASpy {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int w = 0; w<n; w++) {
			Boolean isAgent = true;
			String str = sc.nextLine();
			int place = str.indexOf("|");
			
			String one = str.substring(0, place).toLowerCase();
			String two = str.substring(place+1).toLowerCase();
			
			int [] abc = new int [26];
			
			for (int i =0; i<one.length(); i++) {
				if (Character.isAlphabetic(one.charAt(i))) {
					abc[one.charAt(i)-'a'] ++;
				}
			}
			for (int i =0; i<two.length(); i++) {
				if (Character.isAlphabetic(two.charAt(i))) {
					if (abc[two.charAt(i)-'a'] ==0) {
						isAgent = false;
					}
				}
			}
			
			if (isAgent) {
				System.out.println ("That's my secret contact!");
				
			}
			else {
				System.out.println("You're not a secret agent!");
			}
		}
	}
}
