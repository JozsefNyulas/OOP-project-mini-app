import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegPage extends JFrame implements ActionListener
{
    private JPanel regPagePanel;

    private JFrame regFrame;
    private JLabel nameLabel;
    private JTextField nameTxt;
    private JLabel cnpLabel;
    private JTextField cnpTxt;
    private JButton confirmBtn;


    private ArrayList<Patient> patientsList = new ArrayList<>();





    public RegPage()
    {
        regFrame = new JFrame("Registration");
        regFrame.setLayout(null);
        regFrame.setBounds(250,250, 500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setLocationRelativeTo(null);
        regFrame.add(nameLabel);
        regFrame.add(nameTxt);
        regFrame.add(cnpLabel);
        regFrame.add(cnpTxt);
        regFrame.add(confirmBtn);
        regFrame.setVisible(true);

        nameLabel = new JLabel();
        nameLabel.setBounds(100,100,300,50);
        nameLabel.setText("Enter full name to register: ");


        nameTxt = new JTextField();
        nameTxt.setBounds(100,150,300,50);


        cnpLabel = new JLabel("Enter CNP: ");
        cnpLabel.setBounds(100, 250, 300, 50);



        cnpTxt = new JTextField();
        cnpTxt.setBounds(100, 300,300,50);


        confirmBtn = new JButton("Continue");
        confirmBtn.addActionListener(this);
        confirmBtn.setBounds(200,375,100,50);






    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == confirmBtn)
        {
            String name = nameTxt.getText();
            String cnp = cnpTxt.getText();

            Patient patientToAdd = new Patient();


            regFrame.dispose();

            MenuPage menuPage = new MenuPage(LoginPage.getCurrentPatient().getUserId());
        }
    }
}
