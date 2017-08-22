import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Integer> deck = new ArrayList<Integer>();
	
	private boolean defeated;
	
	public Player(String name){
		this.name = name;
		defeated = false;
	}
	
	public void checkDefeated(){
		//used to check to see if the player has run out of cards in their deck
		if(deck.size() == 0){
			defeated = true;
		}
	}
	
	
	public int battleAttack(){
		//used for when the player only uses one card to attack
		int card = deck.get(0);
		deck.remove(0);
		
		return card;
	}
	
	public ArrayList<Integer> warAttack(int facedowns){
		//used for when the player starts a war attack
		//the facedown parameter is for how many cards will be used to place before drawing a card.
		ArrayList<Integer> cards = new ArrayList<Integer>();
		
		for (int i = 0; i <= facedowns; i++){
			cards.add(deck.get(0));
			deck.remove(0);
		}
		
		return cards;
	}
	
	public void addCards(ArrayList<Integer>pile){
		deck.addAll(pile);
		for(int i = 0; i < pile.size(); i++){
			System.out.println("Got " + pile.get(i));
			
		}
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Integer> getDeck(){
		return deck;
	}
	
	public void setDeck(ArrayList<Integer> deck){
		this.deck = deck;
	}
	
	public boolean getDefeated(){
		return defeated;
	}
}
