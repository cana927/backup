import java.util.ArrayList;

public class War {
	public static ArrayList<Card> deck = new ArrayList<Card>();
	
	public static ArrayList<Card> p1_deck = new ArrayList<Card>();
	public static ArrayList<Card> p2_deck = new ArrayList<Card>();
	
	public static void shuffleDeck() {
		for (int i =0; i<1000; i++) {
			int rIndex = (int)(Math.random()*deck.size());
			Card temp = deck.get(0);
			deck.set(0, deck.get(rIndex));
			deck.set(rIndex,  temp);
		}
	}
	
	public static void dealCards() {
		for (int i =0; i<deck.size(); i++) {
			if (i%2 ==0) {
				p1_deck.add(deck.get(i));
			}
			else {
				p2_deck.add(deck.get(i));
			}
		}
	}
	
	public static void main (String [] args) {
		for (String rank : Order.RANK_ORDER) {
			for (String suit : Order.SUIT_ORDER) {
				Card nc = new Card(rank,suit);
				deck.add(nc);
			}
		}
		
		shuffleDeck();
		// resorts Collections.sort(deck);
		
		dealCards();
		
		
		
		while (p1_deck.size()>0 && p2_deck.size() >0) {
			Card c1 = p1_deck.get(0);
			Card c2 = p2_deck.get(0);
			System.out.println ("1 : " + c1);
			System.out.println ("2 : " + c2);
			if (c1.compareTo(c2)<0) {
				System.out.println ("card 2 is higher");

				p2_deck.add(c1);
				p1_deck.remove(0);
				p2_deck.add(c2);
				p2_deck.remove(0);
			}
			else {
				System.out.println ("card 1 is higher");
				
				p1_deck.add(c2);
				p2_deck.remove(0);
				p1_deck.add(c1);
				p1_deck.remove(0);
			}
		}
		
		if (p1_deck.size() == 0) {
			System.out.println("player 2 won");
		}else {
			System.out.println ("player 1 won");
		}
	}
}