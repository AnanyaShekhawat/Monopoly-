import java.util.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private int player;
    private int money;
    private ArrayList<SquareType> property;
    private ArrayList<String> cards;
    private boolean isInJail; 
    private int[] location;
    
    public Player(int p)
    {
        location=new int[2];location[0]=0;location[1]=0;
        player=p;
        money=1000;
        property= new ArrayList<SquareType>();
        cards= new ArrayList<String>();
        isInJail=false;
    }
    
    public void pay(int lose){money=money-lose;}
    public void getPaid(int gain){money=money+gain;}
    public int getMoney(){return money;}
    public void setMoney(int a){money=a;}
    
    public int player(){return player;}
    
    public void addProperty(SquareType a){property.add(a);}
    public ArrayList<SquareType> getProperty(){return property;}
    
    public void addChance(String a){cards.add(a);}
    public ArrayList<String> getChance(){return cards;}
    public String getChance(int z){return cards.get(z);}
    
    public int[] getLoc(){return location;}
    public void setLoc(int[] a){location=a;}
    
    public boolean getInJail(){return isInJail;}
    public void setInJail(boolean t){isInJail=t;}
    
    
    public String toString(){
        String a="";
        for(int i=0;i<property.size();i++){a=a+property.get(i).getName()+", ";}
        return "You have $"+money+" and your properties are: "+a+". And you have these chances cards: "+cards;
    
    }
}
