package Playlist;

import Playlist.UserOperation.UserChoiceOnPlaylistMenu;

public class PlaylistHomeScreen
{
    public static void displayPlaylistHomeScreen()
    {
        System.out.println(" JUKEBOX - MUSIC PLAYER");
        System.out.println("-------------------------");
        System.out.println("        PLAYLIST");
        System.out.printf("%5s  %10s %n","1:","Create A Playlist");
        System.out.printf("%5s  %10s %n","2:","Delete A Playlist");
        System.out.printf("%5s  %10s %n","3:","View All Playlist");
        System.out.printf("%5s  %10s %n","4:","Play A Playlist");
        System.out.printf("%5s  %10s %n","5:","Modify A Playlist");
        System.out.printf("%5s  %9s %n","6:","Main Menu");
        System.out.printf("%5s  %4s %n","7:","Quit");
        UserChoiceOnPlaylistMenu.getChoice();
    }
}
