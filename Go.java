import java.util.*;
/**
 * Write a description of class Go here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Go extends SquareType
{
    private int pay;
    private int[] location;
    /**
     * Constructor for objects of class Go
     */
    public Go(int[] l){
        location =l;
        this.setName("Go");
        this.setTileType("Go");
        this.setOwner(0);
        pay=200;
    }
    public int[] loc(){
        return location;
    }

}
