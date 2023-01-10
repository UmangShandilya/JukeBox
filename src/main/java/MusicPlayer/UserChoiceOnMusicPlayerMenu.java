package MusicPlayer;

import Playlist.PlaylistHomeScreen;
import Podcast.PodcastHomeScreen;
import Song.SongHomeScreen;

import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnMusicPlayerMenu
{
    static Scanner scan = new Scanner(System.in);
    public static void getChoice()
    {
        System.out.print("Please enter your choice : ");
        int userChoice = scan.nextInt();
        while(userChoice < 1 || userChoice > 5)
        {
            System.out.println("Invalid Choice!");
            System.out.print("Please enter your choice : ");
            userChoice = scan.nextInt();
        }
        switch (userChoice)
        {
            case 1 -> SongHomeScreen.displaySongHomeScreen();
            case 2 -> PlaylistHomeScreen.displayPlaylistHomeScreen();
            case 3 -> PodcastHomeScreen.displaySongHomeScreen();
            case 4 -> System.exit(0);
        }

    }
}
