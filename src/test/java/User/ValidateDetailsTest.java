package User;
import static org.junit.jupiter.api.Assertions.*;
import Connectivity.EstablishConnection;
import Song.UserOperation.PossibleException.InvalidUserNameException;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ValidateDetailsTest
{
    Connection connect = EstablishConnection.establishConnection();
    PreparedStatement stmt;

    @Test
    public void isUserNameAvailableGivenUserNamePresent()
    {
        assertThrows(InvalidUserNameException.class,()->ValidateDetails.checkUserNameAvailablity("uruz",connect,stmt));
    }

    @Test
    public void isValidUserGivenValidDetails()
    {
        assertTrue(ValidateDetails.validateSignIn("uruz","Innovative@1",connect,stmt));

    }
    @Test
    public void isValidUserGivenInValidPassword()
    {
        assertFalse(ValidateDetails.validateSignIn("uruz","innovative@1",connect,stmt));

    }
    @Test
    public void isValidUserGivenInvalidDetails()
    {
        assertFalse(ValidateDetails.validateSignIn("sam","Ihgtd",connect,stmt));
    }

}