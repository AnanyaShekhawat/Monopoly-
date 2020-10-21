import java.util.*;
/**
 * Write a description of class Properties here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Properties extends SquareType
{
    // instance variables - replace the example below with your own
    private int mortgage;
    private int rent;
    private int price;
    private Houses house; 
    private Hotels hotel; 
    private int block;
    private boolean isMortgage;
    private boolean isUpgraded;
    private boolean allBlockBought;
    private int[] location;

    /**
     * Constructor for objects of class Properties
     */
    public Properties(int r,int m, int p, int b, String n, int[] l){
        location =l;
        this.setName(n);
        this.setTileType("Properties");
        this.setOwner(0);
        mortgage=m;
        price=p;
        rent=r;
        house=new Houses();
        hotel =new Hotels();
        block=b;
        isMortgage=false;
        isUpgraded=false;
    }
    public int[] getLoc(){
        return location;
    }
    
    
    public int getHouses(){
        return house.getNum();
    }
    public void upgradeProp(){
        if(house.getNum()+1<=3){
            house.setNum(house.getNum()+1);
            isUpgraded=true;
        }
        else if(house.getNum()==3){
            hotel.setNum(house.getNum()+1);
            isUpgraded=true;
        }
        else{System.out.println("You have reached the max level of upgrades");
        }
        increaseRent(house.getNum());
    }
    public int getHotel(){
        return hotel.getNum();
    }

    
    
    public int getGroup(){
        return block;
    }
    public boolean getIsMortgage(){
        return isMortgage;
    }
    public void setIsMortgage(){
         isMortgage=true;
    }
    
    public boolean getallBlockBought(){
        return allBlockBought;
    }
    public boolean isUpgraded(){
        return isUpgraded;
    }
    public void setallBlockBought(){
         allBlockBought=true;
    }
    public int getRent(){ 
        return rent;
    }
    public void increaseRent(int x){
        if(house.getNum()==4){rent=rent+100;}
        else{rent=rent+50;}
    }
    public int getMortgage(){
        return mortgage;
    }
    public int getPrice(){
        return price;
    }
    
    public String toString(){
        String a="";
        if(this.getOwner()==0){a="no one";}
        else if(this.getOwner()==1){a="Player 1";}
        else if(this.getOwner()==2){a="Player 2";}
        return "The tile's name is "+this.getName()+" and it is a property. The owner is\n"+a
        +". The price of buying is $"+price+", the mortgage is $"+mortgage+", and the \nrent is $"+
        rent+" each time your opponent lands on it. The tile belongs\n to Block "+block+
        ". It is also has "+house.getNum()+" houses and "+hotel.getNum()+" hotels.\nAfter buying"+
        " all property on a block, you can upgrade your \nproperty,"+
        " by buying $150 houses to increase the rent by $50. When you \nincrease"+
        " buy 4 houses, the property will automatically have a hotel \nwhich will increase"+
        " the rent by $100";
    }
}
