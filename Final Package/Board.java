

/**
 * Each user gets a board. Each board can fire
 * 
 * Jack Harrington, Phillip Sajaev, Jeevan Maddila
 */
public class Board
{
    public int[][] board = {{0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0}};
    
    //0 = no battleship there   
    //1 = battleship there
    
    public int bullets;
    public String name; 
    public Board(String name)
    {
        this.name = name;
        bullets = 5;
    }
    
    public boolean fire(int c, int r)
    {
        bullets--;
        boolean hit;
        if (board[c][r] == 0)
            hit = false;
        else
            hit = true;
        return hit;
        
        
    }
    
    public void updateBoard(boolean hit, int c, int r)
    {
        if (hit)
            //2 = hit
            board[c][r] = 2;
        else 
            //1 = miss
            board[c][r] = -1;
    }
    
    public void viewBoard()
    {
        System.out.println(board);
    }

}
