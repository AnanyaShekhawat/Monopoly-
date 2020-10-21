
/**
 * Write a description of class Mortgage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mortgage implements Piece
{
    private int owner;
    
    public Mortgage()
    {
        owner=0;
    }
    public String getName(){return "mortgage";}
    public void setOwner(int human){
        owner=human; 
    }
    public void mortgageProperty(){}
    
}
