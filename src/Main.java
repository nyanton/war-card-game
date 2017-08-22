
public class Main {

	public static void main(String[] args) {
	
		Game game = new Game();
		
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		
		p1.setDeck(game.setupDeck1());
		p2.setDeck(game.setupDeck2());
		
		game.setPlayer1(p1);
		game.setPlayer2(p2);
		
		do{
			game.battle();
			
		}while(!game.checkEnd());
		
		
	}

}
