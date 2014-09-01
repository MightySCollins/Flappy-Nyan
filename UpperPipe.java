import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Upper pipe is the top pipe the cat must avoid and will reset the cat if it is hit, the code is the same for lower pipe
 * 
 * @author Sam Collins 
 * @version 0.2
 */
public class UpperPipe extends Actor
{   
    public void act() 
    {
        move(-9);    //Move towards cat at constant speed

        if (getX() < -10)    //Removes when out of site
        {
            getWorld().removeObject(this);

        }
        else if (getX() == 235)    //Works out if the pipe passes the cat
        {
            Background world = (Background) getWorld();
            world.theCounter.bumpCount(1);    //Adds a point (It actually adds 2 because both pipes run the same code)
            Greenfoot.playSound("pong.mp3");
        }
    }    
}