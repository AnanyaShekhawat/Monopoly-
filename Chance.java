import java.util.*;
/**
 * Write a description of class Chance here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chance extends SquareType
{
    private String[] lucks;
    private int[] location;
    public Chance(int[] l){
        location =l;
        this.setName("Chance");
        this.setTileType("Chance");
        this.setOwner(0);
        lucks= new String[]{"Get out of Jail Card", "Go to Jail","Collect $75","Pay $100"
            ,"Pay $50 to the other player", "Collect $20"
            ,"Pass Go"};
    }
    public int[] loc(){
        return location;
    }
    
    public String getChance(){
        String card = lucks[(int)(Math.random()*6)];
        return card;
    }
    
    public void keepChance(ArrayList<String> cards, String card){
          cards.add(card);
      } 
      
    

    
}
