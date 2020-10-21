import java.util.*;
/**
 * Write a description of class Railroads here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Railroads extends SquareType
{
    private int mortgage;
    private int rent;
    private int price;
    private int[] location; 
    private boolean isMortgage;
    
    public Railroads(String name, int[] l){
        location =l;
        this.setName(name);
        this.setTileType("Railroad");
        this.setOwner(0);
        mortgage=75;
        price=200;
        rent=50;
        isMortgage=false;
    }
    
    public int[] loc(){
        return location;
    }
    
    
    
    
    public void setRent(int x){
        for(int i=1;i<=x;i++){rent=+50;}
    }
    public int getRent(){
        return rent;
    }
    public int getPrice(){
        return price;
    }
    public int getMortgage(){
        return mortgage;
    }
    
    public boolean getIsMortgage(){
        return isMortgage;
    }
    public void setIsMortgage(){
         isMortgage=true;
    }
    
    public String toString(){
        String a="";
        if(this.getOwner()==0){a="no one";}
        else if(this.getOwner()==1){a="Player 1";}
        else if(this.getOwner()==2){a="Player 2";}
        return "The tile's name is "+this.getName()+"and it is a Railroad.\n The owner is"+a
        +"\nThe price of buying is $200, the mortgage is $75, and the \n  rent is"+
        "$50 for one railroad. If you own more railroads,\n for each one is a another"+
        "$50 on rent";
    
    }
    

   
}
