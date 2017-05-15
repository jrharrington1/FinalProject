/**
 * Jack Harrington, Phillip Sajaev, Jeevan Maddila
 */
import java.util.*;
public class Battleship
{
    int length; 
    int direction;
    int x;
    int y;
    int startx;
    int starty;
    int endx;
    int endy;
    String type;
    
    int[][] pegs;
    public Battleship(int length)
    {
        this.length = length;
        
        if (length == 2)
            type = "Destroyer";
        else if (length == 4)
            type = "Battleship";
        else
            type = "Carrier";
            
        direction = 0;
    }
    
    public Battleship(int length, int suborcru)
    {
        this.length = length;
        
        if (suborcru == 1)
            type = "Cruiser";
        else
            type = "Submarine";
            
        direction = 0;
    }
    
    public void placeBattleship(Board playingfield)
    {
        
        
        
        if (direction == 1){// north
            for (int i = 0; i < length; i++)
                playingfield.board[x][y + i] = 1;
        
       }
    
        if (direction == 2){// south
            for (int j = 0; j < length; j++)
                playingfield.board[x][y - j] = 1;
        
       }
    
        if (direction == 3){// east
            for (int k = 0; k < length; k++)
                playingfield.board[x + k][y] = 1;
        
       }
    
        if (direction == 4){// west
            for (int n = 0; n < length; n++)
                playingfield.board[x - n][y] = 1;
        
       }
    
    
    }
    
    public void setPegs()
    {
        for (int i = 1; i <= length; i++)
        {
            
        }

    }
   
}
