import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EyeExam extends JFrame implements ActionListener
{
    JFrame eyeFrame = new JFrame();

    ImageIcon image;
    JLabel labelCenter = new JLabel();
    JLabel topLabel = new JLabel("Measure the width using a ruler. Is the width between 56 - 59 mm?");
    Button yesBtn = new Button("Yes");
    Button noBtn = new Button("No");
    Button backBtn = new Button("Back");

    JPanel panelTop = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelBottom = new JPanel();

    public EyeExam()
    {
        try
        {
            image = new ImageIcon(EyeExam.class.getResource("eye_res.png"));
        }
        catch (Exception exception)
        {
            System.out.println("Can't find image");
        }



        panelTop.setPreferredSize(new Dimension(500,50));
        panelTop.add(topLabel);


        labelCenter.setSize(300,200);
        labelCenter.setIcon(image);
        panelCenter.setPreferredSize(new Dimension(500,300));
        panelCenter.add(labelCenter);



        // buttons
        yesBtn.setBounds(100,50,100,50);
        noBtn.setBounds(200,50,100,50);
        backBtn.setBounds(300,50,100,50);
        yesBtn.addActionListener(this);
        noBtn.addActionListener(this);
        backBtn.addActionListener(this);

        // panelBottom

        panelBottom.setLayout(null);
        panelBottom.setPreferredSize(new Dimension(500,150));
        panelBottom.add(yesBtn);
        panelBottom.add(noBtn);
        panelBottom.add(backBtn);


        //frame settings and adding
        eyeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eyeFrame.setSize(500,500);
        eyeFrame.setLayout(new BorderLayout());
        eyeFrame.add(panelTop,BorderLayout.NORTH);
        eyeFrame.add(panelCenter,BorderLayout.CENTER);
        eyeFrame.add(panelBottom,BorderLayout.SOUTH);
        eyeFrame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent event)
    {
        String visionResult;

        if (event.getSource() == yesBtn)
        {
            System.out.println("yes");
            visionResult = "fit";

        }
        else if (event.getSource() == noBtn)
        {

            visionResult = "unfit";
            System.out.println("no");

        }
        else if (event.getSource() == backBtn)
        {

            eyeFrame.dispose();
            MenuPage menuPage = new MenuPage(LoginPage.getCurrentPatient().getUserId());
        }

    }
}
