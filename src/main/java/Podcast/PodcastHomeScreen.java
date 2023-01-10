package Podcast;


import Podcast.UserOperation.UserChoiceOnPodcastMenu;

import java.sql.SQLException;

public class PodcastHomeScreen
{
    public static void displaySongHomeScreen()
    {
        System.out.println(" JUKEBOX - MUSIC PLAYER");
        System.out.println("-------------------------");
        System.out.println("        PODCAST");
        System.out.printf("%5s  %10s %n","1:","Show All Podcast");
        System.out.printf("%5s  %10s %n","2:","Search a Podcast");
        System.out.printf("%5s  %10s %n","3:","Home Screen");
        System.out.printf("%5s  %4s %n","4:","Quit");
        try
        {
            UserChoiceOnPodcastMenu.getChoice();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
