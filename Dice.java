import java.util.*;
/**
 * Write a description of class Dice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dice implements Piece
{
    private int owner;

    /**
     * Constructor for objects of class Dice
     */
    public Dice()
    {owner=1;}

    public String getName(){return "dice";}
    public void setOwner(int human){
        owner=human;
    }
    public int[] roll(){
        int[] re= new int[2];
        while(re[0]<=0 || re[0]>7)
        re[0] =(int)(Math.random()*6);
        while(re[1]<=0 || re[1]>7)
        re[1] =(int)(Math.random()*6);
        return re;
    }
}
