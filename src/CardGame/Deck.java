package CardGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import CardGame.Card;

public class Deck {

	private static final int DeckSize = 52;
	int current;
	List<Card> cards;
	Deck() {
		cards = new ArrayList<Card>();
		for (int i = 0 ; i < DeckSize; i++) { cards.add(new Card(i)); }
	}
	void shuffle() {
		for (int i = 0; i < DeckSize; i++) {
		      int index = (int)(Math.random() * DeckSize);
		      Card temp = cards.get(i);
		      cards.set(i,cards.get(index));
		      cards.set(index,temp);
		    }
		current = 0;
	}
	Card draw() {
		return cards.get(current++);
	}
}
