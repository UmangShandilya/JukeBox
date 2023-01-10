package User;

import Home.HomeScreen;
import Connectivity.EstablishConnection;
import MusicPlayer.*;
import java.sql.*;
import java.util.Scanner;


public class SignIn
{
    Connection connect = EstablishConnection.establishConnection();
    PreparedStatement stmt;
    static Scanner scan = new Scanner(System.in);
    private static String userName;
    //The method takes user details as input.
    public static void signIn()
    {
        SignIn call = new SignIn();
        System.out.println("    JUKEBOX - SIGN IN");
        System.out.println("--------------------------");
        System.out.println("Enter Details For Sign In.");
        System.out.print("User Name : ");
        userName = scan.next();
        System.out.print("Password  : ");
        String password = scan.next();
        if(ValidateDetails.validateSignIn(userName,password, call.connect, call.stmt))
        {
            System.out.println("Welcome to JukeBox!");
            try
            {
                call.connect.close();
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println();
            MusicPlayerHomeScreen.displayMusicPlayer();
        }
        else
        {
            System.out.println("Invalid Log-in Credentials.");
            System.out.println();
            HomeScreen.showMainMenu();
        }
    }

    public String getUserName()
    {
        return userName;
    }
}
