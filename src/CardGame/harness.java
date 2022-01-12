package CardGame;
import CardGame.Card.*;
import CardGame.Deck;
//import CardGame.Card.Rank;
//import CardGame.Card.Suits;

public class harness {
//	enum Suits2 { CLUBS (0), HEARTS(13), DIAMONDS(26), SPADES(39);
//		private int value;
//		private Suits2(int i) {  this.value = i; };
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (Suits2 s : Suits2.values() ) {
//			System.out.println(s + "ordinal : " + s.ordinal()+ " Value " +s.value +"  Name : "+s.name());
//		}
		Card card = new Card(Suits.HEARTS , Rank.THREE );
		System.out.println(card.describe());
		Card card2 = new Card(43);
		System.out.println(card2.describe());
		System.out.println(card.compareTo(card2));
		Deck deck = new Deck();
		for (Card c : deck.cards) System.out.print(c.describe());
		System.out.println();
		deck.shuffle();
		for (Card c : deck.cards) System.out.print(c.describe());
		System.out.println();
		Card cCard,pCard;
		pCard = deck.draw();
		for (int i = 0 ; i< 10 ; i++) {
			cCard =deck.draw();
			int cmp = cCard.compareTo(pCard) ;
			if (cmp < 0 ) System.out.println(cCard.describe() + " is less than " + pCard.describe());
			else System.out.println(pCard.describe() + " is less than " + cCard.describe());
			pCard = cCard;
		}
		// Array with set all with generator function  Arrays.setAll(myArray, (index) -> 1 + index);
//List<Integer> range = IntStream.rangeClosed(start, end)
//	    .boxed().collect(Collectors.toList());
//		List<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());
	}

}
