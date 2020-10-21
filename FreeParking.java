import java.util.*;
/**
 * Write a description of class FreeParking here. 
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FreeParking extends SquareType 
{
    private int amtPayed;
    private int[] location;
    /**
     * Constructor for objects of class FreeParking
     */
    public FreeParking(int[] l){
        location =l;
        this.setName("Free Parking");
        this.setTileType("Free Parking");
        this.setOwner(0);
        amtPayed = 75;
    }
    public int[] loc(){
        return location;
    }
    
  }
