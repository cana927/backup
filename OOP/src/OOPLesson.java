import java.util.*;
import java.io.*;

public class OOPLesson {
	
	static String [] ranks = {
			"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHHT", "NINE", "TEN", "JACK", "QUEEN", "KING"
	};
	
	static String [] suits = {
			"HEARTS", "DIAMONDS", "SPADES", "CLUBS"
	};
	
	public static void main (String [] args) {
		
		Card c1 = getRandomCard();
				//new Card("ace", "clubs");
		
		//initialization (tedious)
		//c1.rank = "ace";
		//c1.suit = "clubs";
		
		//System.out.println (c1.rank + " of " + c1.suit);
		//with overriding, we can do
		System.out.println (c1);
		
	}
	
	public static Card getRandomCard() {
		int indexr = (int)(Math.random() *13);
		String r = ranks[indexr];
		
		int indexs = (int)(Math.random() *4);
		String s = suits[indexs];
		
		return new Card (r,s);
	}
}

class Card { // objects are capitalized
	String rank;
	String suit;
	
	//constructor : function without a return, and same as class
	//easier initialization
	public Card (String r, String s ) {
		rank = r;
		suit = s;
	}
	
	//overriding 
	public String toString () {
		return rank + " of " + suit;
	}
}