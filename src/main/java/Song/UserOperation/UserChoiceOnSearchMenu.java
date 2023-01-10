package Song.UserOperation;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnSearchMenu
{
    static Scanner scan = new Scanner(System.in);
    static Connection connect = EstablishConnection.establishConnection();
    static PreparedStatement stmt;

    //The method takes user input and directs on the basis of choice.
    public static void getChoice() throws SQLException
    {
        System.out.print("Please enter your choice : ");
        int userChoice = Integer.parseInt(scan.nextLine());
        while(userChoice < 1 || userChoice > 4)
        {
            System.out.println("Invalid Choice!");
            System.out.print("Please enter your choice : ");
            userChoice = Integer.parseInt(scan.nextLine());
        }
        String query;
        switch (userChoice)
        {
            case 1 ->
            {
                System.out.print("Enter Track Name : ");
                String trackName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist,filepath from song where title = ? and songID like 'S%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1,trackName);
                DisplayTracks.displayTracks(stmt);
                UserChoiceOnPlayOrExit.getChoice();
            }
            case 2 ->
            {
                System.out.print("Enter Artist Name : ");
                String artistName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist from song where artist = ? and songID like 'S%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1, artistName);
                DisplayTracks.displayTracks(stmt);
                UserChoiceOnPlayOrExit.getChoice();
            }
            case 3 ->
            {
                System.out.print("Enter Track Name : ");
                String trackName = scan.nextLine();
                System.out.print("Enter Artist Name : ");
                String artistName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist from song where title = ? and artist = ? and songID like 'S%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1, trackName);
                stmt.setString(2, artistName);
                DisplayTracks.displayTracks(stmt);
                UserChoiceOnPlayOrExit.getChoice();
            }
            case 4 ->
            {
                System.out.print("Enter Album Name : ");
                String albumName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist from song where album = ? and songID like 'S%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1, albumName);
                DisplayTracks.displayTracks(stmt);
                UserChoiceOnPlayOrExit.getChoice();
            }
        }
        connect.close();
    }
}
