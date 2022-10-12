import java.util.*;
class Main {
  public static void main(String[] args) {
    String[] freshDeck = shuffle();
    	Scanner inp = new Scanner(System.in);
    	System.out.println("\n\nLET'S PLAY A GAME OF WAR!\n\nEnter the name of the first player: ");
    String p1 = inp.next();
   	 System.out.println("Enter name of second player: ");
    String p2 = inp.next(); 
    Player1 play1 = new Player1(p1, distribute(freshDeck));
    Player2 play2 = new Player2(p2, dis2(freshDeck));
    GamePlay game = new GamePlay(play1, play2);
    	System.out.println();
    	System.out.println("Let's start!!!\n");
    game.playRound();
    
 //checks whether either player has 52 cards, if they do, "THIS IS THE END" is printed   
while((play1.getDeck().size() != 52 && play2.getDeck().size() != 52) && game.getLoser().length() == 0){
      game.playRound();
    }
    	System.out.println();
    	System.out.println("\nTHIS IS THE END!\n");
    	inp.close();
    }
  
public static String[] shuffle() { 
      Random rand = new Random();
      String[] finalD = Deck.cardsDeck;
//uses for loop to randomly shuffle the deck
    for(int i = 0; i < finalD.length; i++) {
	int randomIndexToSwap = rand.nextInt(finalD.length);
	String temp = finalD[randomIndexToSwap];
	finalD[randomIndexToSwap] = finalD[i];
	finalD[i] = temp;
	}
	return (finalD);
	}
  
public static ArrayList<String> shuffle(ArrayList<String> li) { 
	Random rand = new Random();
	ArrayList<String> finalD = li;
     for (int i = 0; i < finalD.size(); i++) {
	int randomIndexToSwap = rand.nextInt(finalD.size());
	String temp = finalD.get(randomIndexToSwap);
	finalD.set(randomIndexToSwap, finalD.get(i));
	finalD.set(i, temp);
	}
	return (finalD);
	}
  
public static String[] distribute(String[] d){
    String[] d1 = new String[26];
    	for(int i = 0; i<26; i++){
     	 d1[i] = d[i];
    	}
   	 return d1;
  }

  public static String[] dis2(String[] d){
    String[] d1 = new String[26];
    for(int i = 0; i<26; i++){
      d1[i] = d[i+26];
    }
    return d1;
  }
}
