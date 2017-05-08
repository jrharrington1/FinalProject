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
    Battleship placement  = new Battleship(2);
    Battleship placement1  = new Battleship(3);
    Battleship placement2 = new Battleship(4);
    Battleship placement3  = new Battleship(5);
    /**
     * Default constructor for objects of class Client
     */
    public static void main(String[] args)
    {
        //defines scanner
        Scanner scan = new Scanner(System.in);
        Scanner user_input = new Scanner(System.in);
        System.out.println("Player 1, what is your name?");
        String name = user_input.nextLine();
        //Board player1 = new Board(name);

        System.out.println("What x-cordinate where should ship  " + k + " start");
        int choice = user_input.nextInt();
        System.out.println("What y-cordinate where should ship  " + k + " start");
        int choice1 = user_input.nextInt();
        System.out.println("Which direction do you want to put ship number " + k);
        System.out.println("1: North, 2: South, 3:East, 4:West");
        int direction = user_input.nextInt();
        placement.placeBattleship(choice,choice1,direction,player1);
            
            System.out.println("What x-cordinate where should ship  " + k + " start");
            int choice = user_input.nextInt();
            System.out.println("What y-cordinate where should ship  " + k + " start");
            int choice1 = user_input.nextInt();
            System.out.println("Which direction do you want to put ship number " + k);
            System.out.println("1: North, 2: South, 3:East, 4:West");
            int direction = user_input.nextInt();
            placement1.placeBattleship(choice,choice1,direction,player1);
                        System.out.println("What x-cordinate where should ship  " + k + " start");
            int choice = user_input.nextInt();
            System.out.println("What y-cordinate where should ship  " + k + " start");
            int choice1 = user_input.nextInt();
            System.out.println("Which direction do you want to put ship number " + k);
            System.out.println("1: North, 2: South, 3:East, 4:West");
            int direction = user_input.nextInt();
            placement2.placeBattleship(choice,choice1,direction,player1);
                        System.out.println("What x-cordinate where should ship  " + k + " start");
            int choice = user_input.nextInt();
            System.out.println("What y-cordinate where should ship  " + k + " start");
            int choice1 = user_input.nextInt();
            System.out.println("Which direction do you want to put ship number " + k);
            System.out.println("1: North, 2: South, 3:East, 4:West");
            int direction = user_input.nextInt();
            placement3.placeBattleship(choice,choice1,direction,player1);
    }

    

}
