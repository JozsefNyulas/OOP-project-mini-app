import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HearingPage extends JFrame implements ActionListener
{


   // File file = new File("C:\\Users\\joeny\\Documents\\Info egyetem anyagok\\2 év\\OOP\\graphics2D\\src\\fakop.wav");

    File file = new File("src/fakop.wav");
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    JFrame hearingFrame = new JFrame();
    Button playBtn = new Button("play");
    Button stopBtn = new Button("stop");

    Button backBtn = new Button("Back");



    Button yesBtn = new Button("Yes");
    Button noBtn = new Button("No");

    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel labelTop = new JLabel("Press play for hearing test.");
    JLabel labelBottom = new JLabel();





    public HearingPage() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        labelTop.setSize(500,50);
        labelTop.setHorizontalAlignment(JLabel.CENTER);
        labelTop.setVerticalAlignment(JLabel.TOP);
        labelTop.setFont(new Font(null, Font.BOLD,22));

        playBtn.setBounds(100,100,100,50);
        playBtn.addActionListener(this);

        stopBtn.setBounds(200,100,100,50);
        stopBtn.addActionListener(this);

        backBtn.setBounds(300,100,100,50);
        backBtn.addActionListener(this);


        topPanel.setPreferredSize(new Dimension(500,250));
        topPanel.setLayout(null);
        topPanel.add(labelTop);
        topPanel.add(playBtn);
        topPanel.add(stopBtn);
        topPanel.add(backBtn);



        labelBottom.setSize(500,50);
        labelBottom.setHorizontalAlignment(JLabel.CENTER);
        labelBottom.setVerticalAlignment(JLabel.TOP);
        labelBottom.setFont(new Font(null, Font.BOLD,22));
        labelBottom.setForeground(Color.RED);

        yesBtn.setBounds(150,100,100,50);
        yesBtn.addActionListener(this);
        yesBtn.setVisible(false);

        noBtn.setBounds(250,100,100,50);
        noBtn.addActionListener(this);
        noBtn.setVisible(false);

        bottomPanel.setPreferredSize(new Dimension(500,250));
        bottomPanel.setLayout(null);
        bottomPanel.add(labelBottom);
        bottomPanel.add(yesBtn);
        bottomPanel.add(noBtn);





        hearingFrame.setSize(500,500);
        hearingFrame.setLocationRelativeTo(null);
        hearingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hearingFrame.setLayout(new BorderLayout());

        hearingFrame.add(topPanel,BorderLayout.NORTH);
        hearingFrame.add(bottomPanel,BorderLayout.SOUTH);
        hearingFrame.setVisible(true);


        clip.open(audioInputStream);


    }


    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == playBtn)
        {

            labelBottom.setText("Playing sound. Listen carefully");
            clip.setMicrosecondPosition(0);
            clip.start();
            yesBtn.setVisible(false);
            noBtn.setVisible(false);
        }
        else if (event.getSource() == stopBtn)
        {
            clip.stop();
            labelBottom.setText("Did you hear a sound?");
            yesBtn.setVisible(true);
            noBtn.setVisible(true);
        }



        if (event.getSource() == backBtn)
        {
            hearingFrame.dispose();
            MenuPage menuPage = new MenuPage(LoginPage.getCurrentPatient().getUserId());
        }


    }
}
