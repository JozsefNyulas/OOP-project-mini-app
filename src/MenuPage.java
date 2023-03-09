import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPage extends JFrame implements ActionListener
{
    JFrame menuFrame = new JFrame("Menu Page");
    JButton cardioBtn;
    JButton hearingBtn;
    JButton eyeBtn;
    JButton bmiBtn;

    JButton resultBtn = new JButton("Results");

    JLabel welcomeLabel = new JLabel();

    MenuPage(String userId)
    {
        welcomeLabel.setBounds(50,50,400,35);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 22));
        welcomeLabel.setText("Welcome " + userId +", select a check up :)");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        cardioBtn = new JButton("Cardiology");
        cardioBtn.setBounds(75,150, 150, 50);
        cardioBtn.setFocusable(true);
        cardioBtn.addActionListener(this);

        hearingBtn = new JButton("Hearing");
        hearingBtn.setBounds(275,150, 150, 50);
        hearingBtn.setFocusable(true);
        hearingBtn.addActionListener(this);


        eyeBtn = new JButton("Optometry");
        eyeBtn.setBounds(75, 250, 150,50);
        eyeBtn.setFocusable(true);
        eyeBtn.addActionListener(this);

        bmiBtn = new JButton("BM Index");
        bmiBtn.setBounds(275, 250, 150, 50);
        bmiBtn.setFocusable(true);
        bmiBtn.addActionListener(this);

        resultBtn.setBounds(175,350,150,50);
        bmiBtn.addActionListener(this);





        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setBounds(250,250, 500,500);
        menuFrame.add(cardioBtn);
        menuFrame.add(hearingBtn);
        menuFrame.add(eyeBtn);
        menuFrame.add(bmiBtn);
        menuFrame.add(welcomeLabel);
        menuFrame.add(resultBtn);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent event)   // action listener interface metodja  Cardio button es stb.
    {

        if (event.getSource() == cardioBtn)
        {
            menuFrame.dispose();
            CardioPage cardioPage = new CardioPage();

        }
        else if (event.getSource() == hearingBtn)
        {
            menuFrame.dispose();

            try
            {
                HearingPage hearingPage = new HearingPage();
            }
            catch (UnsupportedAudioFileException ex)
            {
                throw new RuntimeException(ex);
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
            catch (LineUnavailableException ex)
            {
                throw new RuntimeException(ex);
            }


        }
        else if (event.getSource() == bmiBtn)
        {
            menuFrame.dispose();
            BmiPage bmiPage = new BmiPage();
        }
        else if (event.getSource() == eyeBtn)
        {
            menuFrame.dispose();
            EyeExam eyeExam = new EyeExam();
        }
        else if (event.getSource() == resultBtn)
        {
            menuFrame.dispose();
            // itt tovabb csinalni
        }

    }
}
