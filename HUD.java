import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor{
    private Color bg = new Color(0,0,0,50);
    
    //the world we are at
    private World world;
    
    //GreenfootImage for all the stuff we want to display
    private GreenfootImage weaponButton;
    private GreenfootImage money;
    private GreenfootImage score;
    
    //GreenfootImage for HUD
    private GreenfootImage img;
    public void addedToWorld(World w){
        //a World is pass down from this function addedToWorld
        world = w;
                
        //a empty HUD image
        img = new GreenfootImage(world.getWidth(),world.getHeight());
    }
    public void act(){
        //We need this mouse down function for beautiful button
        mouseDownAct();
        
        //build money visuals 
        money = new GreenfootImage("$" + States.money, 40, Color.WHITE, bg, Color.BLACK);
        money.drawRect(0,0,money.getWidth()-1,money.getHeight()-1);
        
        //build score visuals
        score = new GreenfootImage("Score: " + States.score, 40, Color.WHITE, bg, Color.BLACK);
        score.drawRect(0,0,score.getWidth()-1,score.getHeight()-1);
        
        //weaponButton logic
        //Allows upgrade when the level is below 4 (so they can gets to 4)
        if(States.weaponUpgrade < 4){
            if(States.money >= States.weaponUpgradePrice[States.weaponUpgrade]){
                //make the button look clickable
                weaponButton = new GreenfootImage("Weapon\nUpgrade", 25, Color.BLACK, new Color(180,180,180));
                
                //if mouse is in the "button" area
                if(mouseInRect(750, 30, weaponButton.getWidth(), weaponButton.getHeight())){
                    //mouse is hovering over the "button", we highlight it
                    weaponButton = new GreenfootImage("Weapon\nUpgrade", 25, Color.BLACK, new Color(200,200,200));
                    
                    //if mouse is helding down the "button", we darken it
                    if(mouseDown){
                        weaponButton = new GreenfootImage("Weapon\nUpgrade", 25, Color.BLACK, new Color(120,120,120));
                    }
                    //if it is clicked, excute the upgrade
                    if(Greenfoot.mouseClicked(null)){
                        States.TriggerWeaponUpgrade();
                    }
                }
            }else{
                //make the button look not clickable
                weaponButton = new GreenfootImage("Weapon\nUpgrade", 25, new Color(0,0,0,100), new Color(0,0,0,50));
            }
        }else{
            //make the button look not clickable
            weaponButton = new GreenfootImage("Weapon\nUpgrade", 25, new Color(0,0,0,100), new Color(0,0,0,50));
        }
        //update the HUD
        update();
    }
    public void update(){
        //make sure HUD is empty
        img.clear();
                
        //draw a semi transparent box on top of HUD
        img.setColor(new Color(0,0,0,50));
        img.fillRect(0,0,img.getWidth(),60);
        
        //draw bordered box on top of HUD
        img.setColor(new Color(0,0,0));
        img.drawRect(0,0,img.getWidth()-1,60);
        
        //adds Score Counter in top left of HUD
        img.drawImage(score, 100 - score.getWidth()/2, 30 - score.getHeight()/2);
        //adds Money Display in top right of HUD
        img.drawImage(money, 850 - money.getWidth()/2, 30 - money.getHeight()/2);
        //adds Weapon upgrade Button in top right of HUD
        img.drawImage(weaponButton, 750 - weaponButton.getWidth()/2, 30 - weaponButton.getHeight()/2);
        
        setImage(img);
        //just making sure we are at the right place
        setLocation(world.getWidth()/2, world.getHeight()/2);
    }
    private boolean inRange(int x, int min, int max){
        //if x cord is bigger then min, and smaller then max
        if(min <= x & x <= max){
            return true;
        }
        return false;
    }
    private boolean mouseInRect(int x, int y, int w, int h){
        //get mouse info
        MouseInfo info = Greenfoot.getMouseInfo();
        if(info != null){
            //if mouse x cord is in range, and y cord is in range
            if(inRange(info.getX(), x - w/2, x + w/2) & inRange(info.getY(), y - h/2, y + h/2)){
                return true;
            }
        }
        return false;
    }
    //boolean to keep track of if mouse is held down
    private boolean mouseDown = false;
    private void mouseDownAct(){
        if(Greenfoot.mousePressed(null)){
            //mouse have just changed to down
            mouseDown = true;
        }else if(Greenfoot.mouseClicked(null)){
            //mouse have lifted up
            mouseDown = false;
        }
    }
}
