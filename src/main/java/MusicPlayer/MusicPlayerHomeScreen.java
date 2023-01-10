package MusicPlayer;
import DataAccess.AddingSongsToTable;

import java.sql.SQLException;

public class MusicPlayerHomeScreen
{
    public static void displayMusicPlayer()
    {
        AddingSongsToTable.readAndInsertData();
        System.out.println(" JUKEBOX - MUSIC PLAYER");
        System.out.println("-------------------------");
        System.out.printf("%5s  %10s %n","1:","SONG");
        System.out.printf("%5s  %14s %n","2:","PLAYLIST");
        System.out.printf("%5s  %13s %n","3:","PODCAST");
        System.out.printf("%5s  %10s %n","4:","QUIT");
        UserChoiceOnMusicPlayerMenu.getChoice();
    }
}
