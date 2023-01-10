package Playlist.PlaylistOperation;

import Connectivity.EstablishConnection;
import Playlist.Alterations.GetPlaylistAssociatedWithUser;
import Playlist.Alterations.PlaylistData;
import Playlist.PlaylistHomeScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class DeletePlaylist
{
    static Connection connect = EstablishConnection.establishConnection();
    static PreparedStatement stmt;
    static Scanner scan = new Scanner(System.in);
    //The method deletes a playlist based on playlist name.
    public static void deletePlaylist()
    {
        ArrayList<PlaylistData> playlistData = GetPlaylistAssociatedWithUser.getPlaylist();
        System.out.print("Enter Playlist Name : ");
        String playlistName = scan.nextLine();
        if(playlistData.stream().anyMatch((title) -> title.getPlaylistName().equalsIgnoreCase(playlistName)))
        {
            String query1 = "drop table "+playlistName.replaceAll(" ","_");
            String query2 = "delete from playlists where playlist_name = ?";
            try
            {
                stmt = connect.prepareStatement(query1);
                stmt.execute();
                stmt = connect.prepareStatement(query2);
                stmt.setString(1,playlistName);
                stmt.executeUpdate();
                System.out.println("Playlist Deleted Successfully.");
                PlaylistHomeScreen.displayPlaylistHomeScreen();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Sorry! You can't delete this playlist.");
            PlaylistHomeScreen.displayPlaylistHomeScreen();
        }

    }
}
