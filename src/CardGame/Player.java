package CardGame;
import java.util.ArrayList;
import java.util.List;

import CardGame.*;

public class Player {
	List<Card> hand;
	private int score;
	private String name;
	
	Player() {
		score = 0;
		hand =  new ArrayList<Card>();
		name = "";
	}
	
	Player(String name) {
		score = 0;
		hand = new ArrayList<Card>();
		this.name = name;
	}

	
	Card flip() {
		if ( hand.size() > 0) { return(hand.remove(0)); }
		else return null;// should error here instead
		}
	
	void draw(Deck deck) {hand.add(deck.draw());}
	
	int incrementScore() { return(++score); }
	
	void describe() {
		System.out.println("*** Player : " + name + "   ***");
		for ( Card c : hand) System.out.println(c.describe());
	}

	public List<Card> getHand() {
		return hand;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
