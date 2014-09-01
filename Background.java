import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates the world and positions objects
 * 
 * @author Sam Collins and Shane Simpkin
 * @version 0.1
 */
public class Background extends World
{
    Counter theCounter;
    
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Cat cat = new Cat();
        addObject(cat, 236, 322);

        theCounter = new Counter();
        addObject(theCounter, 73, 29);
    }
}
