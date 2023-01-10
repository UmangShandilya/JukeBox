package User;

import Song.UserOperation.PossibleException.InvalidUserNameException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValidateDetails
{
    //The method checks for appropriate username.
    public static boolean checkUserNameAvailablity(String userName, Connection connect, PreparedStatement stmt)throws InvalidUserNameException
    {
        String query = "select username from user where username = ?";
        try
        {
            stmt = connect.prepareStatement(query);
            stmt.setString(1,userName);
            ResultSet data = stmt.executeQuery();
            if(!data.next())
                return false;
            else
                throw new InvalidUserNameException("User name already exists! Try with a new user name.");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //The method validates the sign-in information.
    public static boolean validateSignIn(String userName, String password,Connection connect, PreparedStatement stmt)
    {
        String query = "select password from user where username = ?";
        try
        {
            ArrayList<User> users = new ArrayList<>();
            stmt = connect.prepareStatement(query);
            stmt.setString(1,userName);
            ResultSet data = stmt.executeQuery();
            if(!data.next())
            {
                return false;
            }
            else
            {
                do
                {
                    users.add(new User(data.getString(1)));
                }
                while(data.next());
            }
            for(User obj : users)
            {
                if(obj.getPassword().equals(password))
                    return true;
                else
                    return false;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return false;
    }


}
