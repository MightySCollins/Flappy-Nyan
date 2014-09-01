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
        move(-10);    //Moves tail back at constant speed
                     //Originally -4 but when playing at -10 it makes the cat seem faster therefore 
                     //the player will feel like the game is faster....
        
        if (getX() <= 0)    //When tail is of the screen
        {
            getWorld().removeObject(this);    //Removes tail instances
        }
    }    
}
