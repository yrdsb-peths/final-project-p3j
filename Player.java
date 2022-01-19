import greenfoot.*;

/**
 * A class for the user's character that they will control in the overworld
 * 
 * @author Vincent Hsieh 
 * @version 1/14 0.55
 */
public class Player extends Actor{
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
        
        //still need to figure out a way to allow us to just hold the mouse
        if(Greenfoot.mousePressed(null) || Greenfoot.isKeyDown("space")){
            if(cur_CD <= 0){
                cur_CD = fire_CD;
                fireProjectile();
            }
        }
        cur_CD -= (double)fire_timer.millisElapsed()/1000;
        fire_timer.mark();
        
        if(health<=0){
            Score.score=0;
            Money.money=0;
            
            //FailScreen map = new FailScreen();
            //Greenfoot.setWorld(map);
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
        int initial_rot = (WeaponButton.weaponUpgrade-1)*5;
        for(int i=0; i<WeaponButton.weaponUpgrade; i++){
            Projectile projectile = new Projectile();
            world.addObject(projectile, getX(), getY());
            // to deal with Mouse Out of Bound problem that causes a null pointer exception
            if(Greenfoot.getMouseInfo()!=null){
                last_mouse_X = Greenfoot.getMouseInfo().getX();
                last_mouse_Y = Greenfoot.getMouseInfo().getY();
            }
            // also it seems that the turnToward is not very accurate, wonder if there is a way to make it accurate
            projectile.turnTowards(last_mouse_X, last_mouse_Y);
            projectile.setRotation(projectile.getRotation() - initial_rot + (10*i));
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
        
        // Booleans for storing collision with ImpassableBox
        boolean upper_hit=false,lower_hit=false,left_hit=false,right_hit=false;
        for(int junk = 0; junk<step_size; junk++){ 
            if(up)y-=1; // if moving up
            if(down)y+=1; // if moving down
            if(left)x-=1; // if moving left
            if(right)x+=1; // if moving right
            
            /* no ImpassableBox stuff yet
            // Collision
            List<ImpassableBox> object; // list storing colliding objects
            for(int i = -img_x/2; i < img_x/2; i++){
                if(!upper_hit){ // if colliding with object above player
                    // put the object player is colliding with in list
                    object = getObjectsAtOffset(x+i, y-img_y/2-1, ImpassableBox.class);
                    // if there is an object in the list
                    // set collision (upper) to true, block movement state "up"
                    if(object.size()!=0)upper_hit=true;up=false;
                }
                if(!lower_hit){ // if colliding with object below player
                    object = getObjectsAtOffset(x+i, y+img_y/2, ImpassableBox.class);
                    // if there is an object in the list
                    // set collision (lower) to true, block movement state "down"
                    if(object.size()!=0)lower_hit=true;down=false;
                }
            }
            for(int i = -img_y/2; i < img_y/2; i++){
                if(!left_hit){ // if colliding with object to the left
                    object = getObjectsAtOffset(x-img_x/2-1, y+i, ImpassableBox.class);
                    // if there is an object in the list
                    // set collision (left) to true, block movement state "left"
                    if(object.size()!=0)left_hit=true;left=false;
                }
                if(!right_hit){ // if colliding with object to the right
                    object = getObjectsAtOffset(x+img_x/2, y+i, ImpassableBox.class);
                    // if there is an object in the list
                    // set collision (right) to true, block movement state "right"
                    if(object.size()!=0)right_hit=true;right=false;
                }
            }
            */
           
            // if a collision state is true
            // sets y (or x) movement so that the player cannot move in the
            // same direction as the direction of collision w/ collision box(es). 
            if(upper_hit){y=Math.max(0,y);}
            if(lower_hit){y=Math.min(0,y);} 
            if(left_hit){x=Math.max(0,x);} 
            if(right_hit){x=Math.min(0,x);}
        }
        //sets sprite based on movement state
        if(x>0){setImage("trainer(right).png");}
        else if(x<0){setImage("trainer(left).png");}
        if(y>0){SetAnimation("down");}
        else if(y<0){SetAnimation("up");} 
        Move(x,y);
    }
    // Movement method
    public void Move(int x, int y){
        setLocation(getX()+x, getY()+y);
    }
    //clamp value between min and max
    public int clamp(int v,int min,int max){ //this is not even used my god
        return Math.max(min,Math.min(max,v));
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
