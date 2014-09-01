import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The cat moves up when space is pressed and down when not. This class is also used to spawn in the pipes and detect if there is a collision as well as manage all sounds.
 * 
 * @author Sam Collins
 * @version 0.5
 */
public class Cat extends Mover
{
    GreenfootSound background = new GreenfootSound ("_Nyan.mp3");    //Creates sound as GreenfootSound object
    public Cat()
    {
        if (background.isPlaying() == false)    //Checks to see if background music is playing
        {
            background.setVolume(40);   //Lowers volume of music
            background.playLoop();      //Plays in a loop
        }
    }
    int counterTail = 0;    //Counter for tail
    int counterPipe = 0;    //Counter for distance between pipes
    int movement = 0;
    boolean start = false;    //Variable for starting movement
    int height;
    GreenfootSound wing = new GreenfootSound ("wing2.mp3");

    public void act() 
    {               
        if (Greenfoot.isKeyDown("space"))    //Tests if space key is down
        {
            start = true;    //When start is true the next if will start play
        }

        if (start == true)
        {
            play();    //This runs the code for making the cat move up and down as well as spawning pipes
        } else 
        {
            getWorld().addObject(new Tail(), getX()-43, getY()-movement);    //Spawns tail behind the cat
            counterTail += 1;

            if (counterTail <= 8)
                movement = 0;

            if (counterTail >= 9)    //This makes tail spawn above 5 and then below making it seem likes it moving up and down
                movement = 5;

            if (counterTail == 16)
                counterTail = 1;
        }

        if (getY() < 0)    //Resets the world (so the cat moves to the start) if the cat reaches the top or bottom
        {
            setLocation(getX(), 0);         
        }
        if (getY() >= getWorld().getHeight() - 2)
        {
            die();
        }
    }

    private int jumpStrength = 2;
    private void jump()
    {
        setVSpeed(-jumpStrength);    //Makes cat move up by the jump strength above
        fall();    //Class from mover which makes the cat move down by adding gravity
    }

    public void play()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            jump();
            if (wing.isPlaying() == false)    //Makes sure the sound is not already playing
            {
                wing.play();    //Plays wing sound
            }
        }
        else fall();    //Class from mover which makes the cat move down by adding gravity

        Actor pipe = getOneIntersectingObject(UpperPipe.class);    //Resets world when cat touches the pipe
        if (pipe != null)
        {
            die();
        }

        getWorld().addObject(new Tail(), getX()-43, getY()-movement);
        counterTail += 1;      

        counterPipe += 1;    //Counter for distance between pipes
        if (counterPipe == 70)    //After 70 acts a new pipe will appear
        {
            height = Greenfoot.getRandomNumber(100);    //Sets pipe location to random number
            getWorld().addObject(new UpperPipe(), getWorld().getWidth(), height);
            
            height += 650;    //Adds hight so the pipe is below the upper one
            getWorld().addObject(new LowerPipe(), getWorld().getWidth(), height);
            
            counterPipe = 0;    //Resets counter so it will count back to 70 for next pipe
        }
    }

    public void die()
    {
        Greenfoot.setWorld(new Background());    //Resets world
        background.pause();    //Pauses background music
        Greenfoot.playSound("die.wav");    //Plays dieing sound
    }
}  