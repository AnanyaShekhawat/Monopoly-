
/**
 * Write a description of class Houses here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Houses 
{
    private int num;

    public Houses()
    {
       num=0;
    }

    public void setNum(int number)
    {
        if(number<=3){num=number;}
    }
    public int getNum()
    {
        return num;
    }
}
