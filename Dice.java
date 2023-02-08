import java.util.*;
public class Dice{
    private int minValue;
    private int maxValue;
    private int currentValue;


    public int roll(){
        Random ran=new Random();
        return ran.nextInt(0, 6);
    }
}
