package OurProject;
import java.util.Scanner;


public class TwoPlayerGAME 
{
    public void Player2Game() 
    {
       
        //System.out.println(diceValues[0]);
        //System.out.println(diceValues[1]);
        


        //Variabiles for AI game
        double pot = 0;
        double Player1BAL = 20;
        double Player1BET = 0;
        
        double Player2BAL = 20;
        double PLayer2BET = 0;
       // int DICE1 = diceValues[0];
       // int DICE2 = diceValues[1];
        
        ///whatever dice they rolled
        int Player1diceSUM = 0;
        int PlayerPOINT = 0;
        int Player2diceSUM = 0;
        final int RESET_POT_TO_ZERO = 0;
        Scanner scannerObj = new Scanner(System.in);
        ///let the player enter whatever username they want
        System.out.println("Enter the username you want");
        String Player1 = scannerObj.next();
        System.out.println("Your username is: " + Player1);
        System.out.println("Enter the username you want for Player 2");
        String Player2 = scannerObj.next();
        System.out.println("Your username is: " + Player2);
        //Player and CPU rolls dice to see who is the shooter(Shooter gets to roll dice)
        int Player1ShooterSum = 0;
        int Player2ShooterSum = 0;
        boolean flag = true;
        
        
        
        while (flag) 
        {
            int [] DiceValues = DiceGameThree.diceGEN();

            int DICE1 = DiceValues[0];
            int DICE2 = DiceValues[1];
            System.out.println(Player1 + " it is your turn to roll to see who is the shooter");
            
            Player1ShooterSum = DICE1 + DICE2;
            System.out.println(Player1 + " rolled " + Player1ShooterSum);
            System.out.println("It's now the "+Player2+" turn to roll to see who is the shooter");
            DiceValues = DiceGameThree.diceGEN();
            DICE1 = DiceValues[0];
            DICE2 = DiceValues[1];
            Player2ShooterSum = DICE1 + DICE2;
            System.out.println(Player2 + " rolled " + Player2ShooterSum);

            if (Player1ShooterSum > Player2ShooterSum)
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
                System.out.println(Player2+" must match " + Player1 +  "'s bet");

                PLayer2BET = Player1BET;
                System.out.println(Player2+"betted " + PLayer2BET);                                
                pot = pot + PLayer2BET;
                
                System.out.println("The total in the pot is now " + pot);

                
                //Update the balance for both players
                Player1BAL = Player1BAL - Player1BET;
                Player2BAL = Player2BAL - PLayer2BET;

                //Player 1 turn to roll dice
                System.out.println(Player1 + "'s turn to roll dice for the First Roll!");
                
                //Generates the random values that Player 1 rolls
                DiceValues = DiceGameThree.diceGEN();
                DICE1 = DiceValues[0];
                DICE2 = DiceValues[1];
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
                        System.out.println(Player1 + " lost!");
                        System.out.println(Player2+"gets the pot");

                        //add the pot to CPU balance
                        Player2BAL = Player2BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        //displays current values of the player and CPU
                        System.out.println(Player2 + " now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
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
                        System.out.println(Player2 + " now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
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
                        String player2userName = Player2;
                        //DiceGameThree diceGameThree = new DiceGameThree();
                        DiceGameThree.RE_roll(PlayerPOINT, Player1diceSUM, Player1, RESET_POT_TO_ZERO, Player1ShooterSum, RESET_POT_TO_ZERO, Player2ShooterSum, player2TURN, player2userName);
                        //RE_roll(PlayerPOINT2, Player2diceSUM, Player1, RESET_POT_TO_ZERO, Player1ShooterSum, RESET_POT_TO_ZERO, Player2diceSUM,player2TURN);
                        flag = false;
                        break;


                    
                        
                }
                
                System.out.println("You're inside the if statement");
                //This flag will have them get kicked out of the if statement
                //flag=false;
                //write ur code here.
                //Re-roll if they have point

                
            }
            else if (Player1ShooterSum < Player2ShooterSum) 
            {
                System.out.println(Player2 + " gets to shoot first!");


                
                //CPU bet goes here
                System.out.println(Player2 + " turn to make a bet!");
                System.out.println("Max number "+Player2+"can bet is " + Player2BAL);
                System.out.println(Player2+", how much would you like to bet?");
            

                
                //needs to be copy and pasted form the other if statement



                //pot functioning
                pot = pot + PLayer2BET;
                System.out.println(Player2+" betted " + PLayer2BET);
                System.out.println(Player1 + " must match" +Player2+"'s bet");

                Player1BET = PLayer2BET;
                System.out.println(Player1 + " betted " + Player1BET);
                pot = pot + Player1BET;
                
                System.out.println("The total in the pot is now " + pot);

                
                
                //Update the balance for both players
                Player1BAL = Player1BAL - Player1BET;
                Player2BAL = Player2BAL - PLayer2BET;

                DiceValues = DiceGameThree.diceGEN();
                DICE1 = DiceValues[0];
                DICE2 = DiceValues[1];

                //Sum of dice they rolled
                Player2diceSUM = DICE1+DICE2;

                switch (Player2diceSUM) 
                {
                    //Losing scenario
                    case 2:
                    case 3:
                    case 12:
                        System.out.println(Player2+" rolled " + Player2diceSUM);
                        System.out.println(Player2+" lost!");
                        System.out.println(Player1 + " gets the pot!");

                        //add the pot to player1 balance
                        Player1BAL = Player1BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        System.out.println(Player2 + " now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);
                        
                        
                        ///CPU gets money
                        //flag = false;
                        break;
                    //winning scenario
                    case 7:
                    case 11:
                        System.out.println(Player2+" rolled " + Player2diceSUM);
                        System.out.println(Player2+" lost!");
                        System.out.println(Player1 + " gets the pot!");

                        //add the pot to player1CPU balance
                        Player2BAL = Player2BAL + pot;

                        //reset pot back to 0 after someone wins or loses the pot
                        pot = RESET_POT_TO_ZERO;
                        
                        //displays current values of the player and CPU
                        System.out.println(Player2 + " now has " + Player2BAL + " and " + Player1 + " now has " + Player1BAL);

                        //flag = false;
                        break;
                    default:
                        // code to continue game if he rolled a point number
                        //once you roll a 7 after establishing a point number,
                        //shooter loses and cpu becomes shooter
                        //flag = true;
                        System.out.println(Player2+" rolled a point number " + Player2diceSUM  + " roll again!!");
                        int PlayerPOINT2 = Player2diceSUM;
                        //flag = false;
                        System.out.println("Your point is " + PlayerPOINT2+ "");
                        boolean player2TURN = false;
                        //RE_roll(PlayerPOINT2, Player2diceSUM, Player1, RESET_POT_TO_ZERO, Player1ShooterSum, RESET_POT_TO_ZERO, Player2diceSUM,player2TURN);
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
            





        

    }

    
}
