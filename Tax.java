import java.util.*;
/**
 * Write a description of class Tax here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tax extends SquareType
{
    private int price;
    private int[] location;
    /**
     * Constructor for objects of class Tax
     */
    public Tax(int[] l){
        location =l;
        this.setName("Luxury Tax");
        this.setTileType("Tax");
        this.setOwner(0);
        price=75;
    }
    public int[] loc(){
        return location;
    }

}
