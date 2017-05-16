import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;

/**
 * Class Temporary - write a description of the class here
 *
 * @author (your name)
 * @version (a version number)
 */
public class FinalProject extends JApplet implements MouseListener, KeyListener
{
    Image logo;
    MediaTracker tr;
    
    Board Player1 = new Board("");
    Board Player2 = new Board("");
    char key;
    
    boolean fireimage = false;
    int xco;
    int yco;
    int charfix = 0;
    
    String userinput = "";
    String completeinput = "";
    
    int screen = 0;
    int hitscreen = 0;

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * has been loaded into the system. It is always called before the first
     * time that the start method is called.
     */
    public void init()
    {
        // this is a workaround for a security conflict with some browsers
        // including some versions of Netscape & Internet Explorer which do
        // not allow access to the AWT system event queue which JApplets do
        // on startup to check access. May not be necessary with your browser.
        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);

        // provide any initialisation necessary for your JApplet
        addKeyListener(this);
        addMouseListener(this);
        
        

       

        
        setFocusable(true);
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * should start its execution. It is called after the init method and
     * each time the JApplet is revisited in a Web page.
     */
    public void start()
    {
        // provide any code requred to run each time
        // web page is visited
    }

    /**
     * Called by the browser or applet viewer to inform this JApplet that
     * it should stop its execution. It is called when the Web page that
     * contains this JApplet has been replaced by another page, and also
     * just before the JApplet is to be destroyed.
     */
    public void stop()
    {
        // provide any code that needs to be run when page
        // is replaced by another page or before JApplet is destroyed
    }

