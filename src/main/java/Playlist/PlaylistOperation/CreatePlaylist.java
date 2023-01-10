package Playlist.PlaylistOperation;

import Connectivity.EstablishConnection;
import Playlist.UserOperation.UserChoiceOnAlteration;
import User.SignIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreatePlaylist
{

    //The method creates new playlist.
    public static void newPlaylist()
    {
        Scanner scan = new Scanner(System.in);
        Connection connect = EstablishConnection.establishConnection();
        PreparedStatement stmt;
        SignIn call = new SignIn();

        System.out.print("Enter Playlist Name : ");
        String playlistName = scan.nextLine();

        String query1 = "insert into playlists values(?,?)";
        String query2 = "create table "+playlistName.replaceAll(" ","_")+"(title varchar(100) not null, duration time not null, artist varchar(50) not null, album varchar(100), filepath varchar(300) not null)";
        try
        {
            stmt = connect.prepareStatement(query1);
            stmt.setString(1,playlistName);
            stmt.setString(2, call.getUserName());
            stmt.executeUpdate();
            stmt = connect.prepareStatement(query2);
            stmt.execute();
            System.out.println("Playlist created successfully.");
            UserChoiceOnAlteration.getChoice();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
