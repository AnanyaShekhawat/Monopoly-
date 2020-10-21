import java.util.*;
/**
 * Write a description of class Utility here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Utility extends SquareType
{
    private int mortgage;
    private int price;
    private int bill;
    private int[] location; 
    private boolean isMortgage;
    
    public Utility(int[] l){
        location =l;
        this.setName("Water Bill");
        this.setTileType("Utility");
        this.setOwner(0);
        mortgage=50;
        price=150;
        bill=35;
        isMortgage=false;
    }
    
    public int[] loc(){
        return location;
    }
    
    
    
    public boolean getIsMortgage(){
        return isMortgage;
    }
    public void setIsMortgage(){
         isMortgage=true;
    }
    
    public int getPrice(){
        return price;
    }
    public int getMortgage(){
        return mortgage;
    }
    public int getBill(){
        if(this.getOwner() !=0){bill=bill*4;}
        return bill;
    }
    
    public String toString(){
        String a="";
        if(this.getOwner()==0){a="no one";}
        else if(this.getOwner()==1){a="Player 1";}
        else if(this.getOwner()==2){a="Player 2";}
        return "The tile's name is "+this.getName()+"and it is a Utility.\n The owner is"+a
        +"\nThe price of buying is $150, the mortgage is $50, and the \n  bill is"+
        "$35 each time your opponent lands on it";
    
    }
}
