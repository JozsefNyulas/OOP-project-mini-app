import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {

     // RegPage regPage = new RegPage();


     //  BmiPage bmiPage = new BmiPage();

     //   CardioPage cardioPage = new CardioPage();


     //   MenuPage menuPage = new MenuPage("Jozsef");


        // try catch a gomboknal, ha uress a field.

      //  EyeExam eyeExam = new EyeExam();

     //  HearingPage hearingPage = new HearingPage();

         IDandPasswords iDandPasswords = new IDandPasswords();

         LoginPage loginPage = new LoginPage(iDandPasswords.getSavedloginInfo());

    }
}