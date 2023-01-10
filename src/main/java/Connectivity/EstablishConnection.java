package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection
{
    static Connection connect;
    public static Connection establishConnection()
    {
        String user = "root";
        String password = "Innovative@1";
        String url = "jdbc:mysql://localhost:3306/JukeBox";
        try
        {
            connect = DriverManager.getConnection(url,user,password);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return connect;
    }
}
