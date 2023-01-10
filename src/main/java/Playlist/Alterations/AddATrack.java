package Playlist.Alterations;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.util.ArrayList;

public class AddATrack
{
    public static void addTrackIntoPlaylist(String playlistName,String track)
    {
        Connection connect = EstablishConnection.establishConnection();
        ArrayList<PlaylistData>playlistData = GetPlaylistAssociatedWithUser.getPlaylist();
        if(playlistData.stream().anyMatch((title) -> title.getPlaylistName().equalsIgnoreCase(playlistName)))
        {
            String query = "insert into "+playlistName.replaceAll(" ","_")+" values(?,?,?,?,?)";
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("D:\\IT Studio\\NIIT\\Problem Solving and Computational Thinking using Java\\Java Practice Sets\\Month - August\\12th Aug - 19th Aug 2022\\jap_c7_s1_java_programming_project\\JukeBox\\src\\main\\resources\\Song.txt"));
                PreparedStatement statement = connect.prepareStatement(query);
                String songInfo;
                while((songInfo = reader.readLine()) != null)
                {
                    String[] info = songInfo.split(",");
                    if(track.equalsIgnoreCase(info[1]))
                    {
                        statement.setString(1,info[1]);
                        statement.setTime(2, Time.valueOf(info[2]));
                        statement.setString(3,info[3]);
                        statement.setString(4,info[4]);
                        statement.setString(5,info[5]);
                        statement.executeUpdate();
                        System.out.println("Song added to playlist : "+playlistName);
                        String query2 = "select title,time_format(duration,'%i:%s'),artist from "+playlistName.replaceAll(" ","_");
                        statement = connect.prepareStatement(query2);
                        DisplayTracks.displayTracks(statement);
                    }

                }
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
