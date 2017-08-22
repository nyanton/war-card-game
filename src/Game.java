import java.util.ArrayList;

public class Game {
	private Player p1, p2;
	
	public Game(){
	}
	
	public void battle(){
		ArrayList<Integer> pile = new ArrayList<Integer>();
		
		
		int p1Card = p1.battleAttack();
		int p2Card = p2.battleAttack();
		
		
		if (p1Card > p2Card){
			//reward p1
			pile.add(p1Card);
			pile.add(p2Card);
			
			p1.addCards(pile);
		}
		
		else if (p2Card > p1Card){
			//reward p2
			pile.add(p2Card);
			pile.add(p1Card);
			
			p2.addCards(pile);
		}	
		
		else{
			//war
			ArrayList<Integer>p1Pile = new ArrayList<Integer>();
			ArrayList<Integer>p2Pile = new ArrayList<Integer>();
			
			p1Pile.add(p1Card);
			p2Pile.add(p2Card);
			
			war(p1Pile, p2Pile);
			
		
		}
	}
	
	public void war(ArrayList<Integer>p1Pile, ArrayList<Integer>p2Pile){
		checkVictory();
		if(p1.getDefeated() || p2.getDefeated()){
			
		}
		
		else{
			if(p1.getDeck().size() == 3 || p2.getDeck().size() == 3){
				//case for when either player has only 3 cards left in their deck
				
				p1Pile.addAll(p1.warAttack(2));
				p2Pile.addAll(p2.warAttack(2));	
			}
			
			else if(p1.getDeck().size() == 2 || p2.getDeck().size() == 2){
				//the case where either player has only 2 cards left in their deck
				
				p1Pile.addAll(p1.warAttack(1));
				p2Pile.addAll(p2.warAttack(1));
			}
			
			else if(p1.getDeck().size() == 1 || p2.getDeck().size() == 1){
				//case where either player has only one card left in their deck
	
				p1Pile.addAll(p1.warAttack(0));
				p2Pile.addAll(p2.warAttack(0));
			}
			
			else{
				//case where either player has more than 3 cards left in their deck
				
				p1Pile.addAll(p1.warAttack(3));
				p2Pile.addAll(p2.warAttack(3));
			}
			
			int cardDiff = p1Pile.get(p1Pile.size()-1) - p2Pile.get(p2Pile.size()-1);
			
			if (cardDiff > 0){
				//case for when player 1 has won the war
				
				p1.addCards(p1Pile);
				p1.addCards(p2Pile);
			}
			
			else if (cardDiff < 0){
				//case for when player 2 has won the war
				
				p2.addCards(p1Pile);
				p2.addCards(p2Pile);
			}
			
			else{
				//case for if it is another tie
				war(p1Pile, p2Pile);
			}
		}
	}
	
	private void checkVictory(){
		p1.checkDefeated();
		p2.checkDefeated();
	}
	
	public boolean checkEnd(){
		boolean check = false;
		
		checkVictory();
		
		if(p1.getDefeated() && p2.getDefeated()){
			check = true;
			
			System.out.println("It's a tie!");
			
		}
		
		else if(p2.getDefeated()){
			check = true;
			
			System.out.println("Player 1 wins!");
		}
		
		else if(p1.getDefeated()){
			check = true;
			
			System.out.println("Player 2 wins!");
		}
			
		return check;
	}
	
	public void setPlayer1(Player player){
		p1 = player;
	}
	
	public void setPlayer2(Player player){
		p2 = player;
	}
	
	public ArrayList<Integer> setupDeck1(){
		ArrayList<Integer> deck = new ArrayList<Integer>();
		
		deck.add(5);
		deck.add(1);
		deck.add(13);
		deck.add(10);
		deck.add(11);
		deck.add(3);
		deck.add(2);
		deck.add(10);
		deck.add(4);
		deck.add(12);
		deck.add(5);
		deck.add(11);
		deck.add(10);
		deck.add(5);
		deck.add(7);
		deck.add(6);
		deck.add(6);
		deck.add(11);
		deck.add(9);
		deck.add(6);
		deck.add(3);
		deck.add(13);
		deck.add(6);
		deck.add(1);
		deck.add(8);
		deck.add(1);
		
		return deck;	
	}
	
	public ArrayList<Integer> setupDeck2(){
		ArrayList<Integer> deck = new ArrayList<Integer>();
		
		deck.add(9);
		deck.add(12);
		deck.add(8);
		deck.add(3);
		deck.add(11);
		deck.add(10);
		deck.add(1);
		deck.add(4);
		deck.add(2);
		deck.add(4);
		deck.add(7);
		deck.add(9);
		deck.add(13);
		deck.add(8);
		deck.add(2);
		deck.add(13);
		deck.add(7);
		deck.add(4);
		deck.add(2);
		deck.add(8);
		deck.add(9);
		deck.add(12);
		deck.add(3);
		deck.add(12);
		deck.add(7);
		deck.add(5);
		
		return deck;
	}
}
