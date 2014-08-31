import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The cat moves
 * 
 * @author Sam Collins
 * @version 0.4
 */
public class Cat extends Mover
{
    GreenfootSound background = new GreenfootSound ("Nyan.mp3");    //Creates sound as GreenfootSound object
    public Cat()
    {
        if (background.isPlaying() == false)    //Checks to see if background music is playing
        {
            background.setVolume(40);   //Lowers volume of music
            background.playLoop();      //Plays in a loop
        }
    }
    int counter = 0;
    int counterPipe = 0;
    int movement = 0;
    boolean start = false;
    int height;
    GreenfootSound wing = new GreenfootSound ("wing.wav");

    public void act() 
    {               
        if (Greenfoot.isKeyDown("space")) 
        {
            start = true;        
        }

        if (start == true)
        {
            play();
        } else 
        {
            getWorld().addObject(new Tail(), getX()-43, getY()-movement);
            counter += 1;

            if (counter <= 8)      
                movement = 0;

            if (counter >= 9)        
                movement = 5;

            if (counter == 16)        
                counter = 1;  
        }

        if (getY() >= getWorld().getHeight() - 2 || getY() == 2 )   //Resets the world (so the cat moves to the start) if the cat reaches the top or bottom
        {
            Greenfoot.setWorld(new Background());
            background.pause();
        }
    }

    private int jumpStrength = 2;
    private void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
    }

    public void play()
    {
        if (Greenfoot.isKeyDown("space"))        
        {
            jump();
            if (wing.isPlaying() == false)
            {
                wing.play();
            }
        }
        else fall();    

        Actor pipe = getOneIntersectingObject(UpperPipe.class);
        if (pipe !=null)
        {
            Greenfoot.setWorld(new Background());
            background.pause();
            Greenfoot.playSound("die.wav");
        }

        getWorld().addObject(new Tail(), getX()-43, getY()-movement);
        counter += 1;      

        counterPipe += 1;        
        if (counterPipe == 70)
        {
            height = Greenfoot.getRandomNumber(100);

            getWorld().addObject(new UpperPipe(), getWorld().getWidth(), height);
            counterPipe = 0;

            height += 650;            
            getWorld().addObject(new LowerPipe(), getWorld().getWidth(), height);
        }
    }
}
