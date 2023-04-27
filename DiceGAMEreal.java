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
        int PlayerPOINT = 0;
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
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
                        ///CPU gets money
                        flag = false;
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
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                     //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println("You rolled a point number " + Player1diceSUM +  " roll again!!");
                        PlayerPOINT = Player1diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT+ "");
                         boolean player2TURN = true;

                        RE_roll(PlayerPOINT, CPUShooterSum, Player1, CPUShooterSum, CPUShooterSum, CPUShooterSum, CPUShooterSum,player2TURN);                        
                        flag = false;
                        break;


                    
                        
                }
                
                System.out.println("You're inside the if statement");
                //This flag will have them get kicked out of the if statement
                //flag=false;
                //write ur code here.
                //Re-roll if they have point

                
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

                int[] diceValues = diceGEN();
                DICE1 = diceValues[0];
                DICE2 = diceValues[1];

                //Sum of dice they rolled
                Player2diceSUM = DICE1+DICE2;

                switch (Player2diceSUM) 
                {
                    //Losing scenario
                    case 2:
                    case 3:
                    case 12:
                        System.out.println("CPU rolled " + Player2diceSUM);
                        System.out.println("CPU lost!");
                        System.out.println(Player1 + " gets the pot!");

                        //add the pot to player1 balance
                        Player1BAL = Player1BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
                        ///CPU gets money
                        //flag = false;
                        break;
                    //winning scenario
                    case 7:
                    case 11:
                        System.out.println("CPU rolled " + Player2diceSUM);
                        System.out.println("CPU wins!");
                        System.out.println("CPU gets the pot");

                        //add the pot to player1CPU balance
                        Player2BAL = Player2BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);

                        //flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                        //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println("CPU rolled a point number " + Player2diceSUM  + " roll again!!");
                        int PlayerPOINT2 = Player2diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT2+ "");
                        boolean player2TURN = false;
                        RE_roll(PlayerPOINT2, Player2diceSUM, Player1, RESET_POT_TO_ZERO, Player1ShooterSum, RESET_POT_TO_ZERO, Player2diceSUM,player2TURN);
                        flag = false;
                        break;


                    
                        
                }


                ///Switch statements from player 1 First roll code (not finished)
                
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



        //System.out.println("Rolling again, you must roll the same point number or...");
        
    }

    public static void TwoPlayerGame() 
    {
        System.out.println("Test23");
        

        double pot = 0;
        double Player1BAL = 20;
        double Player1BET = 0;
        
        double Player2BAL = 20;
        double PLayer2BET = 0;
        int DICE1 = 6;
        int DICE2 = 6;
        
        ///whatever dice they rolled
        int Player1diceSUM = 0;
        int PlayerPOINT = 0;
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
        System.out.println("Enter the username you want for player 2: ");
        String Player2 = scannerObj.next();
        System.out.println("Your username is: " + Player2);

        //Player and CPU rolls dice to see who is the shooter(Shooter gets to roll dice)
        int Player1ShooterSum = 0;
        int CPUShooterSum = 0;
        boolean flag = true;


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
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
                        ///CPU gets money
                        flag = false;
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
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                     //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println("You rolled a point number " + Player1diceSUM +  " roll again!!");
                        PlayerPOINT = Player1diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT+ "");
                         boolean player2TURN = true;

                        RE_roll(PlayerPOINT, CPUShooterSum, Player1, CPUShooterSum, CPUShooterSum, CPUShooterSum, CPUShooterSum,player2TURN);                        
                        flag = false;
                        break;


                    
                        
                }
                
                System.out.println("You're inside the if statement");
                //This flag will have them get kicked out of the if statement
                //flag=false;
                //write ur code here.
                //Re-roll if they have point

                
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
                double CPUbet = Math.round((Math.random() * (maxCPUbet  - minCPUbet + 0.01) + minCPUbet) * 100) / 100;
                
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

                int[] diceValues = diceGEN();
                DICE1 = diceValues[0];
                DICE2 = diceValues[1];

                //Sum of dice they rolled
                Player2diceSUM = DICE1+DICE2;

                switch (Player2diceSUM) 
                {
                    //Losing scenario
                    case 2:
                    case 3:
                    case 12:
                        System.out.println("CPU rolled " + Player2diceSUM);
                        System.out.println("CPU lost!");
                        System.out.println(Player1 + " gets the pot!");

                        //add the pot to player1 balance
                        Player1BAL = Player1BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
                        ///CPU gets money
                        //flag = false;
                        break;
                    //winning scenario
                    case 7:
                    case 11:
                        System.out.println("CPU rolled " + Player2diceSUM);
                        System.out.println("CPU wins!");
                        System.out.println("CPU gets the pot");

                        //add the pot to player1CPU balance
                        Player2BAL = Player2BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        //displays current values of the player and CPU
                        System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);

                        //flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                        //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println("CPU rolled a point number " + Player2diceSUM  + " roll again!!");
                        int PlayerPOINT2 = Player2diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT2+ "");
                        boolean player2TURN = false;
                        RE_roll(PlayerPOINT2, Player2diceSUM, Player1, RESET_POT_TO_ZERO, Player1ShooterSum, RESET_POT_TO_ZERO, Player2diceSUM,player2TURN);
                        flag = false;
                        break;


                    
                        
                }


                ///Switch statements from player 1 First roll code (not finished)
                
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

        
        
    }/// end of Ai computer game method

    public static void HighScore() 
    {
        ////For this we need to get Player 1 user name from
        /// AIcomputerGame and then print the content into the file
        ///ex John score is 20
        // or have player store their score under
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

    public static void RE_roll(int PlayerPOINT,int Player1diceSUM,String Player1, int pot, int Player1BAL, int RESET_POT_TO_ZERO, int Player2BAL,boolean player2TURN) 
    {
        int DICE1 = 6;
        int DICE2 = 6;
        System.out.println(PlayerPOINT);
        boolean flag = true;
        boolean playerT = true;
        //need to verify if its player 2 turn
        //cpu turn
        if(player2TURN == false)
        {

            // Have to do this because PLayer2Dicesum is passed on as Player1DiceSum in re_roll method due to issues
            int Player2diceSUM = 0;
            int PlayerPOINT2 = 0;
            Player1diceSUM = Player2diceSUM;
            Player2diceSUM = PlayerPOINT2;
            
            System.out.println("player2TURN is false");
            
        while (playerT) 
        {
            int[] diceValues34 = diceGEN();
            DICE1 = diceValues34[0];
            DICE2 = diceValues34[1];
            Player2diceSUM = DICE1+DICE2;
            
            System.out.println("CPU rolled " + Player2diceSUM);
            //If they roll it first, if not they lose
            if (Player2diceSUM == PlayerPOINT) 
            {
                System.out.println("CPU rolled " + Player2diceSUM);
                System.out.println("CPU win!");
                System.out.println("CPU gets the pot!");

                //add the pot to player1 balance
                Player2BAL = Player2BAL + pot;

                //reset pot back to 0 after someone wins or loses the pot
                pot = RESET_POT_TO_ZERO;
                
                //displays current values of the player and CPU
                System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                
                
                //PLayerT exit
                playerT = false;
                
                flag = false;   
            } 
            else if (Player2diceSUM == 7)
            {
                System.out.println("CPU lost the pot and now CPU is the shooter");



                playerT = false;
                
                
                
            }
            
        }
        //Player 1 turn

        }
        if (player2TURN == true) 
        {

            System.out.println("player2TURN is true");

            while (playerT) 
            {
                int[] diceValues34 = diceGEN();
                DICE1 = diceValues34[0];
                DICE2 = diceValues34[1];
                Player1diceSUM = DICE1+DICE2;
                
                System.out.println("CPU rolled " + Player1diceSUM);
                //If they roll it first, if not they lose
                if (Player1diceSUM == PlayerPOINT) 
                {
                    System.out.println( Player1 + " rolled " + Player1diceSUM);
                    System.out.println("You win!");
                    System.out.println( Player1 + " gets the pot!");
    
                    //add the pot to player1 balance
                    Player1BAL = Player1BAL + pot;
    
                    //reset pot back to 0 after someone wins or loses the pot
                    pot = RESET_POT_TO_ZERO;
                    
                    //displays current values of the player and CPU
                    System.out.println("CPU now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                    
                    
                    //PLayerT exit
                    playerT = false;
                    
                    flag = false;   
                } 
                else if (Player1diceSUM == 7)
                {
                    System.out.println("CPU lost the pot and now CPU is the shooter");
    
                    playerT = false;
                    
                    
                    
                }
            }
                
            
            
        }
        

    } ///// end of reroll method





}

    
