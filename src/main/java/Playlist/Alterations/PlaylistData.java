package Playlist.Alterations;

public class PlaylistData
{
    private String playlistName;
    private String userName;

    //Parameterised Constructor
    public PlaylistData(String playlistName, String userName)
    {
        this.playlistName = playlistName;
        this.userName = userName;
    }

    //Getters
    public String getPlaylistName()
    {
        return playlistName;
    }

    public String getUserName()
    {
        return userName;
    }
}
