package Home;

public class HomeScreen
{
    //The method below displays Home Screen of JukeBox Application
    public static void showMainMenu()
    {
        System.out.println("            JUKEBOX");
        System.out.println("-----------------------------------");
        System.out.printf("%2s  %10s %n","1:","New User - Sign Up");
        System.out.printf("%2s  %10s %n","2:","Already Have Account? - Sign In");
        UserChoiceOnSigning.getChoice();
    }
}

