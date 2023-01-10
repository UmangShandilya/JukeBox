package Playlist.PlayAPlaylist;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;
import MusicPlayer.MusicPlayerOperation.PlayerOperation;
import Playlist.Alterations.PlaylistContentData;
import Playlist.DisplayPlaylist.GlobalPlaylists;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayPlaylist
{
    static  Connection connect = EstablishConnection.establishConnection();
    static PreparedStatement stmt;
    public static void playAPlaylist() throws SQLException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Playlist Name to play its content : ");
        String playlistName = scan.nextLine();
        ArrayList<PlaylistContentData> playlistContentData = getContent(playlistName);
        String query = "select title,time_format(duration,'%i:%s'),artist from "+playlistName.replaceAll(" ","_");
        stmt = connect.prepareStatement(query);
        DisplayTracks.displayTracks(stmt);
        System.out.print("Enter a Track Name to play its content : ");
        String track = scan.nextLine();
        PlayerOperation.playerOperationOnPlayList(playlistContentData,track);
    }

    private static ArrayList<PlaylistContentData> getContent(String playlistName) throws SQLException {
        ArrayList<PlaylistContentData> playlistContentData = new ArrayList<>();
        String query = "select * from " + playlistName.replaceAll(" ","_");

            Statement stmt = connect.createStatement();
            ResultSet data = stmt.executeQuery(query);
            while(data.next())
            {
                playlistContentData.add(new PlaylistContentData(data.getString(1),data.getTime(2), data.getString(3), data.getString(4), data.getString(5)));
            }
        return playlistContentData;
    }
}
