package Song.UserOperation;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;
import MusicPlayer.MusicPlayerHomeScreen;
import Song.*;
import Song.SearchOperations.SearchMenu;

import java.sql.*;
import java.util.Scanner;

public class UserChoiceOnSongMenu
{
    static Scanner scan = new Scanner(System.in);

    //The method takes user input and directs on the basis of choice.
    public static void getChoice()
    {
        System.out.print("Please enter your choice : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 4)
        {
            System.out.println("Invalid Choice!");
            System.out.print("Please enter your choice : ");
            userChoice = scan.nextInt();
        }
        switch (userChoice)
        {
            case 1 ->
            {
                Connection connect = EstablishConnection.establishConnection();
                String query = "select title,time_format(duration,'%i:%s'),artist,album from song where songID like 'S%' order by title" ;
                PreparedStatement stmt = null;
                try
                {
                    stmt = connect.prepareStatement(query);
                    DisplayTracks.displayTracks(stmt);
                    UserChoiceOnPlayOrExit.getChoice();
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
                SongHomeScreen.displaySongHomeScreen();
            }
            case 2 -> SearchMenu.displaySearchScreen();
            case 3 -> MusicPlayerHomeScreen.displayMusicPlayer();
            case 4 ->
            {
                System.out.println("Have a Good day! Keep Listening!");
                System.exit(0);
            }
        }

    }
}
