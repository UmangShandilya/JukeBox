package Playlist.DisplayPlaylist;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;
import Playlist.PlaylistHomeScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GlobalPlaylists
{
    public static void displayAllPlaylists()
    {
        Connection connect = EstablishConnection.establishConnection();
        Scanner scan = new Scanner(System.in);
        String query = "select * from playlists";
        try
        {
            PreparedStatement stmt = connect.prepareStatement(query);
            ResultSet data = stmt.executeQuery();
            System.out.printf("| %-20s | %-10s |%n", "Playlist Title", "User Name");
            System.out.println("|----------------------|------------|");
            while(data.next())
            {
                System.out.printf("| %-20s | %-10s |%n", data.getString(1), data.getString(2));
            }
            System.out.println();
            System.out.print("Do you want to view tracks [Y/N]: ");
            char addChoice = scan.nextLine().toUpperCase().charAt(0);
            if(addChoice == 'Y')
            {
                System.out.print("Enter a Playlist Name to view its content : ");
                String playlistName = scan.nextLine();
                String query2 = "select title,time_format(duration,'%i:%s'),artist from "+playlistName.replaceAll(" ","_");
                stmt = connect.prepareStatement(query2);
                DisplayTracks.displayTracks(stmt);
            }
            PlaylistHomeScreen.displayPlaylistHomeScreen();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
