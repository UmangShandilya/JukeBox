package Song.UserOperation.PossibleException;

public class InvalidUserNameException extends Exception
{
    //Parameterised Constructor.
    public InvalidUserNameException(String message)
    {
        System.out.println(message);
    }
}
