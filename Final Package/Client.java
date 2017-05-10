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
    
    /**
     * Default constructor for objects of class Client
     */
    public static void main(String[] args)
    {
        //defines scanner
        Scanner scan = new Scanner(System.in);
        Scanner user_input = new Scanner(System.in);
        System.out.println("Player 1, what is your name?");
        System.out.println(" ");
        String name = user_input.nextLine();
        Board player1 = new Board(name);
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
        
 
    }

    

}
