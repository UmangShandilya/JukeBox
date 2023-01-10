package MusicPlayer.MusicPlayerOperation;

import MusicPlayer.MusicPlayerHomeScreen;
import Playlist.Alterations.PlaylistContentData;
import Playlist.PlaylistHomeScreen;
import Song.UserOperation.UserChoiceOnPlayOrExit;

import javax.sound.sampled.*;
import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerOperation
{
    static Scanner scan = new Scanner(System.in);
    //The method plays a track.
    public static void playerOperation(String filePath)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip newClip = AudioSystem.getClip();
            newClip.open(audioInputStream);
            newClip.start();
            System.out.println("P: Play, S: Stop, R:Reset, Q: Quit");
            char responseOfUser = scan.next().toUpperCase().charAt(0);
            while(responseOfUser != 'Q')
            {
                    switch (responseOfUser)
                    {
                        case 'P' ->
                                newClip.start();
                        case 'S' ->
                                newClip.stop();
                        case 'R' ->
                                newClip.setMicrosecondPosition(0);
                    }
                    responseOfUser = scan.next().toUpperCase().charAt(0);
            }
            newClip.close();

        }
        catch (Exception e)
        {
            System.out.println("Invalid Information");
            MusicPlayerHomeScreen.displayMusicPlayer();
        }
        UserChoiceOnPlayOrExit.getChoice();
    }

    //The method plays a track in playlist.
    public static void playerOperationOnPlayList(ArrayList<PlaylistContentData> playlistContentData, String track)
    {
        String filePath = "";
        int index = 0;
        PlaylistContentData trackInfo = null;
        for(PlaylistContentData data : playlistContentData)
        {
            if(data.getTitle().equalsIgnoreCase(track))
            {
                filePath = data.getFilepath();
                index = playlistContentData.indexOf(data);
                trackInfo = data;
            }
        }
        if(trackInfo == null)
            System.out.println("Oops! The entered song does not exist in playlist :" + track);
        else
        {
            System.out.println("Now Playing : ");
            System.out.printf("| %-48s | %-10s | %-17s |%n", "Title", "Duration", "Artist");
            System.out.println("|--------------------------------------------------|------------|-------------------|");
            Format f = new SimpleDateFormat("mm:ss");
            System.out.printf("| %-48s | %-10s | %-17s |%n", trackInfo.getTitle(), f.format(trackInfo.getDuration()), trackInfo.getArtist());
            Clip newClip = null;
            try
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
                newClip = AudioSystem.getClip();
                newClip.open(audioInputStream);
                newClip.start();
                System.out.println("P: Play, S: Stop, R:Reset, Q: Quit, N: Next, E: Previous");
                char responseOfUser = scan.next().toUpperCase().charAt(0);

                while(responseOfUser != 'Q')
                {
                    switch (responseOfUser)
                    {
                        case 'P' -> newClip.start();
                        case 'S' -> newClip.stop();
                        case 'R' -> newClip.setMicrosecondPosition(0);
                        case 'N' ->
                        {
                            index++;
                            PlaylistContentData obj = playlistContentData.get(index);
                            newClip.close();
                            playerOperationOnPlayList(playlistContentData, obj.getTitle());
                        }
                        case 'E' ->
                        {
                            index--;
                            PlaylistContentData obj = playlistContentData.get(index);
                            newClip.close();
                            playerOperationOnPlayList(playlistContentData, obj.getTitle());
                        }

                    }
                    responseOfUser = scan.next().toUpperCase().charAt(0);
                }
                newClip.close();
            }
            catch (IndexOutOfBoundsException e)
            {
                if(index == -1)
                {
                    index = playlistContentData.size()-1;
                    PlaylistContentData obj = playlistContentData.get(index);
                    newClip.close();
                    playerOperationOnPlayList(playlistContentData, obj.getTitle());
                }
                else
                {
                    index = 0;
                    PlaylistContentData obj = playlistContentData.get(index);
                    newClip.close();
                    playerOperationOnPlayList(playlistContentData, obj.getTitle());
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid Information");
                throw new RuntimeException(e);
            }

        }
        PlaylistHomeScreen.displayPlaylistHomeScreen();
    }
}