    /**
     * Paint method for applet.
     *
     * @param  g   the Graphics object for this applet
     */
    public void paint(Graphics g)
    {
      

        if (key == 0)
        {
            g.setColor(Color.blue);
            g.fillRect(0, 0, 1000, 600);
            g.setColor(Color.gray);
            g.fillRect(325,400,360,75);

            Font buttonfont = new Font("asdfasdf", 1500, 35);





            g.setFont(buttonfont);
            g.setColor(Color.white);
            g.drawString("Press Any Key to Start", 330, 445);
            
            
            
            tr = new MediaTracker(this);
            logo = getImage(getCodeBase(), "battleshiplogo.jpg");
            tr.addImage(logo, 0);
            g.drawImage(logo, 335,111, this);
            
            if (fireimage)
            {
               g.setColor(Color.yellow);
               g.fillOval(xco - 10,yco - 10,25,25);
               
               
               
               fireimage = false;
            }
            
            
            
           
                

        }





       else
       {
            
            g.setColor(Color.blue);
            g.fillRect(0, 0, 1000, 600);
            g.setColor(Color.cyan);

            g.fillRect(50,50,400,400);
            g.fillRect(550,50,400,400);

            Font armyfont = new Font("army", 1500, 20);
            g.setFont(armyfont);
            g.setColor(Color.white);
            g.drawString("Battleship", 456, 20);
            String kstr = "";
            for (int k = 0; k < 10; k++)
            {
                kstr += k;
                g.drawString(kstr, 65 + (40 * k), 40);
                kstr = "";
            }
            
             for (int k = 0; k < 10; k++)
            {
                kstr += k;
                g.drawString(kstr, 30, 75 + (40 * k));
                kstr = "";
            }
            
            for (int k = 0; k < 10; k++)
            {
                kstr += k;
                g.drawString(kstr, 565 + (40 * k), 40);
                kstr = "";
            }
            
             for (int k = 0; k < 10; k++)
            {
                kstr += k;
                g.drawString(kstr, 960, 75 + (40 * k));
                kstr = "";
            }
            
            g.setColor(Color.black);

            for (int x = 90; x < 450; x += 40)
            {
                g.drawLine(x, 50, x, 450);
            }

            for (int y = 90; y < 450; y += 40)
            {
                g.drawLine(50, y, 450, y);
            }

            for (int x = 590; x < 950; x += 40)
            {
                g.drawLine(x, 50, x, 450);
            }

            for (int y = 90; y < 450; y += 40)
            {
                g.drawLine(550, y, 950, y);
            }


       
            //command box outline 
            g.setColor(Color.lightGray);
            g.fillRect(300,475,400,100);
            g.setColor(Color.black);
            g.fillRect(310,485,380,80);
            
             if (fireimage)
            {
               g.setColor(Color.yellow);
               g.fillOval(xco - 10,yco - 10,25,25);
               
               
               
               fireimage = false;
            }
            
            
            
            
            
            
            //Command Line
            g.setColor(Color.green);
            Font commandfont = new Font("",1500,10);
            g.setFont(commandfont);
            
            if (screen == 0)
            {

                g.drawString(">Welcome to Battleship!", 320, 495);
                g.drawString(">Player 1, what is your name?", 320, 505);
                g.drawString(">" + userinput, 320,515);
                
            }            
            else if (screen == 1)
            { 
               Player1.name = completeinput;
               g.drawString(">Welcome, " + Player1.name + "!", 320, 495);
               g.drawString(">Player 2, what is your name?", 320, 505);
               g.drawString(">" + userinput, 320, 515);
            }
            else if (screen == 2)
            {
               Player2.name = completeinput;
               g.drawString(">Welcome, " +Player2.name + "!", 320, 495);
               g.drawString(">" + Player1.name + ", please pick the x-coordinate for your Destroyer (Ship size: 2)", 320, 505);
               g.drawString(">" + userinput, 320, 515);
            }
            else if (screen == 3)
            {
              g.drawString(">" + Player1.name + ", please pick the y-coordinate for your Destroyer (Ship size: 2)", 320, 495);
              g.drawString(">" + userinput, 320, 505);
              Player1.destroyer.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 4)
            {

               g.drawString(">" + Player1.name + ", please pick the direction your Destroyer is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player1.destroyer.y = completeinput.charAt(0) - 48;
               
            }
            else if (screen == 5)
            {
               
               g.drawString(">" + Player1.name + ", please pick the x-coordinate your Cruiser (Ship size: 3)",320,495);
               g.drawString(">" + userinput, 320, 505);
               
               g.setColor(Color.LIGHT_GRAY);
               Player1.destroyer.direction = completeinput.charAt(0) - 48;
               
                   if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x- 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                    
                    
                    
            }
            else if (screen == 6)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player1.name + ", please pick the y-coordinate your Cruiser (Ship size: 3)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player1.cruiser.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 7)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
               g.setColor(Color.green);
              
               g.drawString(">" + Player1.name + ", please pick the direction your Cruiser is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player1.cruiser.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 8)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player1.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player1.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                       }
                       else if ( Player1.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 82, 41);
                       }
                       else if (Player1.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.destroyer.x -1 )),50 + (40 * (Player1.destroyer.y)), 82, 41);
                       }
                       
                          Player1.cruiser.direction = completeinput.charAt(0) - 48;
                      if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                g.setColor(Color.green);
                       
                g.drawString(">" + Player1.name + " please enter the x-coordinate of your Submarine (Ship size: 3)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
                
            }
            
            
              else if (screen == 9)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player1.name + ", please pick the y-coordinate your Submarine (Ship size: 3)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player1.submarine.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 10)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
               g.setColor(Color.green);
              
