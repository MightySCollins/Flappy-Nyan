import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tail comes out of the back fo the cat
 * 
 * @author Sam Collins
 * @version 0.2
 */
public class Tail extends Actor
{
    public void act() 
    {
        move(-4);    //Moves tail back at constant speed
        
        if (getX() <= 0)    //When tail is of the screen
        {
            getWorld().removeObject(this);    //Removes tail instances
        }
    }    
}
