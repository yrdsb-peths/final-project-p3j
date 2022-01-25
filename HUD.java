import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor{
    private Color bg = new Color(0,0,0,20);
    
    //the world we are at
    private World world;
    
    //Labels for all the stuff we want to display
    private Label weaponButton;
    private Label money;
    private Label score;
    public HUD(){
        //make HUD a dummy pic
        setImage(new GreenfootImage(1,1));
        
        //initialize weaponButton visuals
        weaponButton = new Label("Weapon\nUpgrade", 25);
        weaponButton.setFillColor(Color.BLACK);
        weaponButton.setBackgroundColor(new Color(180,180,180));
        weaponButton.setLineColor(bg);
        
        //initialize money visuals
        money = new Label("$" + States.money, 40);
        money.setFillColor(Color.BLACK);
        money.setBackgroundColor(bg);
        money.setLineColor(bg);
        
        //initialize score visuals
        score = new Label("Score: " + States.score, 40);
        score.setFillColor(Color.BLACK);
        score.setBackgroundColor(bg);
        score.setLineColor(bg);
    }
    public void addedToWorld(World w){
        world = w;//a World is pass down from this function addedToWorld
        
        //adds Score Counter in top left of map
        world.addObject(score, 100, 30);
        //adds Money Display in top right of map
        world.addObject(money, 800, 30);
        //adds Weapon upgrade Button in top right of map
        world.addObject(weaponButton, 800, 100);
    }
    public void act(){
        //money Act
        money.setValue("$" + States.money);
        
        //score Act
        score.setValue("Score: " + States.score);
        
        //weaponButton Act
        //Allows upgrade when the level is below 4 (so they can gets to 4)
        if(States.weaponUpgrade < 4){
            if(States.money >= 150){
                //make the button look clickable
                weaponButton.setFillColor(Color.GREEN);
                weaponButton.setBackgroundColor(new Color(180,180,180));
                //if the user clicked on the button, we excute the upgrade
                if(Greenfoot.mousePressed(weaponButton)){
                    States.money -= 150;
                    States.weaponUpgrade++;
                    Greenfoot.playSound("FX299.mp3");
                }
            }else{
                //make the button look not clickable
                weaponButton.setFillColor(new Color(0,0,0,100));
                weaponButton.setBackgroundColor(new Color(0,0,0,50));
            }
        }else{
            //make the button look not clickable
            weaponButton.setFillColor(new Color(0,0,0,100));
            weaponButton.setBackgroundColor(new Color(0,0,0,50));
        }
    }
}
