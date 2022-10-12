import java.util.*;
public class player2{
  private ArrayList<String> assignedDeck;
  private String name;
 public Player2(String n, String[] d){
     name = n;
     ArrayList<String> fin = new ArrayList<>(Arrays.asList(d));
     assignedDeck = fin;
   }
  public String getName(){
    return name;
  }
  public void modifyDeck(ArrayList<String> deck){
    assignedDeck = deck;
  }
  public ArrayList<String> getDeck(){
    return assignedDeck;
  }
  public String play(){
   	 String cardToPlace = assignedDeck.get(0);
   	 assignedDeck.remove(cardToPlace);
    if(assignedDeck.size() == 26){
     	 Main.shuffle(assignedDeck);
    }
    return cardToPlace;
  }
}
