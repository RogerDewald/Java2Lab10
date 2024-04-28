import java.util.Objects;

public class Card implements Comparable<Card> {
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) throws NullPointerException {
		
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		else {
			this.rank = rank;
			this.suit = suit;
		}
		
	}
	
	public int compareTo(Card card) {
		 int suitComparison = this.suit.compareTo(card.suit);
		    if (suitComparison != 0) {
		        return suitComparison;
		    } else {
		        return this.rank.compareTo(card.rank);
		    }
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
	        return false;
	    }
	    Card card = (Card) obj;
	    return this.rank.equals(card.rank) && this.suit.equals(card.suit);
		
	}
	@Override
	public int hashCode() {
		 return Objects.hash(rank, suit);
	}
	public String toString() {
		return rank.toString()+suit.toString();
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}

}
