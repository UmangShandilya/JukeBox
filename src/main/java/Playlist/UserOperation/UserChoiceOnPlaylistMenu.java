package Playlist.UserOperation;

import MusicPlayer.MusicPlayerHomeScreen;
import Playlist.DisplayPlaylist.GlobalPlaylists;
import Playlist.PlayAPlaylist.PlayPlaylist;
import Playlist.PlaylistHomeScreen;
import Playlist.PlaylistOperation.DeletePlaylist;
import Playlist.PlaylistOperation.CreatePlaylist;

import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnPlaylistMenu
{
    static Scanner scan = new Scanner(System.in);

    //The method takes user input and directs on the basis of choice.
    public static void getChoice()
    {
        System.out.print("Please enter your choice : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 7)
        {
            System.out.println("Invalid Choice!");
            System.out.print("Please enter your choice : ");
            userChoice = scan.nextInt();
        }
        switch (userChoice)
        {
            case 1 -> CreatePlaylist.newPlaylist();
            case 2 -> DeletePlaylist.deletePlaylist();
            case 3 -> GlobalPlaylists.displayAllPlaylists();
            case 4 ->
            {
                try {PlayPlaylist.playAPlaylist();}
                catch (SQLException e)
                {
                    System.out.println("Invalid Information");
                    PlaylistHomeScreen.displayPlaylistHomeScreen();
                }
            }
            case 5 -> UserChoiceOnAlteration.getChoice();
            case 6 -> MusicPlayerHomeScreen.displayMusicPlayer();
            case 7 ->
            {
                System.out.println("Have a Good day! Keep Listening!");
                System.exit(0);
            }
        }

    }
}