               g.drawString(">" + Player1.name + ", please pick the direction your Submarine is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player1.submarine.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 11)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player1.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player1.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                       }
                       else if ( Player1.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 82, 41);
                       }
                       else if (Player1.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.destroyer.x -1 )),50 + (40 * (Player1.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       Player1.submarine.direction = completeinput.charAt(0)-48;
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                g.setColor(Color.green);
                       
                g.drawString(">" + Player1.name + " please enter the x-coordinate of your Battleship (Ship size: 4)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
            }
            
            
              else if (screen == 12)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player1.name + ", please pick the y-coordinate your Battleship (Ship size: 4)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player1.battleship.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 13)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
               g.setColor(Color.green);
              
               g.drawString(">" + Player1.name + ", please pick the direction your Battleship is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player1.battleship.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 14)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player1.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player1.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                       }
                       else if ( Player1.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 82, 41);
                       }
                       else if (Player1.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.destroyer.x -1 )),50 + (40 * (Player1.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                       
                       Player1.battleship.direction = completeinput.charAt(0)-48;
                       
                         if ( Player1.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x),50 + (40 * (Player1.battleship.y - 3)), 41, 164);
                       }
                       else if (Player1.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y)), 41, 164);
                       }
                       else if ( Player1.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y )), 164, 41);
                       }
                       else if (Player1.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.battleship.x - 3)), 50 + (40 * (Player1.battleship.y)), 164, 41);
                       }
                       
                g.setColor(Color.green);
                       
                g.drawString(">" + Player1.name + " please enter the x-coordinate of your Carrier (Ship size: 5)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
            }
            
            
            
            
            
                else if (screen == 15)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                       
                            if ( Player1.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x),50 + (40 * (Player1.battleship.y - 3)), 41, 164);
                       }
                       else if (Player1.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y)), 41, 164);
                       }
                       else if ( Player1.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y )), 164, 41);
                       }
                       else if (Player1.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.battleship.x - 3)), 50 + (40 * (Player1.battleship.y)), 164, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player1.name + ", please pick the y-coordinate your Carrier (Ship size: 5)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player1.carrier.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 16)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player1.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player1.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 41, 82);
                   }
                   else if ( Player1.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player1.destroyer.x)),50 + (40 * (Player1.destroyer.y )), 82, 41);
                   }
                   else if (Player1.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player1.destroyer.x - 1)),50 + (40 * (Player1.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                       
                            if ( Player1.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x),50 + (40 * (Player1.battleship.y - 3)), 41, 164);
                       }
                       else if (Player1.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y)), 41, 164);
                       }
                       else if ( Player1.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y )), 164, 41);
                       }
                       else if (Player1.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.battleship.x - 3)), 50 + (40 * (Player1.battleship.y)), 164, 41);
                       }
               g.setColor(Color.green);
              
               g.drawString(">" + Player1.name + ", please pick the direction your Carrier is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player1.carrier.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 17)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player1.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player1.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                       }
                       else if ( Player1.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 82, 41);
                       }
                       else if (Player1.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.destroyer.x -1 )),50 + (40 * (Player1.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player1.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player1.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                       }
                       else if ( Player1.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                       }
                       else if (Player1.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                       }
                       
                       
                       
                       if ( Player1.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                       }
                       else if (Player1.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                       }
                       else if ( Player1.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                       }
                       else if (Player1.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                       }
                       
                     
                         if ( Player1.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x),50 + (40 * (Player1.battleship.y - 3)), 41, 164);
                       }
                       else if (Player1.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y)), 41, 164);
                       }
                       else if ( Player1.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y )), 164, 41);
                       }
                       else if (Player1.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.battleship.x - 3)), 50 + (40 * (Player1.battleship.y)), 164, 41);
                       }
                       
                        Player1.carrier.direction = completeinput.charAt(0)-48;
                        
                        
                        
                        
                             if ( Player1.carrier.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player1.carrier.x),50 + (40 * (Player1.carrier.y - 4)), 41, 205);
                       }
                       else if (Player1.carrier.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player1.carrier.x), 50 + (40 * (Player1.carrier.y)), 41, 205);
                       }
                       else if ( Player1.carrier.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player1.carrier.x), 50 + (40 * (Player1.carrier.y )), 205, 41);
                       }
                       else if (Player1.carrier.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player1.carrier.x - 4)), 50 + (40 * (Player1.carrier.y)), 205, 41);
                       }
                       
                       
                       
                       
                       
                        
                g.setColor(Color.green);
                       
                g.drawString(">" + Player1.name + ", please press \";\" to let " + Player2.name + " place their ships.", 320, 495);
                g.drawString(">" + userinput,320,505);
            }
            
             
            else if (screen == 18)
            {
                g.drawString(">" + Player2.name + ",please pick the x-coordinate for your Destroyer (Ship size: 2)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
            }
            else if (screen == 19)
            {
              g.drawString(">" + Player2.name + ", please pick the y-coordinate for your Destroyer (Ship size: 2)", 320, 495);
              g.drawString(">" + userinput, 320, 505);
              Player2.destroyer.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 20)
            {

               g.drawString(">" + Player2.name + ", please pick the direction your Destroyer is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player2.destroyer.y = completeinput.charAt(0) - 48;
               
            }
            else if (screen == 21)
            {
               
               g.drawString(">" + Player2.name + ", please pick the x-coordinate your Cruiser (Ship size: 3)",320,495);
               g.drawString(">" + userinput, 320, 505);
               
               g.setColor(Color.LIGHT_GRAY);
               Player2.destroyer.direction = completeinput.charAt(0) - 48;
               
                   if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x- 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                    
                    
                    
            }
            else if (screen == 22)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player1.name + ", please pick the y-coordinate your Cruiser (Ship size: 3)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player2.cruiser.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 23)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
               g.setColor(Color.green);
              
               g.drawString(">" + Player2.name + ", please pick the direction your Cruiser is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player2.cruiser.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 24)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player2.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player2.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                       }
                       else if ( Player2.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 82, 41);
                       }
                       else if (Player2.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.destroyer.x -1 )),50 + (40 * (Player2.destroyer.y)), 82, 41);
                       }
                       
                          Player2.cruiser.direction = completeinput.charAt(0) - 48;
                      if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                g.setColor(Color.green);
                       
                g.drawString(">" + Player2.name + " please enter the x-coordinate of your Submarine (Ship size: 3)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
                
            }
            
            
              else if (screen == 25)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player2.name + ", please pick the y-coordinate your Submarine (Ship size: 3)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player2.submarine.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 26)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                        }
               g.setColor(Color.green);
              
               g.drawString(">" + Player2.name + ", please pick the direction your Submarine is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player2.submarine.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 27)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player2.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player2.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                       }
                       else if ( Player2.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 82, 41);
                       }
                       else if (Player2.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.destroyer.x -1 )),50 + (40 * (Player2.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       Player2.submarine.direction = completeinput.charAt(0)-48;
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                g.setColor(Color.green);
                       
                g.drawString(">" + Player2.name + " please enter the x-coordinate of your Battleship (Ship size: 4)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
            }
            
            
              else if (screen == 28)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player2.name + ", please pick the y-coordinate your Battleship (Ship size: 4)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player2.battleship.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 29)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
               g.setColor(Color.green);
              
               g.drawString(">" + Player2.name + ", please pick the direction your Battleship is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player2.battleship.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 30)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player2.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player2.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                       }
                       else if ( Player2.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 82, 41);
                       }
                       else if (Player2.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.destroyer.x -1 )),50 + (40 * (Player2.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                       
                       Player2.battleship.direction = completeinput.charAt(0)-48;
                       
                         if ( Player2.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x),50 + (40 * (Player2.battleship.y - 3)), 41, 164);
                       }
                       else if (Player2.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y)), 41, 164);
                       }
                       else if ( Player2.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y )), 164, 41);
                       }
                       else if (Player2.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.battleship.x - 3)), 50 + (40 * (Player2.battleship.y)), 164, 41);
                       }
                       
                g.setColor(Color.green);
                       
                g.drawString(">" + Player2.name + " please enter the x-coordinate of your Carrier (Ship size: 5)", 320, 495);
                g.drawString(">" + userinput, 320, 505);
            }
            
            
            
            
            
                else if (screen == 31)
            {
                g.setColor(Color.LIGHT_GRAY);
                if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                       
                            if ( Player2.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x),50 + (40 * (Player2.battleship.y - 3)), 41, 164);
                       }
                       else if (Player2.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y)), 41, 164);
                       }
                       else if ( Player2.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y )), 164, 41);
                       }
                       else if (Player2.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.battleship.x - 3)), 50 + (40 * (Player2.battleship.y)), 164, 41);
                       }
                   g.setColor(Color.green);
                   
                   
                   
              g.drawString(">" + Player2.name + ", please pick the y-coordinate your Carrier (Ship size: 5)",320,495);      
              g.drawString(">" + userinput, 320, 505);
              Player2.carrier.x = completeinput.charAt(0) - 48;
            }
            else if (screen == 32)
            {
               g.setColor(Color.LIGHT_GRAY);
                  if ( Player2.destroyer.direction == 1)
                   {              
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                   }
                   else if (Player2.destroyer.direction == 2)
                   {
                       g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 41, 82);
                   }
                   else if ( Player2.destroyer.direction == 3)
                   {              
                       g.fillRect(50 + (40 * (Player2.destroyer.x)),50 + (40 * (Player2.destroyer.y )), 82, 41);
                   }
                   else if (Player2.destroyer.direction == 4)
                   {
                       g.fillRect(50 + (40 * (Player2.destroyer.x - 1)),50 + (40 * (Player2.destroyer.y)), 82, 41);
                   }
                   
                   
                   if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                       
                            if ( Player2.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x),50 + (40 * (Player2.battleship.y - 3)), 41, 164);
                       }
                       else if (Player2.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y)), 41, 164);
                       }
                       else if ( Player2.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y )), 164, 41);
                       }
                       else if (Player2.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.battleship.x - 3)), 50 + (40 * (Player2.battleship.y)), 164, 41);
                       }
               g.setColor(Color.green);
              
               g.drawString(">" + Player2.name + ", please pick the direction your Carrier is facing.", 320, 495);
               g.drawString(">1: North, 2: South, 3: East, 4: West", 320, 505);
               g.drawString(">" + userinput, 320, 515);
               Player2.carrier.y = completeinput.charAt(0) - 48;
            }
            else if (screen == 33)
            {
                     g.setColor(Color.LIGHT_GRAY);
                     if ( Player2.destroyer.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y - 1)), 41, 82);
                       }
                       else if (Player2.destroyer.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y)), 41, 82);
                       }
                       else if ( Player2.destroyer.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.destroyer.x),50 + (40 * (Player2.destroyer.y )), 82, 41);
                       }
                       else if (Player2.destroyer.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.destroyer.x -1 )),50 + (40 * (Player2.destroyer.y)), 82, 41);
                       }
                      
                      if ( Player2.cruiser.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x),50 + (40 * (Player2.cruiser.y - 2)), 41, 124);
                       }
                       else if (Player2.cruiser.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y)), 41, 124);
                       }
                       else if ( Player2.cruiser.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.cruiser.x), 50 + (40 * (Player2.cruiser.y )), 123, 41);
                       }
                       else if (Player2.cruiser.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.cruiser.x - 2)), 50 + (40 * (Player2.cruiser.y)), 123, 41);
                       }
                       
                       
                       
                       if ( Player2.submarine.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x),50 + (40 * (Player2.submarine.y - 2)), 41, 123);
                       }
                       else if (Player2.submarine.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y)), 41, 124);
                       }
                       else if ( Player2.submarine.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.submarine.x), 50 + (40 * (Player2.submarine.y )), 123, 41);
                       }
                       else if (Player2.submarine.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.submarine.x - 2)), 50 + (40 * (Player2.submarine.y)), 123, 41);
                       }
                       
                     
                         if ( Player2.battleship.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x),50 + (40 * (Player2.battleship.y - 3)), 41, 164);
                       }
                       else if (Player2.battleship.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y)), 41, 164);
                       }
                       else if ( Player2.battleship.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.battleship.x), 50 + (40 * (Player2.battleship.y )), 164, 41);
                       }
                       else if (Player2.battleship.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.battleship.x - 3)), 50 + (40 * (Player2.battleship.y)), 164, 41);
                       }
                       
                        Player2.carrier.direction = completeinput.charAt(0)-48;
                        
                        
                        
                        
                             if ( Player2.carrier.direction == 1)
                       {              
                           g.fillRect(50 + (40 * Player2.carrier.x),50 + (40 * (Player2.carrier.y - 4)), 41, 205);
                       }
                       else if (Player2.carrier.direction == 2)
                       {
                           g.fillRect(50 + (40 * Player2.carrier.x), 50 + (40 * (Player2.carrier.y)), 41, 205);
                       }
                       else if ( Player2.carrier.direction == 3)
                       {              
                           g.fillRect(50 + (40 * Player2.carrier.x), 50 + (40 * (Player2.carrier.y )), 205, 41);
                       }
                       else if (Player2.carrier.direction == 4)
                       {
                           g.fillRect(50 + (40 * (Player2.carrier.x - 4)), 50 + (40 * (Player2.carrier.y)), 205, 41);
                       }
                       
                       
                       
                       
                       
                        
                g.setColor(Color.green);
                       
                g.drawString(">Press \";\" to begin the game!", 320, 495);
                g.drawString(">",320,505);
            }
            
            else if (screen == 34)
{

                int firescreen = hitscreen;
                
                
                
                if (firescreen / 2 == 0)
                {
                                        
                    Player1.destroyer.placeBattleship(Player1);
                    Player1.cruiser.placeBattleship(Player1);
                    Player1.submarine.placeBattleship(Player1);
                    Player1.battleship.placeBattleship(Player1);
                    Player1.carrier.placeBattleship(Player1);
                    
                                    g.setColor(Color.LIGHT_GRAY);
                         if ( Player1.destroyer.direction == 1)
                           {              
                               g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y - 1)), 41, 82);
                               
                               Player1.destroyer.startx = 40 * Player1.destroyer.x + 550;
                               Player1.destroyer.starty = 40 * (Player1.destroyer.x - 1) + 550;
                               Player1.destroyer.endx = Player1.destroyer.startx + 41;
                               Player1.destroyer.endy = Player1.destroyer.starty + 82;
                           }
                           else if (Player1.destroyer.direction == 2)
                           {
                               
                               g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y)), 41, 82);
                           }
                           else if ( Player1.destroyer.direction == 3)
                           {            
                               
                               g.fillRect(50 + (40 * Player1.destroyer.x),50 + (40 * (Player1.destroyer.y )), 82, 41);
                           }
                           else if (Player1.destroyer.direction == 4)
                           {
                               
                               g.fillRect(50 + (40 * (Player1.destroyer.x -1 )),50 + (40 * (Player1.destroyer.y)), 82, 41);
                           }
                          
                          if ( Player1.cruiser.direction == 1)
                           {              
                               g.fillRect(50 + (40 * Player1.cruiser.x),50 + (40 * (Player1.cruiser.y - 2)), 41, 124);
                           }
                           else if (Player1.cruiser.direction == 2)
                           {
                               g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y)), 41, 124);
                           }
                           else if ( Player1.cruiser.direction == 3)
                           {              
                               g.fillRect(50 + (40 * Player1.cruiser.x), 50 + (40 * (Player1.cruiser.y )), 123, 41);
                           }
                           else if (Player1.cruiser.direction == 4)
                           {
                               g.fillRect(50 + (40 * (Player1.cruiser.x - 2)), 50 + (40 * (Player1.cruiser.y)), 123, 41);
                           }
                           
                           
                           
                           if ( Player1.submarine.direction == 1)
                           {              
                               g.fillRect(50 + (40 * Player1.submarine.x),50 + (40 * (Player1.submarine.y - 2)), 41, 123);
                           }
                           else if (Player1.submarine.direction == 2)
                           {
                               g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y)), 41, 124);
                           }
                           else if ( Player1.submarine.direction == 3)
                           {              
                               g.fillRect(50 + (40 * Player1.submarine.x), 50 + (40 * (Player1.submarine.y )), 123, 41);
                           }
                           else if (Player1.submarine.direction == 4)
                           {
                               g.fillRect(50 + (40 * (Player1.submarine.x - 2)), 50 + (40 * (Player1.submarine.y)), 123, 41);
                           }
                           
                         
                             if ( Player1.battleship.direction == 1)
                           {              
                               g.fillRect(50 + (40 * Player1.battleship.x),50 + (40 * (Player1.battleship.y - 3)), 41, 164);
                           }
                           else if (Player1.battleship.direction == 2)
                           {
                               g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y)), 41, 164);
                           }
                           else if ( Player1.battleship.direction == 3)
                           {              
                               g.fillRect(50 + (40 * Player1.battleship.x), 50 + (40 * (Player1.battleship.y )), 164, 41);
                           }
                           else if (Player1.battleship.direction == 4)
                           {
                               g.fillRect(50 + (40 * (Player1.battleship.x - 3)), 50 + (40 * (Player1.battleship.y)), 164, 41);
                           }
                           
                            
                                 if ( Player1.carrier.direction == 1)
                           {              
                               g.fillRect(50 + (40 * Player1.carrier.x),50 + (40 * (Player1.carrier.y - 4)), 41, 205);
                           }
                           else if (Player1.carrier.direction == 2)
                           {
                               g.fillRect(50 + (40 * Player1.carrier.x), 50 + (40 * (Player1.carrier.y)), 41, 205);
                           }
                           else if ( Player1.carrier.direction == 3)
                           {              
                               g.fillRect(50 + (40 * Player1.carrier.x), 50 + (40 * (Player1.carrier.y )), 205, 41);
                           }
                           else if (Player1.carrier.direction == 4)
                           {
                               g.fillRect(50 + (40 * (Player1.carrier.x - 4)), 50 + (40 * (Player1.carrier.y)), 205, 41);
                           }
                    
                    g.setColor(Color.green);
                    g.drawString(">" + Player1.name +"'s turn!", 320, 495);
                    g.drawString(">You have " + Player1.bullets + " missiles.", 320, 505);
                    g.drawString(">Click a box on the opposite screen to fire a missile.", 320, 515);
                }
                else
                {
                    
                }
        }
       }//end of game screen
    }
    
    /**
     * Called by the browser or applet viewer to inform this JApplet that it
     * is being reclaimed and that it should destroy any resources that it
     * has allocated. The stop method will always be called before destroy.
     */
    public void destroy()
    {
        // provide code to be run when JApplet is about to be destroyed.
    }


    /**
     * Returns information about this applet.
     * An applet should override this method to return a String containing
     * information about the author, version, and copyright of the JApplet.
     *
     * @return a String representation of information about this JApplet
     */
    public String getAppletInfo()
    {
        // provide information about the applet
        return "Title:   \nAuthor:   \nA simple applet example description. ";
    }


    /**
     * Returns parameter information about this JApplet.
     * Returns information about the parameters than are understood by this JApplet.
     * An applet should override this method to return an array of Strings
     * describing these parameters.
     * Each element of the array should be a set of three Strings containing
     * the name, the type, and a description.
     *
     * @return a String[] representation of parameter information about this JApplet
     */
    public String[][] getParameterInfo()
    {
        // provide parameter information about the applet
        String paramInfo[][] = {
                 {"firstParameter",    "1-10",    "description of first parameter"},
                 {"status", "boolean", "description of second parameter"},
                 {"images",   "url",     "description of third parameter"}
        };
        return paramInfo;
    }


        //MouseListener Methods
        public void mouseClicked(MouseEvent event)
        {
            xco = event.getX();
            yco = event.getY();
            fireimage = true;
            repaint();
            event.consume();
             
            
            fireimage = false;
             repaint();
            event.consume();
            
           
            
        }
        
        public void mousePressed(MouseEvent event)
        {
            xco = event.getX();
            yco = event.getY();
            fireimage = true;
            repaint();
            event.consume();
        }
        
        public void mouseReleased(MouseEvent event)
        {
            xco = event.getX();
            yco = event.getY();
            fireimage = false;
            repaint();
            event.consume();
        }
        
        public void mouseEntered(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
        }
        
        public void mouseExited(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
        }

        
        
        //KeyListener Methods
        public void keyPressed(KeyEvent e)
        {
         
           
        }
        
        public void keyReleased(KeyEvent e)
        {
            
            
        }
        
        public void keyTyped(KeyEvent e)
        {
            
             key = e.getKeyChar();
            
            if (key != KeyEvent.CHAR_UNDEFINED)
            {
                
                if (key == ';')
                {
                    completeinput = userinput;
                    userinput = "";
                    charfix = 0;
                    screen++;
                }
                
                if (charfix != 0)
                        userinput += key;
  
           
                repaint();
                e.consume();
                
            }
          
            charfix++;
        }

        
        
        
    public boolean fire(int c, int r)
    {
        boolean hit = false;

        if (Player1.board[c][r] != -1 || Player1.board[c][r] != 2)
        {
            if (Player1.board[c][r] == 1)
            {
                Player1.bullets--;
                hit = true;
                Player1.board[c][r] = 2;
            }
            else
            {
                Player1.bullets--;
                hit = false;
                Player1.board[c][r] = - 1;
            }
        }

        return hit;
    }




}
