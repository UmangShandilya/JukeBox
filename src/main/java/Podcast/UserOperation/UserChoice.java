package Podcast.UserOperation;

import DataAccess.GetFilePath;
import MusicPlayer.MusicPlayerOperation.PlayerOperation;
import Podcast.PodcastHomeScreen;

import java.util.Scanner;

public class UserChoice
{
    static Scanner choiceIn = new Scanner(System.in);
    //The method takes user input and directs on the basis of choice.
    public static void getChoice()
    {
        System.out.print("Do you want to play a track?[Y/N] : ");
        char userChoice = choiceIn.nextLine().toUpperCase().charAt(0);
        switch (userChoice)
        {
            case 'Y' ->
            {
                System.out.print("Enter Podcast Name : ");
                String podcastName = choiceIn.nextLine();
                String filePath = GetFilePath.getFilePath(podcastName);
                PlayerOperation.playerOperation(filePath);
            }
            case 'N' ->
            {
                System.out.print("Do you want to go back to Main Menu?[Y/N] : ");
                char returnToMenu = choiceIn.nextLine().toUpperCase().charAt(0);
                while(true)
                {
                    if (returnToMenu == 'Y')
                        PodcastHomeScreen.displaySongHomeScreen();
                    else if(returnToMenu == 'N')
                    {
                        System.out.println("Have a Good day! Keep Listening!");
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Invalid Choice");
                        System.out.print("Do you want to go back to Menu?[Y/N] : ");
                        returnToMenu = choiceIn.nextLine().toUpperCase().charAt(0);
                    }
                }
            }
        }
    }
}
