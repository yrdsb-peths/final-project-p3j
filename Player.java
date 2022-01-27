import greenfoot.*;

/**
 * A class for the user's character that they will control in the overworld
 * 
 * @author Vincent Hsieh 
 * @version 1/14 0.6
 */
public class Player extends SmoothMover{
    HealthBar healthbar;
    World world;
    
    private SimpleTimer fire_timer = new SimpleTimer();
    private double fire_CD = 0.1;
    private double cur_CD = 0;
    private double health = 20;
    public Player(){
        setImage("trainer(initial).png"); // The initial sprite of the character
    }
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        healthbar = new HealthBar(this);
        world = w;
        world.addObject(healthbar, 0, 0);
    }
    public void act(){
        MovementControl(); // Allows movement/controls movement
        
        //is spacebar is helddown, we set the cooldown and dire the projectile
        if(Greenfoot.isKeyDown("space")){
            if(cur_CD <= 0){
                cur_CD = fire_CD;
                fireProjectile();
            }
        }
        cur_CD -= (double)fire_timer.millisElapsed()/1000;
        fire_timer.mark();
        
        if(health<=0){
            remove();
        }
    }
    public void remove(){
        world.removeObject(healthbar);
        world.removeObject(this);
    }
    public void hurt(int dmg){
        health -= dmg;
        healthbar.setHealth((double)health/20);
    }
    public void hurt(double dmg){
        health -= dmg;
        healthbar.setHealth((double)health/20);
    }
    int last_mouse_X = 0;
    int last_mouse_Y = 0;
    public void fireProjectile(){
        GreenfootSound pew = new GreenfootSound("projectileSound.wav");//create our pew sound
        pew.setVolume(55);//so we dont make ourself deaf
        pew.playLoop();//play pew sound repeatedly in a loop
        pew.play();//for only one loop (yes i abuse the system)
        
        int initial_rot = States.weaponUpgrade*5;
        for(int i=0; i<=States.weaponUpgrade; i++){
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
        int step_size=3;
        
        if(up)y-=step_size; // if moving up
        if(down)y+=step_size; // if moving down
        if(left)x-=step_size; // if moving left
        if(right)x+=step_size; // if moving right
            
        //sets sprite based on movement state
        if(x>0)     setImage("trainer(right).png");
        else if(x<0)setImage("trainer(left).png");
        if(y>0)     SetAnimation("down");
        else if(y<0)SetAnimation("up");
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
    private SimpleTimer timer = new SimpleTimer();
    int dt;
    int time=0;
    public void SetAnimation(String direction){
        String cur_frame_name="trainer("+direction+")";
        dt=timer.millisElapsed();
        time+=dt;
        int[]temp=Animation_Table.get(direction);
        if(time > 500){
            time-=500;
            temp[1]+=1;
            if(temp[1]==temp[0]){
                temp[1]=0;
            }
        }
        cur_frame_name+=temp[1]+".png";
        setImage(cur_frame_name);
        timer.mark();
    }
}
