import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardioPage extends JFrame implements ActionListener
{
    private JFrame cardioFrame;

    private JLabel systolicLabel;
    private JTextField systolicTxt;

    private JLabel diastolicLabel;
    private JTextField diastolicTxt;

    private JLabel outTextLAbel;

    private JButton confirmBtn;

    JButton backBtn = new JButton("Back");


    private static String  resultText;


    public CardioPage()
    {

        cardioFrame = new JFrame("Cardio Page");
        cardioFrame.setLayout(null);
        cardioFrame.setLocationRelativeTo(null);
        cardioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardioFrame.setBounds(250, 250, 500, 500);

        systolicLabel = new JLabel();
        systolicLabel.setBounds(100,100,300,50);
        systolicLabel.setText("Enter systolic value: ");
        cardioFrame.add(systolicLabel);

        systolicTxt = new JTextField();
        systolicTxt.setBounds(100,150,300,50);
        cardioFrame.add(systolicTxt);

        diastolicLabel = new JLabel("Enter diastolic value: ");
        diastolicLabel.setBounds(100, 250, 300, 50);
        cardioFrame.add(diastolicLabel);


        diastolicTxt = new JTextField();
        diastolicTxt.setBounds(100, 300,300,50);
        cardioFrame.add(diastolicTxt);

        confirmBtn = new JButton("Confirm");
        confirmBtn.addActionListener(this);
        confirmBtn.setBounds(150,375,100,50);

        backBtn.setBounds(250,375,100,50);
        backBtn.addActionListener(this);


        outTextLAbel = new JLabel();
        outTextLAbel.setLayout(null);
        outTextLAbel.setBounds(50,75, 350, 50);
        outTextLAbel.setForeground(Color.RED);



        cardioFrame.add(diastolicLabel);
        cardioFrame.add(systolicLabel);
        cardioFrame.add(outTextLAbel);
        cardioFrame.add(confirmBtn);
        cardioFrame.add(backBtn);


        cardioFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == confirmBtn)
        {

            int systolic = Integer.parseInt(systolicTxt.getText());
            int diastolic = Integer.parseInt(diastolicTxt.getText());

            resultText =  bloodPressTest(systolic, diastolic);

            outTextLAbel.setText("Your blood pressure is in the " + resultText + " range");

            Patient.setBloodPressure(resultText);


        }
        else if (event.getSource() == backBtn)
        {
            cardioFrame.dispose();
            MenuPage menuPage = new MenuPage(LoginPage.getCurrentPatient().getUserId());
        }

    }


    public String bloodPressTest(int systolic, int diastolic)
    {
        // normal blood pressure between 90/60 and  120/80

        String cardioResult = null;

        if ( (systolic <= 120) && (systolic >= 90) && (diastolic >= 60) && (diastolic <= 80) )
        {
            cardioResult = "Normal";
        }
        else if ( (systolic < 90) && (diastolic < 60) )
        {
            cardioResult = "Low";
        }
        else if (systolic > 120 && diastolic > 80)
        {
            cardioResult = "High";
        }

        return cardioResult;

    }


    public JFrame getCardioFrame()
    {
        return cardioFrame;
    }

    public void setCardioFrame(JFrame cardioFrame)
    {
        this.cardioFrame = cardioFrame;
    }

    public JLabel getSystolicLabel()
    {
        return systolicLabel;
    }

    public void setSystolicLabel(JLabel systolicLabel)
    {
        this.systolicLabel = systolicLabel;
    }

    public JTextField getSystolicTxt()
    {
        return systolicTxt;
    }

    public void setSystolicTxt(JTextField systolicTxt)
    {
        this.systolicTxt = systolicTxt;
    }

    public JLabel getDiastolicLabel()
    {
        return diastolicLabel;
    }

    public void setDiastolicLabel(JLabel diastolicLabel)
    {
        this.diastolicLabel = diastolicLabel;
    }

    public JTextField getDiastolicTxt()
    {
        return diastolicTxt;
    }

    public void setDiastolicTxt(JTextField diastolicTxt)
    {
        this.diastolicTxt = diastolicTxt;
    }

    public JLabel getOutTextLAbel()
    {
        return outTextLAbel;
    }

    public void setOutTextLAbel(JLabel outTextLAbel)
    {
        this.outTextLAbel = outTextLAbel;
    }

    public JButton getConfirmBtn()
    {
        return confirmBtn;
    }

    public void setConfirmBtn(JButton confirmBtn)
    {
        this.confirmBtn = confirmBtn;
    }
}
