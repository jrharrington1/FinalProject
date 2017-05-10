
import java.awt.*;
import javax.swing.*;

/**
 * Class Temporary - write a description of the class here
 * 
 * @author (your name) 
 * @version (a version number)
 */
public class Temporary extends JApplet
{
    Image logo;
    MediaTracker tr;

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
        
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1000, 600);
        g.setColor(Color.gray);
        g.fillRect(200,400,150,75);
        g.fillRect(650,400,150,75);
        Font buttonfont = new Font("asdfasdf", 1500, 35);
        
        g.setFont(buttonfont);
        g.setColor(Color.white);
        g.drawString("Start", 235, 445);
        g.drawString("Options", 665, 445);
        
        tr = new MediaTracker(this);
        logo = getImage(getCodeBase(), "battleshiplogo.jpg");
        tr.addImage(logo, 0);
        g.drawImage(logo, 335,111, this);
        
        /**

      
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1000, 600);
        g.setColor(Color.cyan);
        
        g.fillRect(50,50,400,400);
        g.fillRect(550,50,400,400);

        Font armyfont = new Font("army", 1500, 20);
        g.setFont(armyfont);
        g.setColor(Color.white);
        g.drawString("Battleship", 456, 20);
        
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
        
        
        Board player1 = new Board("Jack");
        g.setColor(Color.black);
        
        
        int y = 75;
        for (int i = player1.bullets; i > 0; i--)
        {
            g.fillOval(13, y, 25, 25); 
            y+= 50;
        }
        
        Board player2 = new Board("Phillip");
        y = 75;
        
        for (int i = player2.bullets; i > 0; i--)
        {
            g.fillOval(963, y, 25, 25); 
            y+= 50;
        }
        */
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
}
