package DataAccess;

import Connectivity.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;

public class AddingSongsToTable
{
    //The method reads and insert data in table on loading the player.
    public static void readAndInsertData()
    {
        Connection connect = EstablishConnection.establishConnection();
        String query1 = "truncate table song";
        String query2 = "insert into song values(?,?,?,?,?,?)";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\IT Studio\\NIIT\\Problem Solving and Computational Thinking using Java\\Java Practice Sets\\Month - August\\12th Aug - 19th Aug 2022\\jap_c7_s1_java_programming_project\\JukeBox\\src\\main\\resources\\Song.txt"));
             Statement statement = connect.createStatement();
             statement.executeUpdate(query1);
            String songInfo;
            while((songInfo = reader.readLine()) != null)
            {
                String[] info = songInfo.split(",");
                PreparedStatement stmt = connect.prepareStatement(query2);
                stmt.setString(1,info[0]);
                stmt.setString(2,info[1]);
                stmt.setTime(3,Time.valueOf(info[2]));
                stmt.setString(4,info[3]);
                stmt.setString(5,info[4]);
                stmt.setString(6,info[5]);
                stmt.executeUpdate();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
