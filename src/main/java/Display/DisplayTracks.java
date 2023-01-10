package Display;

import MusicPlayer.MusicPlayerHomeScreen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayTracks
{

    //The method displays all the tracks.
    public static void displayTracks(PreparedStatement stmt) throws SQLException
    {
        ResultSet data = stmt.executeQuery();
        System.out.printf("| %-48s | %-10s | %-17s |%n", "Title", "Duration", "Artist");
        System.out.println("|--------------------------------------------------|------------|-------------------|");
        if(!data.next())
        {
            System.out.println("Oops! No tracks found.");
            MusicPlayerHomeScreen.displayMusicPlayer();
        }
        else
        {
            do
            {
                System.out.printf("| %-48s | %-10s | %-17s |%n", data.getString(1), data.getString(2), data.getString(3));
            }
            while(data.next());
        }
    }
}
