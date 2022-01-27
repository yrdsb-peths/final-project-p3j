import greenfoot.*;

/**
 * A class for the user's character that they will control in the overworld
 * 
 * @author Vincent Hsieh 
 * @version 1/14 0.6
 */
public class Player extends SmoothMover{
    //player health
    private double health = 20;
    //fire interval
    private double fire_CD = 0.1;
    
    //Player healthbar
    HealthBar healthbar;
    //world we are at
    World world;
    
    //a timer used for shooting
    private SimpleTimer fire_timer = new SimpleTimer();
    //current firing cooldown
    private double cur_CD = 0;
    public Player(){
        setImage("trainer(initial).png"); // The initial sprite of the player
    }
    public void addedToWorld(World w){
        world = w;//a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);//create a healthbar that follows me
        world.addObject(healthbar,0,0);//add this healthbar into the world, it will fix its location itself
    }
    public void act(){
        MovementControl(); //controls movement
        
        //if spacebar is helddown, we set the cooldown and fire the projectile
        if(Greenfoot.isKeyDown("space")){
            //cooldown is ready
            if(cur_CD <= 0){
                //set the current firing cooldown
                cur_CD = fire_CD;
                //fires the projectile
                fireProjectile();
            }
        }
        //ticking down the current firing cooldown
        cur_CD -= (double)fire_timer.millisElapsed()/1000;
        //mark the fire timer
        fire_timer.mark();
        
        //player dead
        if(health<=0){
            remove();
        }
    }
    /**
     * Remove this entity along with its associated healthbar
     */
    public void remove(){
        world.removeObject(healthbar);
        world.removeObject(this);
    }
    /**
     * Hurt the player
     */
    public void hurt(int dmg){
        health -= dmg;
        healthbar.setHealth((double)health/20);
    }
    /**
     * Hurt the player
     */
    public void hurt(double dmg){
        health -= dmg;
        healthbar.setHealth((double)health/20);
    }
    //last mouse location
    private int last_mouse_X = 0;
    private int last_mouse_Y = 0;
    public void fireProjectile(){
        GreenfootSound pew = new GreenfootSound("projectileSound.wav");//load our pew sound
        pew.setVolume(55);//so we dont make ourself deaf
        pew.play();//play the sound
        
        //initial rotation for the shooting
        int initial_rot = States.weaponUpgrade*5;
        for(int i=0; i<=States.weaponUpgrade; i++){
            //make a new projectile, and add them to player location
            Projectile projectile = new Projectile();
            world.addObject(projectile, getX(), getY());
            //to deal with Mouse Out of Bound problem that causes a null pointer exception
            if(Greenfoot.getMouseInfo()!=null){
                last_mouse_X = Greenfoot.getMouseInfo().getX();
                last_mouse_Y = Greenfoot.getMouseInfo().getY();
            }
            //turn projectile Toward the last valid mouse position
            projectile.turnTowards(last_mouse_X, last_mouse_Y);
            //apply addtional rotation
            projectile.setRotation(projectile.getRotation() - initial_rot + (10*i));
            //move it a bit
            projectile.move(20);
        }
    }
    
    // Main method to allow movement
    public void MovementControl(){
        // booleans that store current movement state
        boolean up=false,down=false,left=false,right=false;
        // if statements to determine current movement state
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w"))up=true;
        if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s"))down=true;
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))left=true;
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))right=true;
        GreenfootImage img=new GreenfootImage("trainer(initial).png");
        // stores dimensions of image (Player)
        int img_x=img.getWidth(),img_y=img.getHeight();
        int x=0,y=0; // movement variables
        int step_size=3; // movement size
        
        if(up)y-=step_size; // if moving up
        if(down)y+=step_size; // if moving down
        if(left)x-=step_size; // if moving left
        if(right)x+=step_size; // if moving right
            
        //sets sprite based on movement state
        if(x>0)     setImage("trainer(right).png");
        else if(x<0)setImage("trainer(left).png");
        if(y>0)     SetAnimation("down");
        else if(y<0)SetAnimation("up");
        
        //moves the player
        Move(x,y);
    }
    // Movement method
    public void Move(int x, int y){
        setLocation(getX()+x, getY()+y);
    }
    private static class Animation_Table{
        //               tot_frame  cur_frame
        static int[][]table={{2,       0}, //up
                             {2,       0}, //down
                             {2,       0}, //left
                             {2,       0}};//right
        public static int[] get(String dir){ // returns specific values of the animation table
            if(dir=="up")return table[0];
            else if(dir=="down")return table[1];
            else if(dir=="left")return table[2];
            else if(dir=="right")return table[3];
            return null;
        }
    }
    //timer used for this animation
    private SimpleTimer timer = new SimpleTimer();
    int dt;
    int time=0;
    public void SetAnimation(String direction){
        //base of the sprite name for this current frame
        String cur_frame_name="trainer("+direction+")";
        
        dt=timer.millisElapsed();
        //increase the time
        time += dt;
        
        //get the table of animation instructions
        int[]temp=Animation_Table.get(direction);
        
        //if the time is bigger then 250 mill second (0.25 second)
        if(time > 250){
            time -= 250;
            temp[1] += 1;
            if(temp[1] == temp[0]){
                //loop back to 0
                temp[1] = 0;
            }
        }
        //figure out the end of the sprite name for current frame
        cur_frame_name+=temp[1] + ".png";
        setImage(cur_frame_name);
        timer.mark();
    }
}
