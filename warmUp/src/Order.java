
public class Order {
	public static final String[] RANK_ORDER = "ACE TWO THREE FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING".split(" ");
	
	public static final String[] SUIT_ORDER= "DIAMONDS CLUBS HEARTS SPADES".split(" ");
	
	public static int rankIndex (String rank) {
		for (int i = 0; i<RANK_ORDER.length; i++ ) {
			if (rank.equals(RANK_ORDER[i])) return i;
		}
		return -1;
	}
	public static int suitIndex (String suit) {
		for (int i = 0; i<SUIT_ORDER.length; i++ ) {
			if (suit.equals(SUIT_ORDER[i])) return i;
		}
		return -1;
	}
}
