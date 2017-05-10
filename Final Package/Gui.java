import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui extends JFrame
{
    private JPanel mousepanel;
    private JLabel statusbar;
    
    public Gui()
    {
        super("title");
        
        mousepanel = new JPanel();
        mousepanel.setBackground(Color.gray);
        add(mousepanel, BorderLayout.CENTER);
        
        statusbar = new JLabel("default");
        add(statusbar, BorderLayout.SOUTH);
        
        Handlerclass handler = new Handlerclass();
        mousepanel.addMouseListener(handler);
        mousepanel.addMouseMotionListener(handler);
        
    }
    
    private class Handlerclass implements MouseListener, MouseMotionListener
    {
        //MouseListener Methods
        public void mouseClicked(MouseEvent event)
        {
            statusbar.setText(String.format("Clicked at %d, %d", event.getX(), event.getY()));
        }
        public void mousePressed(MouseEvent event)
        {
            statusbar.setText("You pressed the mouse.");
        }
        public void mouseReleased(MouseEvent event)
        {
            statusbar.setText("You released the button.");
        }
        public void mouseEntered(MouseEvent event)
        {
            statusbar.setText("You entered the area.");
            mousepanel.setBackground(Color.red);
        }
        public void mouseExited(MouseEvent event)
        {
            statusbar.setText("The mouse has left the window.");
            mousepanel.setBackground(Color.gray);
        }
        
        //MouseMotionListener Methods
        public void mouseDragged(MouseEvent event)
        {
            statusbar.setText("You are dragging the mouse.");
        }
        public void mouseMoved(MouseEvent event)
        {
            statusbar.setText("You moved the mouse.");
        }
   }
    
}
