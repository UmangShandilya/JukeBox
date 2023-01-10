package Playlist.UserOperation;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;
import Playlist.Alterations.AddATrack;
import Playlist.Alterations.DeleteATrack;
import Playlist.DisplayPlaylist.GlobalPlaylists;
import Playlist.PlaylistHomeScreen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnAlteration
{
    //The method gets user for altering playlists.
        public static void getChoice()
        {
            Connection connect = EstablishConnection.establishConnection();
            PreparedStatement stmt;
            Scanner scan = new Scanner(System.in);
            System.out.println("       USER CHOICE");
            System.out.println("-------------------------");
            System.out.println("        PLAYLIST");
            System.out.printf("%5s  %10s %n","1:","Add a track");
            System.out.printf("%5s  %10s %n","2:","Delete a track");
            System.out.printf("%5s  %10s %n","3:","Playlist Menu");
            System.out.printf("%5s  %4s %n","4:","Quit");

            System.out.print("Enter your choice : ");
            int choice = Integer.parseInt(scan.nextLine());

            switch(choice)
            {
                case 1 ->
                {
                    String query = "select title,time_format(duration,'%i:%s'),artist from song order by title";
                    try
                    {
                        stmt = connect.prepareStatement(query);
                        DisplayTracks.displayTracks(stmt);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    char addChoice;
                    System.out.print("Enter Playlist Name : ");
                    String playlistName = scan.nextLine();
                    do
                    {
                        System.out.print("Enter Track Name : ");
                        String track = scan.nextLine();

                        AddATrack.addTrackIntoPlaylist(playlistName,track);
                        System.out.print("Do you want to add more tracks [Y/N]: ");
                        addChoice = scan.nextLine().toUpperCase().charAt(0);
                    }
                    while(addChoice == 'Y');
                    PlaylistHomeScreen.displayPlaylistHomeScreen();
                }
                case 2 ->
                {
                    System.out.print("Enter Playlist Name : ");
                    String playlistName = scan.nextLine();
                    String query = "select title,time_format(duration,'%i:%s'),artist from "+playlistName.replaceAll(" ","_");
                    try
                    {
                        stmt = connect.prepareStatement(query);
                        DisplayTracks.displayTracks(stmt);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    char addChoice;
                    do
                    {
                        System.out.print("Enter Track Name : ");
                        String track = scan.nextLine();
                        DeleteATrack.deleteTrackIntoPlaylist(playlistName,track);
                        System.out.print("Do you want to delete more tracks [Y/N]: ");
                        addChoice = scan.nextLine().toUpperCase().charAt(0);
                    }
                    while(addChoice == 'Y');
                    PlaylistHomeScreen.displayPlaylistHomeScreen();
                }
                case 3 -> PlaylistHomeScreen.displayPlaylistHomeScreen();
                case 4 ->
                {
                    System.out.println("Have a Good day! Keep Listening!");
                    System.exit(0);
                }
            }
        }
}
