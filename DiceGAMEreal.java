import java.util.Scanner;

import javax.sound.sampled.Port;

import java.lang.Math;
public class DiceGameThree {
    public static void main(String[] args) {
        
        Scanner scannerObj = new Scanner(System.in);
        
        int choice = 0;

        do
        {
            ////Copy down menu options
            System.out.println("1. Rules");
            System.out.println("2. Play against computers");
            System.out.println("3. Play 2 player game");
            System.out.println("4. See high score");
            System.out.println("5. Quit");

            choice = scannerObj.nextInt();
            switch (choice)

            {
                
                case 1:

                    ///Rules(no method needed)
                    rules();
                    break;
                
                case 2:
                    ///play againist computer
                    AicomputerGame();
                    break;
                case 3:

                    ///play 2 player game
                    TwoPlayerGame();
                    break;

                case 4:

                    ///See high score
                    HighScore();
                    break;
                
                case 5:

                    ///quit
                    break;

                default:
                ///error log
                    System.out.println("error, invaild number, try again.");
                    break;
            }
        }while(choice!=5);
        {
            System.out.println("good bye");

            scannerObj.close();

        }




    }

    public static void rules() 
    {
        System.out.println("Game rules:");
        System.out.println("Player starts with 20 dollars");
        System.out.println("If a player rolls a 7 or an 11 with two of the dice they");
        System .out.println("win the game and they take the cash. If player rolls a 2-3-12 they lose.");
        System .out.println("Player wins");
    }
    
    public static void AicomputerGame() 
    {
        

        double pot = 0;
        double Player1BAL = 20;
        double Player1BET = 0;
        
        double Player2BAL = 20;
        double PLayer2BET = 0;
        int DICE1 = 6;
        int DICE2 = 6;
        ///whatever dice they rolled
        int Player1diceSUM = 0;
        int Player2diceSUM = 0;

        Scanner scannerObj = new Scanner(System.in);
        ///let the player enter whatever username they want
        System.out.println("Enter the username you want");
        String Player1 = scannerObj.next();
        System.out.println("Your username is: " + Player1);
        ///Computer name
        String userNAME2 = "CPU";



        ///Prints both values for the dice

        
        ///player one goes first

        System.out.println( Player1 + " 's turn!");
        System.out.println(Player1 + " Max number you can bet is " + Player1BAL);
        System.out.println(Player1 + " How much would you like to bet?");
        double answ = scannerObj.nextDouble();

        Player1BET = answ;

        while(Player1BET < 0 || Player1BET > Player1BAL )
        {
            System.out.println("Error, you must select a number greater than 0 or");
            System.out.println("less than or equal to your balance which is " + Player1BAL);
            System.out.println(Player1 + " How much would you like to bet?");
            double answ2 = scannerObj.nextDouble();
            Player1BET = answ2;

        }
        
        ///Pot gets updated
        pot = pot + Player1BET;
        ///print current pot?
        ///Print current balance?

        System.out.println(Player1 + "'s turn to roll dice!");

        int[] diceValues = diceGEN();
        DICE1 = diceValues[0];
        DICE2 = diceValues[1];
        ///delete after
        System.out.println("Values in diceValues: ");

        for(int i = 0;i <diceValues.length;i++)
        {
            System.out.print(diceValues[i] + " '");
        }
        System.out.println("  ");
        System.out.println("  ");

        Player1diceSUM = DICE1+DICE2;

        System.out.println(Player1 + " rolled " + Player1diceSUM);

        System.out.println("CPUs turn");

        int[] diceValues2 = diceGEN();
        DICE1 = diceValues2[0];
        DICE2 = diceValues2[1];

        Player2diceSUM = DICE1+DICE2;
        ///match the player
        PLayer2BET = Player1BET;
        pot = pot + PLayer2BET;

        System.out.println("CPU rolled "+ Player2diceSUM);

        System.out.println("Current pot is  "+ pot);
        ///If its true or not
        switch (Player1diceSUM) {
            case 2:
            case 3:
            case 12:
                System.out.println("You rolled " + Player1diceSUM);
                
                System.out.println("You lost!");
                System.out.print("CPU gets the pot");
                pot = Player2BAL;
                System.out.println(pot);
                ///CPU gets money
                break;
            case 7:
            case 11:
                System.out.println("You win");
                System.out.println(Player1 + " gets the pot!");
                System.out.println(pot);
                pot = Player1BAL;
                break;
        }
        switch (Player2diceSUM) {
            case 2:
            case 3:
            case 12:
                System.out.println("You rolled " + Player2diceSUM);
                
                System.out.println("CPU lost!");
                System.out.print( Player1 + " gets the pot");
                System.out.println(pot);
                pot = Player1BAL;
                System.out.println("Your balance is now " + Player2BAL);
                break;
            case 7:
            case 11:
                System.out.println("You win");
                System.out.println( " CPU gets the pot!");
                System.out.println(pot);
                pot = Player2BAL;
                System.out.println("Your balance is now " + Player2BAL);
                break;
        }




        








        









  






        System.out.println("Test");
        
    }

    public static void TwoPlayerGame() 
    {
        System.out.println("Test23");
        
    }

    public static void HighScore() 
    {
        ////For this we need to get Player 1 user name from
        /// AIcomputerGame and then print the content into the file
        ///ex John score is 20
        System.out.println("High score system");    
    }

    public static int[] diceGEN ()
    {
        int DICE1 = (int) (Math.random() * 6) + 1;
        int DICE2 = (int) (Math.random() * 6) + 1;
        int[] diceValues = {DICE1, DICE2};
        return diceValues;
        ///This generates a number everytime its called
        
    }



}

    
