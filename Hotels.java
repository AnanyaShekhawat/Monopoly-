
/**
 * Write a description of class Hotels here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hotels extends Houses
{
    private int numHotel;

    public Hotels()
    {
        super();
        numHotel=0;
    }
    
    public void setNum(int number)
    {
        numHotel++;
    }
    public int getHotel()
    {
        return numHotel;
    }
    
    
}
