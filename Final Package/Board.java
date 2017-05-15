

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
    public boolean hit;
    
    Battleship destroyer = new Battleship(2);
    Battleship cruiser = new Battleship(3);
    Battleship submarine = new Battleship(3);
    Battleship battleship = new Battleship(4);
    Battleship carrier = new Battleship(5);
    public Board(String name)
    {
        this.name = name;
        bullets = 5;
    }
    
    public boolean fire(int c, int r)
    {
        bullets--;
        
        if (board[c][r] == 1)
            hit = true;
        else
            hit = false;
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
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++)
                System.out.print(board[row][col] + "\t");
            System.out.println();
                
        }
    }
    
    public int goBoard()
    {
        int x = 0;
        int count = 0;
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++)
            {
                x = board[row][col];
                if (x == 1)
                    count++;
            }                
        }
        return count;
    }

}
