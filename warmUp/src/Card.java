import java.io.*;
import java.util.*;

public class Card  implements Comparable<Card>{
	
	
	String rank;
	String suit;
	
	public Card (String r, String s) {
		rank = r;
		suit = s;
	}
	
	/*
	 overrides
	 
	 negative --> this < other
	 zero 	  --> equal
	 positive --> this > other
	 */
	public int compareTo (Card other) {
		int ri = Order.rankIndex(rank);
		int si = Order.suitIndex(suit);
		
		int ori = Order.rankIndex(other.rank);
		int osi = Order.suitIndex(other.suit);
		
		if (ri < ori ) {
			return -1;
		}
		else if (ri == ori) {
			if (si < osi ) {
				return -1;
			}else if (si == osi) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
	
	public String toString() {
		return rank + " of " + suit;
	}
}
