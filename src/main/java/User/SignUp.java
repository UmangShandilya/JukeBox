package User;

import Connectivity.EstablishConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp
{
    static Scanner scan = new Scanner(System.in);
    Connection connect = EstablishConnection.establishConnection();
    PreparedStatement stmt;

    //The method takes user details as input.
    public static void signUp()
    {
        SignUp call = new SignUp();
        System.out.println("    JUKEBOX - SIGN UP");
        System.out.println("--------------------------");
        System.out.println("Enter Details For Sign Up.");
        System.out.print("Name : ");
        String name = scan.nextLine();
        System.out.print("User Name : ");
        String userName = scan.next();
        boolean check = true;
        while(check)
        {
            try
            {
                check = ValidateDetails.checkUserNameAvailablity(userName, call.connect, call.stmt);
                System.out.println("User Name Available.");
            }
            catch (Exception e)
            {
                System.out.println(e);
                System.out.print("User Name : ");
                userName = scan.next();
            }
        }

        System.out.print("Password  : ");
        String password = scan.next();

        call.insertInDatabase(name,userName,password);
    }

    //The method inserts new user into database.
    public void insertInDatabase(String name, String userName, String password)
    {
        String query = "insert into user values(?,?,?)";
        try
        {
            stmt = connect.prepareStatement(query);
            stmt.setString(1,name);
            stmt.setString(2,userName);
            stmt.setString(3,password);
            stmt.executeUpdate();
            System.out.println("Successfully Registered.");
            System.out.println("Directing To Login Screen.");
            connect.close();
            SignIn.signIn();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
