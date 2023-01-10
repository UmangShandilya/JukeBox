package Podcast.SearchOperations;


import Podcast.UserOperation.UserChoiceOnSearchMenu;

import java.sql.SQLException;

public class SearchMenu
{
    public static void displaySearchScreen() throws SQLException
    {
        System.out.println("        SEARCH");
        System.out.println("-------------------------");
        System.out.println("        SONGS");
        System.out.printf("%5s  %10s %n","1:","Search by Podcast ");
        System.out.printf("%5s  %10s %n","2:","Search by Artist");
        System.out.printf("%5s  %10s %n","3:","Search by Track and Artist");
        UserChoiceOnSearchMenu.getChoice();
    }
}
