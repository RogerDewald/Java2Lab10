import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.HashSet;

public class CribbageHand {
	
	public final static Map<Rank, Integer> CARD_VALUES = Map.ofEntries(
			entry(Rank.ACE, 1),
			entry(Rank.KING, 10),
			entry(Rank.QUEEN, 10),
			entry(Rank.JACK, 10),
			entry(Rank.TEN, 10),
			entry(Rank.NINE, 9),
			entry(Rank.EIGHT, 8),
			entry(Rank.SEVEN, 7),
			entry(Rank.SIX, 6),
			entry(Rank.FIVE, 5),
			entry(Rank.FOUR, 4),
			entry(Rank.THREE, 3),
			entry(Rank.TWO, 2));
	public final List<Card> cards;
	
	public CribbageHand (Card c1, Card c2, Card c3, Card c4) throws NullPointerException {
		if (c1 == null || c2 == null || c3 == null || c4 == null) {
			throw new NullPointerException();
		}
		cards = List.of(c1,c2,c3,c4);
	}
	
	public static Set<Set<Card>> powerSet (List<Card> cards){
		 if (cards.isEmpty()) {
	            Set<Set<Card>> emptySet = new HashSet<>();
	            emptySet.add(new HashSet<>());
	            return emptySet;
	        } else {
	            Card first = cards.get(0);
	            List<Card> rest = cards.subList(1, cards.size());
	            Set<Set<Card>> subsets = powerSet(rest);
	            Set<Set<Card>> subsetsWithFirst = new HashSet<>(subsets);
	            for (Set<Card> subset : subsets) {
	                Set<Card> subsetWithFirst = new HashSet<>(subset);
	                subsetWithFirst.add(first);
	                subsetsWithFirst.add(subsetWithFirst);
	            }
	            return subsetsWithFirst;
	        }
	}
	 public Set<Set<Card>> fifteens(Card starter) {
	        Set<Card> allCards = new HashSet<>(cards);
	        allCards.add(starter);
	        Set<Set<Card>> allSubsets = powerSet(new ArrayList<>(allCards));
	        Set<Set<Card>> fifteens = new HashSet<>();
	        for (Set<Card> subset : allSubsets) {
	            int sum = subset.stream().mapToInt(card -> CARD_VALUES.get(card.getRank())).sum();
	            if (sum == 15) {
	                fifteens.add(subset);
	            }
	        }
	        return fifteens;
	    }

}
