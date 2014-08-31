import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; //Colour information

/**
 * Counter displays score in top right
 * 
 * @author Sam Collins
 * @version 0.1
 */
public class Counter extends Actor
{
    private int totalCount = 0;    //Variable for total score

    public Counter()     
    {
        setImage(new GreenfootImage("Score: "+totalCount, 30, Color.WHITE, (new Color(1, 68, 121))));    //Sets up score when world starts
    }
    
    public void bumpCount(int amount)
    {
        totalCount += amount;    //Adds amount parameter to the current score

        setImage(new GreenfootImage("Score: "+totalCount, 30, Color.WHITE, (new Color(1, 68, 121))));    //Regenerates score for new score defined in total count
    }

    public void act() 
    {
        
    }    
}
