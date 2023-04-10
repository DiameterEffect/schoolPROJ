import java.util.Scanner;
import java.lang.Math;

public class DiceGAMEreal {
    public static void main(String[] args) {


        Scanner scannerObj = new Scanner(System.in);
        String userNAME = "Admin";
        String password = "Admin1";
        int DICE1 = 6;
        int DICE2 = 6;
        //Takes user to login method
        Login(userNAME,password);
        ///Basic menu
        System.out.println("Choose an option: ");
        System.out.println("1. Dice Game");
        System.out.println("2. Exit");
        int optionUSER = scannerObj.nextInt();
        ///User enters an options wether to leave or play the game
             switch (optionUSER) {
                case 1:
                    PlayGame(scannerObj,DICE1,DICE2);
                    break;
                case 2:
                    System.out.println("Exiting program, good bye!");
                    break;
            
                default:
                    System.out.println("invaild option, please try again later, bye. ");
                    
                    break;
            }

    }

    public static void PlayGame(Scanner scannerObj,int DICE1,int DICE2) 

    {
        System.out.println("Starting game");
        
        ///scoreboard, we are going to have it called every time the 
        ///player goes, the scoreboard will be shown
        ///Player starts with 40 dollars

        int P1score = 0;
        int P1money = 40;
        int P2score = 0;
        int P2money = 40;
        int pot = 0;


        ///Enter logic
        ///Calls in the method to generate it inside the array and therefore we get 2 values inside the array
        ///Dice 1 and Dice 2 all randomly genearated
        int[] diceValues = diceGEN();
        DICE1 = diceValues[0];
        DICE2 = diceValues[1];
        ///Needs to be stored in logEntries whenever we get the chance
        System.out.println("Values in diceValues: ");
        for(int i = 0;i <diceValues.length;i++)
        {
            System.out.print(diceValues[i] + " ");
        }
        System.out.println();
        ///P1 turn
        System.out.println("Player one turn");
        System.out.println("Player one, how much would you like to bet? Current balance: " + P1money);
        int answ = scannerObj.nextInt();
        pot = pot + answ;
        System.out.println("Current pot: " + pot);
         P1money = P1money - answ;
        System.out.println("Current bal: " + P1money);
        System.out.println("Player one betted: " + answ);
        System.out.println("Player one turn to roll dice");
        P1score = DICE1+DICE2;
        System.out.println("Player one rolled " + P1score);
        ///P2 turn
        System.out.println("Player two turn");
        System.out.println("Player two, how much would you like to bet? Current balance: " + P2money);
        int answ2 = scannerObj.nextInt();
        pot = pot + answ2;
        System.out.println("Current pot: " + pot);
         P2money = P2money - answ2;
        System.out.println("Current bal: " + P2money);
        System.out.println("Player one betted: " + answ2);
        System.out.println("Player one turn to roll dice");
        P1score = DICE1+DICE2;
        System.out.println("Player one rolled " + P2score);
        

        ///Game rules here in computer form
        ///Basically player rolls 7 they win
        ///Player rolls a 2-3-12 they lose
        switch (P1score) {
            case 7:
                System.out.println("This player has 7!");
                
                break;
            case 2:

            case 3:

            case 12:
                System.out.println("This player has rolled a 2,3, or 12!");
                break;
        
            default:
                break;
        }




        
        

        




            ///if player wins, input if they wanna try again with the money they have, or exit the program

            

        ///Calling this generates the points
        ///diceGEN(DICE1, DICE2);
        
        //diceGEN(DICE1, DICE2);


        

        
    }
    ///Have a seperate method generate the number of dice the player gets
    ///Going to have two intergers called DICE1 and DICE2 passed
    /// here and it will be returned in PlayGame method.
    public static int[] diceGEN ()
    {
        int DICE1 = (int) (Math.random() * 6) + 1;
        int DICE2 = (int) (Math.random() * 6) + 1;
        int[] diceValues = {DICE1, DICE2};
        return diceValues;
        ///This generates a number everytime its called


        //System.out.println("Number for DICE1 is  " + DICE1);
        //System.out.println("Number for DICE2 is  " + DICE2);
        
        
    }

    public static void Login(String userNAME, String password) 

    {
        Scanner scannerObj = new Scanner(System.in);
        boolean flag = true;
         //Processing if user enters the correct password or not
        while (flag) {
            System.out.println("Enter your username:");
            String inputuser = scannerObj.next();
            System.out.println("Enter your password:");
            String inputuser2 = scannerObj.next();
            if (inputuser.equals(userNAME) && inputuser2.equals(password)) {
                ///line below we are going to log this into the file
                System.out.println("Correct!!");
                ///Once user gets it correct, loop turns off 
                flag = false;

                
            }
            else
            {
                System.out.println("Incorrect, try again!");
            }
            ///scannerObj.close();
            
        }


        


        
    }

    public static void LogEntries(String text) 
    {
        
    }


    
}