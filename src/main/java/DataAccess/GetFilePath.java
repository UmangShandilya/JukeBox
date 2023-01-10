package DataAccess;

import Connectivity.EstablishConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetFilePath
{
    public static String getFilePath(String trackName)
    {
        Connection connect = EstablishConnection.establishConnection();
        String filePath = "";
        String query = "select title,time_format(duration,'%i:%s'),artist,filepath from song where title = ? ";
        PreparedStatement stmt = null;
        try
        {
            stmt = connect.prepareStatement(query);
            stmt.setString(1,trackName);
            ResultSet data = stmt.executeQuery();

            if(!data.next())
            {
                System.out.println("Oops! No tracks found.");
            }

            else
            {
                System.out.println("Now Playing : ");
                System.out.printf("| %-20s | %-10s | %-17s |%n", "Title", "Duration", "Artist");
                System.out.println("|----------------------|------------|-------------------|");
                do
                {
                    System.out.printf("| %-20s | %-10s | %-17s |%n", data.getString(1), data.getString(2), data.getString(3));
                    filePath = data.getString(4);
                }
                while(data.next());
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return filePath;
    }

}
