import java.util.Scanner;

public class diceGAME {
    public static void main(String[] args) {

        Scanner scannerObj = new Scanner(System.in);
        ///Loop the user into trying again for the login screen
        boolean flag = true;
        ///User information
        String userNAME = "Admin";
        String password = "Admin1";
        while (flag) {
            //Processing if user enters the correct password or not
            System.out.println("Enter your username:");
            String inputuser = scannerObj.next();
            System.out.println("Enter your password:");
            String inputuser2 = scannerObj.next();

            if (inputuser.equals(userNAME) && inputuser2.equals(password)) {
                System.out.println("Correct!!");
                flag = false;
                
            }
            else
            {
                System.out.println("Incorrect, try again!");
            }

            
        }
        System.out.println("Hey");



        
    }
    
}
