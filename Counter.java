import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; //Colour information

/**
 * Write a description of class Counter here.
 * 
 * @author Sam Collins
 * @version 0.1
 */
public class Counter extends Actor
{
    private int totalCount = 0;

    public Counter()
    {
        setImage(new GreenfootImage("Score: "+totalCount, 30, Color.WHITE, (new Color(1, 68, 121))));
    }
    
    public void bumpCount(int amount)
    {
        totalCount += amount;

        setImage(new GreenfootImage("Score: "+totalCount, 30, Color.WHITE, (new Color(1, 68, 121))));
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
