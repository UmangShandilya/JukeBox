package Playlist.Alterations;

import java.sql.Time;

public class PlaylistContentData
{
    private String title;
    private Time duration;
    private String artist;
    private String album;
    private String filepath;

    //Parameterised Constructor
    public PlaylistContentData(String title, Time duration, String artist, String album, String filepath) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.filepath = filepath;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public Time getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getFilepath() {
        return filepath;
    }
}
