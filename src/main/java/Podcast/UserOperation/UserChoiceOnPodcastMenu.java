package Podcast.UserOperation;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;
import MusicPlayer.MusicPlayerHomeScreen;
import Podcast.PodcastHomeScreen;
import Podcast.SearchOperations.SearchMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnPodcastMenu
{
    static Scanner scan = new Scanner(System.in);

    //The method takes user input and directs on the basis of choice.
    public static void getChoice() throws SQLException
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
                String query = "select title,time_format(duration,'%i:%s'),artist from song where songID like 'P%' order by title" ;
                PreparedStatement stmt = connect.prepareStatement(query);
                DisplayTracks.displayTracks(stmt);
                connect.close();
                PodcastHomeScreen.displaySongHomeScreen();
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
