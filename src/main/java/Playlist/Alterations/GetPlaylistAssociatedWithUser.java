package Playlist.Alterations;

import Connectivity.EstablishConnection;
import User.SignIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetPlaylistAssociatedWithUser
{
    public static ArrayList<PlaylistData> getPlaylist()
    {
        ArrayList<PlaylistData>playlistData = new ArrayList<>();
        SignIn call = new SignIn();
        String query = "select * from playlists where username = ?";
        Connection connect = EstablishConnection.establishConnection();

        try
        {
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1,call.getUserName());
            ResultSet data = stmt.executeQuery();
            while(data.next())
            {
                playlistData.add(new PlaylistData(data.getString(1), data.getString(2)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return playlistData;
    }
}
