import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;
import java.util.*;

/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
    //public int[][] placement;
    //Board player1 = new Board();
    private Board player1, player2;


    /**
     * Default constructor for objects of class Client
     */
    public static void main(String[] args)
    {
        //defines scanner

        Scanner user_input = new Scanner(System.in);
        
            
    
        System.out.println("Player 1, what is your name?");
        System.out.println(" ");
        String name = user_input.nextLine();
        Board player1 = new Board(name);
    
        System.out.println("Player 2, what is your name?");
        System.out.println(" ");
        String name1 = user_input.nextLine();
        Board player2 = new Board(name1);

        Battleship placement  = new Battleship(2);
        Battleship placement1  = new Battleship(3);
        Battleship placement2 = new Battleship(4);
        Battleship placement3  = new Battleship(5);

        System.out.println("What x-cordinate should ship number 1 start");
        int choice = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 1 start");
        int choice1 = user_input.nextInt();
        System.out.println("What direction do you want to put ship one");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction = user_input.nextInt();
        placement.placeBattleship(choice,choice1,direction,player1);
        System.out.println(" ");
            
        System.out.println("What x-cordinate should ship number 2 start");
        int choice2 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 2 start");
        int choice3 = user_input.nextInt();
        System.out.println("What direction do you want to put ship two");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction1 = user_input.nextInt();
        placement1.placeBattleship(choice2,choice3,direction1,player1);
        System.out.println(" ");
        
        System.out.println("What x-cordinate should ship number 3 start");
        int choice4 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 3 start");
        int choice5 = user_input.nextInt();
        System.out.println("What direction do you want to put ship three");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction2 = user_input.nextInt();
        placement2.placeBattleship(choice4,choice5,direction2,player1);
        System.out.println(" ");
        
        System.out.println("What x-cordinate should ship number four start");
        int choice6 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number four start");
        int choice7 = user_input.nextInt();
        System.out.println("What direction do you want to put ship four");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction3 = user_input.nextInt();
        placement3.placeBattleship(choice6,choice7,direction3,player1);
        System.out.println(" ");
        
        System.out.println("Ok " + name + " Your board is");
        player1.viewBoard();
        
        

        Battleship placement4  = new Battleship(2);
        Battleship placement5  = new Battleship(3);
        Battleship placement6 = new Battleship(4);
        Battleship placement7  = new Battleship(5);

        System.out.println("What x-cordinate should ship number 1 start");
        int choice16 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 1 start");
        int choice17 = user_input.nextInt();
        System.out.println("What direction do you want to put ship one");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction4 = user_input.nextInt();
        placement4.placeBattleship(choice16,choice17,direction4,player2);
        System.out.println(" ");
            
        System.out.println("What x-cordinate should ship number 2 start");
        int choice8 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 2 start");
        int choice9 = user_input.nextInt();
        System.out.println("What direction do you want to put ship two");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction5 = user_input.nextInt();
        placement5.placeBattleship(choice8,choice9,direction5,player2);
        System.out.println(" ");
        
        System.out.println("What x-cordinate should ship number 3 start");
        int choice10 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number 3 start");
        int choice11 = user_input.nextInt();
        System.out.println("What direction do you want to put ship three");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction6 = user_input.nextInt();
        placement6.placeBattleship(choice10,choice11,direction6,player2);
        System.out.println(" ");
        
        System.out.println("What x-cordinate should ship number four start");
        int choice12 = user_input.nextInt();
        System.out.println("What y-cordinate should ship number four start");
        int choice13 = user_input.nextInt();
        System.out.println("What direction do you want to put ship four");
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction7 = user_input.nextInt();
        placement7.placeBattleship(choice12,choice13,direction7,player2);
        System.out.println(" ");
        
        System.out.println("Ok " + name1 + " Your board is");
        player2.viewBoard();
        //turn();
        

        
 
    }
    public static int n = 1;
    public void turn()
    {
        Scanner user_input = new Scanner(System.in);
        if (n % 2 != 0)
        {
            System.out.println("It is your turn Player 1");
            System.out.println("What x-cordinate do you want to target");
            int hit = user_input.nextInt();
            System.out.println("What y-cordinate do you want to target");
            int hit1 = user_input.nextInt();
            boolean wow = player2.fire(hit,hit1);
            if (wow == true)
                System.out.println("Wow you got a hit");
            else
                System.out.println("Sorry you did not get a hit");
            player2.updateBoard(wow, hit, hit1);
            player2.viewBoard();
            n++;
            turn();
        }
        
        if (n % 2 == 0)
        {
        }
        
    }

    

}
