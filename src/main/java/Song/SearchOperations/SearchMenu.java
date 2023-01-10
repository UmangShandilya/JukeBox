package Song.SearchOperations;

import Song.UserOperation.UserChoiceOnSearchMenu;

import java.sql.SQLException;

public class SearchMenu
{
    public static void displaySearchScreen()
    {
        System.out.println("        SEARCH");
        System.out.println("-------------------------");
        System.out.println("        SONGS");
        System.out.printf("%5s  %10s %n","1:","Search by Track ");
        System.out.printf("%5s  %10s %n","2:","Search by Artist");
        System.out.printf("%5s  %10s %n","3:","Search by Track and Artist");
        System.out.printf("%5s  %10s %n","4:","Search by Album");
        try
        {
            UserChoiceOnSearchMenu.getChoice();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
