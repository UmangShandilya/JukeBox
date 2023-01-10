package Podcast.UserOperation;

import Connectivity.EstablishConnection;
import Display.DisplayTracks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserChoiceOnSearchMenu {
    static Scanner scan = new Scanner(System.in);
    static Connection connect = EstablishConnection.establishConnection();
    static PreparedStatement stmt;

    //The method takes user input and directs on the basis of choice.
    public static void getChoice() throws SQLException {
        System.out.print("Please enter your choice : ");
        int userChoice = Integer.parseInt(scan.nextLine());
        while (userChoice < 1 || userChoice > 3) {
            System.out.println("Invalid Choice!");
            System.out.print("Please enter your choice : ");
            userChoice = Integer.parseInt(scan.nextLine());
        }
        String query;
        switch (userChoice)
        {
            case 1 ->
            {
                System.out.print("Enter Podcast Name : ");
                String podcast = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist,filepath from song where title = ? and songID like 'P%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1,podcast);
                DisplayTracks.displayTracks(stmt);
                UserChoice.getChoice();
            }
            case 2 ->
            {
                System.out.print("Enter Artist Name : ");
                String artistName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist from song where artist = ? and songID like 'P%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1,artistName);
                DisplayTracks.displayTracks(stmt);
                UserChoice.getChoice();
            }
            case 3 ->
            {
                System.out.print("Enter Podcast Name : ");
                String podcast = scan.nextLine();
                System.out.print("Enter Artist Name : ");
                String artistName = scan.nextLine();
                query = "select title,time_format(duration,'%i:%s'),artist from song where title = ? and artist = ? and songID like 'P%'";
                stmt = connect.prepareStatement(query);
                stmt.setString(1,podcast);
                stmt.setString(2,artistName);
                DisplayTracks.displayTracks(stmt);
                UserChoice.getChoice();
            }
        }
    }
}

