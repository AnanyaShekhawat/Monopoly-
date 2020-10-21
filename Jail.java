import java.util.*;
/**
 * Write a description of class JailBlock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jail extends SquareType
{
    private boolean out;
    private int[] location; 

    /**
     * Constructor for objects of class JailBlock
     */
    public Jail(int[] l){
        location =l;
        this.setName("Jail");
        this.setTileType("Jail");
        this.setOwner(0);
        out=false;
        
    }
    public int[] loc(){
        return location;
    }

    public boolean getOut(int[] rolls, int turns, ArrayList<String> cards)
    {
        return out;
    }
    
}
