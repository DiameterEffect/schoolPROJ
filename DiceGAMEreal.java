import java.util.Random;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;
import javax.sound.sampled.Port;
import java.lang.Math;
public class DiceGameThree
{
    public static void main(String[] args) 
    {
        
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
        
        //Variabiles for AI game
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

        // the value for this variable
        // never changes and is used after
        // every instance when a player wins or loses
        final int RESET_POT_TO_ZERO = 0;

        Scanner scannerObj = new Scanner(System.in);
        
        ///let the player enter whatever username they want
        System.out.println("Enter the username you want");
        String Player1 = scannerObj.next();
        System.out.println("Your username is: " + Player1);

    

        //Player and CPU rolls dice to see who is the shooter(Shooter gets to roll dice)
        int Player1ShooterSum = 0;
        int CPUShooterSum = 0;
        


        


        

        

        boolean flag = true;
        boolean gameFLAG = true;
        boolean shooterROLE = true;
        

        while (flag)
        {
            
            //Logic statement to decide who goes first

            System.out.println(Player1 + " it is your turn to roll to see who is the shooter");
            
            //generates dice numbers for player1
            int[] diceValuesSHOOTER = diceGEN();
            DICE1 = diceValuesSHOOTER[0];
            DICE2 = diceValuesSHOOTER[1];
    
            Player1ShooterSum =  DICE1 + DICE2;

            //display the player1shooter sum here
            System.out.println(Player1 + " rolled " + Player1ShooterSum);

    
            System.out.println("It's now the CPU's turn to roll to see who is the shooter");
    
            //generates dice numbers for CPU
            int[] diceValuesSHOOTER2 = diceGEN();
            DICE1 = diceValuesSHOOTER2[0];
            DICE2 = diceValuesSHOOTER2[1];
    
            CPUShooterSum = DICE1 + DICE2;
            System.out.println("CPU rolled " + CPUShooterSum);

            if (Player1ShooterSum > CPUShooterSum)
            {
                System.out.println(Player1 + " gets to shoot first!");
                
                
                //Player bet goes
                System.out.println(Player1 + "'s turn to make a bet!");
                System.out.println(Player1 + ", max number you can bet is " + Player1BAL);
                System.out.println(Player1 + ", how much would you like to bet?");
                double answ = scannerObj.nextDouble();
                Player1BET = answ;

                //Safety if Player enters invaild values.
                while(Player1BET < 0 || Player1BET > Player1BAL )
                {
                    System.out.println("Error, you must select a number greater than 0 or");
                    System.out.println("less than or equal to your balance which is " + Player1BAL);
                    System.out.println(Player1 + " How much would you like to bet?");
                    double answ2 = scannerObj.nextDouble();
                    Player1BET = answ2;
        
                }
                
                //pot functioning
                pot = pot + Player1BET;
                System.out.println(Player1 + " betted " + Player1BET);
                System.out.println("CPU must match " + Player1 +  "'s bet");

                PLayer2BET = Player1BET;
                System.out.println("CPU betted " + PLayer2BET);                                
                pot = pot + PLayer2BET;
                
                System.out.println("The total in the pot is now " + pot);

                
                //Update the balance for both players
                Player1BAL = Player1BAL - Player1BET;
                Player2BAL = Player2BAL - PLayer2BET;





                //Player 1 turn to roll dice
                System.out.println(Player1 + "'s turn to roll dice for the First Roll!");
                
                //Generates the random values that Player 1 rolls
                int[] diceValues = diceGEN();
                DICE1 = diceValues[0];
                DICE2 = diceValues[1];

                //Sum of dice they rolled
                Player1diceSUM = DICE1+DICE2;

                System.out.println("The sum of the dice rolled by " + Player1  + " is "+ Player1diceSUM);



                //full switch statement applies to the first roll only
                //except for the default section where a point number
                //is generated

                //first roll code for player1
                switch (Player1diceSUM) 
                {
                    //Losing scenario
                    case 2:
                    case 3:
                    case 12:
                        System.out.println(Player1 + " rolled " + Player1diceSUM);
                        System.out.println("You lost!");
                        System.out.println("CPU gets the pot");

                        //add the pot to CPU balance
                        Player2BAL = Player2BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        System.out.println("CPU now has " + Player2BAL);
                        
                        
                        ///CPU gets money
                        //flag = false;
                        break;
                    //winning scenario
                    case 7:
                    case 11:
                        System.out.println(Player1 + " rolled " + Player1diceSUM);
                        System.out.println("You win!");
                        System.out.println(Player1 + " gets the pot!");

                        //add the pot to player1 balance
                        Player1BAL = Player1BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        //flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                        //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println("You rolled a point number " + Player1diceSUM +  " roll again!!");
                        int PlayerPOINT = Player1diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT+ "");
                        break;


                    
                        
                }
                System.out.println("You're inside the if statement");
                flag=false;
                //write ur code here.
                
                
                        






                
            }
            else if (Player1ShooterSum < CPUShooterSum) 
            {
                System.out.println("CPU gets to shoot first!");


                
                //CPU bet goes here
                System.out.println("CPU's turn to make a bet!");
                System.out.println("Max number CPU can bet is " + Player2BAL);
                System.out.println("CPU, how much would you like to bet?");
            
                double minCPUbet = 1.00;
                double maxCPUbet = Player2BAL;
                double CPUbet = Math.floor((Math.random() * (maxCPUbet  - minCPUbet + 0.01) + minCPUbet) * 100) / 100;
                
                PLayer2BET = CPUbet;



                //pot functioning
                pot = pot + PLayer2BET;
                System.out.println("CPU betted " + PLayer2BET);
                System.out.println(Player1 + " must match CPU's bet");

                Player1BET = PLayer2BET;
                System.out.println(Player1 + " betted " + Player1BET);
                pot = pot + Player1BET;
                
                System.out.println("The total in the pot is now " + pot);

                
                
                //Update the balance for both players
                Player1BAL = Player1BAL - Player1BET;
                Player2BAL = Player2BAL - PLayer2BET;




                /*
                //pot functioning from player 1 code
                pot = pot + Player1BET;
                System.out.println(Player1 + " betted " + Player1BET);
                System.out.println("CPU must match " + Player1 +  "'s bet");

                PLayer2BET = Player1BET;
                System.out.println("CPU betted " + PLayer2BET);                                
                pot = pot + PLayer2BET;
                */



                //code right before player 1 switch statement
                /* 
                //Player1 turn to roll dice for the First Roll
                System.out.println(Player1 + "'s turn to roll dice for the First Roll!");
                
                //Generates the random values that Player 1 rolls
                int[] diceValues = diceGEN();
                DICE1 = diceValues[0];
                DICE2 = diceValues[1];

                //Sum of dice they rolled
                Player1diceSUM = DICE1+DICE2;

                System.out.println("The sum of the dice rolled by " + Player1  + " is "+ Player1diceSUM);
                */ 


                //
                System.out.println("CPU's turn to roll dice for the First Roll!");
              
                //generates the random values that player2 rolls
                int[] diceValues2 = diceGEN();
                DICE1 = diceValues2[0];
                DICE2 = diceValues2[1];
                
                //sum of dice they rolled
                Player2diceSUM = DICE1+DICE2;

                System.out.println("The sum of the dice rolled by CPU is "+ Player2diceSUM);
                ///Switch statements

                
                
                
                
                
                
                
                System.out.println("You're inside the else if statement");

                flag = false;




                //boot
                
            } 
            else 
            {
                System.out.println("you guys rolled the same");
                System.out.println("re rolling");
                //Boots them back to while statement
                flag = true;
            }

        }
        System.out.println("You're inside the AI computer method");

        
        
        ///Pot gets updated
        //pot = pot + Player1BET;
        ///print current pot?
        ///Print current balance?





        //System.out.println("Current pot is  "+ pot);
        ///If its true or not
        //boolean

        //
/*
            boolean flag23 = true;
            while (flag23) 
            {
            
      
            switch (Player1diceSUM) 
            {
                //Losing scenario
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
                //winning scenario
                case 7:
                case 11:
                    System.out.println("You win");
                    System.out.println(Player1 + " gets the pot!");
                    System.out.println(pot);
                    pot = Player1BAL;
                    break;
                default:
                    System.out.println("You rolled a point number " + Player1diceSUM +  " roll again!!");

                    break;
            }
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

        */




        








        









  






        System.out.println("Rolling again, you must roll the same point number or...");
        
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
        //System.out.println("Values in diceValues: " + DICE1 + " and " + DICE2);

        return diceValues;
        ///This generates a number everytime its called
        
    }




}

    
