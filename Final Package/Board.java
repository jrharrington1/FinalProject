

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
    
    
    Battleship destroyer = new Battleship(2);
    Battleship cruiser = new Battleship(3, 1);
    Battleship submarine = new Battleship(3, 2);
    Battleship battleship = new Battleship(4);
    Battleship carrier = new Battleship(5);
    int[][] hitdisplay = {{}};
                    
    Battleship[] ships = {destroyer,cruiser,submarine,battleship,carrier};
    
    public Board(String name)
    {
        this.name = name;
        bullets = 20;
    }
    
   

    public void updateBoard(boolean hit, int c, int r)
    {
        if (hit)
            //2 = hit
            board[r][c] = 2;
        else 
            //1 = miss
            board[r][c] = -1;
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
    
    public boolean ammoCheck()
   
    {
        //used to end game, if one player has no ammo, they lose
        boolean ammo = true;
        if (bullets  == 0)
        {
            ammo = false;
        }
        
        
        return ammo;
     }
     
     public boolean shipCheck()
     {  
         boolean shipsAlive = false;
         int check = 0;
         
         //used to end game. if one player has no ships, they lose 
         for (int x = 0; x < board.length; x++)
         {
             for (int y = 0; y < board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    check++;
                }
            }
            }
            
         if (check > 0)
         {
             shipsAlive = true;
            }
         else
            shipsAlive = false;
            
          return shipsAlive;
        }
}
