package Playlist.Alterations;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DeleteATrack
{
    public static void deleteTrackIntoPlaylist(String playlistName,String track)
    {
        Connection connect = EstablishConnection.establishConnection();
        ArrayList<PlaylistData> playlistData = GetPlaylistAssociatedWithUser.getPlaylist();
        if(playlistData.stream().anyMatch((title) -> title.getPlaylistName().equalsIgnoreCase(playlistName)))
        {
            String query = "delete from "+playlistName.replaceAll(" ","_")+" where title = ?";
            try
            {
                PreparedStatement statement = connect.prepareStatement(query);
                statement.setString(1,track);
                statement.executeUpdate();
                System.out.println("Track deleted successfully from playlist : " + playlistName);
                String query2 = "select title,time_format(duration,'%i:%s'),artist from "+playlistName.replaceAll(" ","_");
                statement = connect.prepareStatement(query2);
                DisplayTracks.displayTracks(statement);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Sorry! You can't alter this playlist.");
        }
    }
}
