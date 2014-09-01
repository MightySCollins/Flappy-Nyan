import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; //Colour information

/**
 * Counter displays score in top right
 * 
 * @author Sam Collins and Shane Simpkin
 * @version 0.1
 */
public class Counter extends Actor
{
    private int totalCount = 0;    //Variable for total score

    public Counter()     
    {
        setImage(new GreenfootImage("Points: "+totalCount, 30, Color.RED, (new Color(1, 76, 91, 0))));    //Sets up score when world starts
    }

    public void bumpCount(int amount)
    {
        totalCount += amount;    //Adds amount parameter to the current score

        setImage(new GreenfootImage("Points: "+totalCount, 30, Color.RED, (new Color(1, 76, 91, 0))));    //Variable used for info
        //if (totalCount > 4){setImage(new GreenfootImage("Points: "+totalCount, 30, Color.ORANGE, (new Color(1, 76, 91, 0))));}  //Template code ^_^
        if (totalCount > 19){setImage(new GreenfootImage("Points: "+totalCount, 30, Color.GREEN, (new Color(1, 76, 91, 0))));}  else
        if (totalCount > 9){setImage(new GreenfootImage("Points: "+totalCount, 30, Color.ORANGE, (new Color(1, 76, 91, 0))));} 

    }

    public void act() 
    {

    }    
}
