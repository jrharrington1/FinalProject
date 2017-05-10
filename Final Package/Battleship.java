/**
 * Jack Harrington, Phillip Sajaev, Jeevan Maddila
 */
import java.util.*;
public class Battleship
{
    int length; 
    
    public Battleship(int length)
    {
        this.length = length;
    }
    
    public void placeBattleship(int xcoordinate, int ycoordinate, int directions, Board playingfield){
        
        int x = xcoordinate;
        int y = ycoordinate;
        int direction = directions;
        
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
}
