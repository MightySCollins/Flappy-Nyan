import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UpperPipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpperPipe extends Actor
{   
    public void act() 
    {
        move(-9);

        if (getX() < -10)
        {
            getWorld().removeObject(this);

        }
        else if (getX() == 235)
        {
            Background world = (Background) getWorld();
            world.theCounter.bumpCount(1);
        }
    }    
}