package Home;
import User.*;
import java.util.Scanner;

//The method gets user choice and directs towards respective domain.
public class UserChoiceOnSigning
{
    static Scanner scan = new Scanner(System.in);
    public static void getChoice()
    {
        System.out.print("Please enter your choice of Signing : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 2)
        {
            System.out.println("Invalid Signing Choice!");
            System.out.println("Please enter your choice of Signing : ");
            userChoice = scan.nextInt();
        }
        if(userChoice == 1)
            SignUp.signUp();
        else
            SignIn.signIn();
    }
}
