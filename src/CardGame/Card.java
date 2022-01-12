package CardGame;

import java.util.HashMap;
import java.util.Map;

public class Card {

	public enum Suits { CLUBS (0), HEARTS(13), DIAMONDS(26), SPADES(39) ;  //Order the suits by Bridge values
		
		private int value;
		private Suits(int i) {  this.value = i; }
		
		private static Map map = new HashMap<>();
		static { for (Suits suit : Suits.values()) { map.put(suit.value,  suit); }}
		public static Suits valueOf(int svalue) {return (Suits) map.get(svalue); }
	}
		
	public enum Rank { TWO(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6),
		NINE(7), TEN(8), JACK(9), QUEEN(10), KING(11), ACE(12);    
		private Rank(int i) { this.value = i; }
		int value;
	}
	private Rank rank;
	private String name;
	private Suits suit;
	private int value;    //Code doesn't need this but in the requirements document
	
	//In reality all of these methods should be hardened to check for out of bound/illegal values
	//but -- school project
	public Card (Suits suit, Rank rank ) {
		this.suit  = suit;
		this.rank  = rank;
		this.value = rank.ordinal()+2;
		this.name  = generateName(suit,rank);
	}
	public Card (int ordValue) {
		//This makes my teeth hurt.  
		//The correct way is to implement a static lookup map in the enums
		//Or use the EnumMap collection provided since Java 1.5
		this.rank = Rank.values()[ordValue % 13];
		this.suit = Suits.valueOf(ordValue-ordValue%13);  //Lookup in the static map
		this.value = rank.ordinal()+2;  //adjust my ordinal to the value of the requirements document
		this.name = generateName(this.suit,this.rank);
	}
	
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String generateName(int ordValue) {
		return null;
	}
	public String generateName(Suits suit , Rank rank) {
		return (rank + " of " + suit);
	}
	
	public int compareTo(Card aCard) {
		//Compare menthod  -- This assumes that suits are more important than rank value of a card
		// for example the 2 of Hearts is of greater value than any Club
		int suitCompare = this.suit.compareTo(aCard.suit);
		if (suitCompare != 0 )  { return suitCompare; }
		return this.rank.compareTo(aCard.rank);
	}
	
	public String describe() { return name; }
	public String describe(int value) { return generateName(value); }
	public String describe(Suits suit, Rank rank) { return  generateName(suit,rank); }
}
