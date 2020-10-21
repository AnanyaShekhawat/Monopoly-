
/**
 * Write a description of class GoToJail here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GoToJail extends SquareType
{
    private int[] location;
    public GoToJail(int[] l){
        location =l;
        this.setName("Go To Jail");
        this.setTileType("Go To Jail");
        this.setOwner(0);
    }
    public int[] loc(){
        return location;
    }

    public void moveJail(int[] location)
    {
        location[0]=0; location[1]=7;
    }
}
