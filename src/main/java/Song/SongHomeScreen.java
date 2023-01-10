package Song;

import Song.UserOperation.UserChoiceOnSongMenu;

public class SongHomeScreen
{
    public static void displaySongHomeScreen()
    {
        System.out.println(" JUKEBOX - MUSIC PLAYER");
        System.out.println("-------------------------");
        System.out.println("        SONGS");
        System.out.printf("%5s  %10s %n","1:","Show All Tracks");
        System.out.printf("%5s  %10s %n","2:","Search a Track");
        System.out.printf("%5s  %10s %n","3:","Home Screen");
        System.out.printf("%5s  %4s %n","4:","Quit");
        UserChoiceOnSongMenu.getChoice();
    }
}
