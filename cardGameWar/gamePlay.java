import java.util.*;
public class gamePlay{
  private Player1 p1;
  private Player2 p2;
  private String leader; 
  private String couldNotDoWar = "";

  public GamePlay(Player1 p1, Player2 p2){
    this.p1 = p1;
    this.p2 = p2;
  }

  public int giveOrder(String a){
    if(a.equals("ace")){
      return 1;
    } else if (a.equals("two")){
      return 2;
    } else if (a.equals("three")){
      return 3;
    } else if (a.equals("four")){
      return 4;
    } else if (a.equals("five")){
      return 5;
    } else if (a.equals("six")){
      return 6;
    } else if (a.equals("seven")){
      return 7;
    } else if (a.equals("eight")){
      return 8;
    } else if (a.equals("nine")){
      return 9;
    } else if (a.equals("ten")){
      return 10;
    } else if (a.equals("jack")){
      return 11;
    } else if (a.equals("queen")){
      return 12;
    } else {
      return 13;
    }
  }
  
  public String playRound(){
    String card1 = p1.play();
    String card2 = p2.play();
    String card1m = card1.substring(0, card1.indexOf(" "));
    String card2m = card2.substring(0, card2.indexOf(" "));
    Scanner input = new Scanner(System.in);
    if(giveOrder(card1m) > giveOrder(card2m)){
      System.out.println(p1.getName() + " put " + card1 + " and " + p2.getName() + " put " + card2);
      System.out.println(p1.getName() + " wins this round!");
      player1Win(card1, card2);
    System.out.println("# of cards " + p1.getName() + " has: " + (p1.getDeck().size()));
    System.out.println("# of cards " + p2.getName() + " has: " + (p2.getDeck().size()));
      input.nextLine();
    if(winner().length() != 0){
        System.out.println(winner());
      return "success";
     }
      return "success";
    } else if(giveOrder(card1m) < giveOrder(card2m)){
        System.out.println(p1.getName() + " put " + card1 + " and " + p2.getName() + " put " + card2);
      System.out.println(p2.getName() + " wins this round!");
      player2Win(card1,card2);
    System.out.println("# of cards " + p1.getName() + " has: " + (p1.getDeck().size()));
    System.out.println("# of cards " + p2.getName() + " has: " + (p2.getDeck().size()));
      input.nextLine();
    if(winner().length() != 0){
        System.out.println(winner());
      return "success";
     }
      return "success";
    } else {
      System.out.println(p1.getName() + " put " + card1 + " and " + p2.getName() + " put " + card2);  
      System.out.println("it is War!");
        ArrayList<String> cardsPutUp = new ArrayList<String>();
        cardsPutUp.add(card1);
        cardsPutUp.add(card2);
        mod(card1, card2);
      if(p1.getDeck().size() < 4 || p2.getDeck().size() < 4){
          if(p1.getDeck().size() < 4){
        System.out.println(p2.getName() + " wins the game!");
            couldNotDoWar = p1.getName();
            return "finished";
         } else{
            System.out.println(p1.getName() + " wins the game!");
            couldNotDoWar = p2.getName();
            return "finished!";
         }
    }
        input.nextLine();
        war();
        if(leader.equals(p1.getName())){
          ArrayList<String> deck = p1.getDeck();
          deck.addAll(cardsPutUp);
          p1.modifyDeck(deck);
        } else {
            ArrayList<String> deck = p2.getDeck();
            deck.addAll(cardsPutUp);
            p2.modifyDeck(deck);
        }
    System.out.println("# of cards " + p1.getName() + " has: " + (p1.getDeck().size()));
    System.out.println("# of cards " + p2.getName() + " has: " + (p2.getDeck().size()));
      input.nextLine();
    if(winner().length() != 0){
        System.out.println(winner());
      return "success";
     } 
     return "success";   
    }
  }

  public void mod(String deck1, String deck2){
    ArrayList<String> deck = p1.getDeck();
    deck.remove(deck1);
    p1.modifyDeck(deck);
    ArrayList<String> deckp2 = p2.getDeck();
    deckp2.remove(deck2);
    p2.modifyDeck(deckp2);
  }  

  
  public void player1Win(String deck1, String deck2){
    ArrayList<String> deck = p1.getDeck();
    deck.add(deck1);
    deck.add(deck2);
    p1.modifyDeck(deck);
    leader = p1.getName();
    ArrayList<String> deckp2 = p2.getDeck();
    deckp2.remove(deck1);
    deckp2.remove(deck2);
    p2.modifyDeck(deckp2);
  }  

  public void player2Win(String deck1, String deck2){
    ArrayList<String> deck = p2.getDeck();
    deck.add(deck1);
    deck.add(deck2);
    p2.modifyDeck(deck);
    leader = p2.getName();
    ArrayList<String> deckp2 = p1.getDeck();
    deckp2.remove(deck1);
    deckp2.remove(deck1);
    p1.modifyDeck(deckp2);
  }  

  
  public String winner(){
    if(p1.getDeck().size() == 52){
      return (p1.getName() + " wins this game!");
    } else if(p2.getDeck().size() == 52){
        return (p2.getName() + " wins this game!");
    } 
  return "";
  }


  public String war(){
    if(p1.getDeck().size() < 4 || p2.getDeck().size() < 4){
          if(winner().length() != 0){
        System.out.println(winner());
     }
      if(p1.getDeck().size() >=4){
        return "p1 wins!";
      } else {
        return "p2 wins";
      }
    }
    ArrayList<String> temp = new ArrayList<String>();
    String card1;
    String card2;
    for(int i = 0; i<3; i++){
      card1 = p1.play();
      card2 = p2.play();
      temp.add(card1);
      temp.add(card2);
    }
    playRound();
        if(leader.equals(p1.getName())){
          ArrayList<String> deck = p1.getDeck();
          deck.addAll(temp);
          p1.modifyDeck(deck);
        } else {
            ArrayList<String> deck = p2.getDeck();
            deck.addAll(temp);
            p2.modifyDeck(deck);
        }
    return null;
  }
  public String getLoser(){
    return couldNotDoWar;
  } 
}
