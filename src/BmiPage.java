import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiPage extends JFrame implements ActionListener
{
   private JFrame bmiFrame;

   private JLabel heightLabel;

   private JTextField heightTxt;

   private JLabel weightLabel;

   private JTextField weightTxt;

   private JButton confirmBtn;

   private JButton backBtn = new JButton("Back");

    private JLabel outTextLAbel;

    public static String bmiResultText;


    public BmiPage()
    {
        bmiFrame = new JFrame("Bmi index ");
        bmiFrame.setLayout(null);
        bmiFrame.setBounds(250,250, 500,500);
        bmiFrame.setLocationRelativeTo(null);
        bmiFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        heightLabel = new JLabel();
        heightLabel.setBounds(100,100,300,50);
        heightLabel.setText("Enter height in cm: ");

        heightTxt = new JTextField();
        heightTxt.setBounds(100,150,300,50);
        bmiFrame.add(heightTxt);

        weightLabel = new JLabel("Enter your weight in kg: ");
        weightLabel.setBounds(100, 250, 300, 50);
        bmiFrame.add(weightLabel);


        weightTxt = new JTextField();
        weightTxt.setBounds(100, 300,300,50);
        bmiFrame.add(weightTxt);

        confirmBtn = new JButton("Continue");
        confirmBtn.addActionListener(this);
        confirmBtn.setBounds(150,375,100,50);

        backBtn.setBounds(250,375,100,50);
        backBtn.addActionListener(this);


        outTextLAbel = new JLabel();
        outTextLAbel.setLayout(null);
        outTextLAbel.setBounds(50,75, 350, 50);
        outTextLAbel.setForeground(Color.RED);




        bmiFrame.add(heightLabel);
        bmiFrame.add(outTextLAbel);
        bmiFrame.add(confirmBtn);
        bmiFrame.add(backBtn);

        bmiFrame.setVisible(true);


    }


    //Underweight = <18.5
    //Normal weight = 18.5–24.9
    //Overweight = 25–29.9
    //Obesity = BMI of 30 or greater

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == confirmBtn)
        {
            double weight = Double.parseDouble(weightTxt.getText());
            double height = Double.parseDouble(heightTxt.getText());

            double bmi = bmiScore(weight, height);


            if (bmi < 18.5)
            {
                bmiResultText = "underweight";
            }
            else if (bmi > 18.5 && bmi < 24.9)
            {
                bmiResultText = "normal weight";
            }
            else if (bmi > 25 && bmi < 29.9)
            {
                bmiResultText = "overweight";
            }
            else
            {
                bmiResultText = "obesity";
            }

            outTextLAbel.setText("Your bmi index is in the " + bmiResultText + " range.");

            Patient.setBmiIndex(bmiResultText);
        }
        else if (event.getSource() == backBtn)
        {

            bmiFrame.dispose();
            MenuPage menuPage = new MenuPage(LoginPage.getCurrentPatient().getUserId());

        }


    }

    public String getResultText()
    {
        return bmiResultText;
    }




    public double bmiScore(double weight, double height)
    {
       // double bmi = weight / (height * height);
        double bmi = (weight / height / height ) * 10000;

        return bmi;
    }





}
