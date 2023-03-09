import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener
{
  // protected static String currentPatient;


    private static Patient currentPatient = new Patient();

    JFrame loginFrame = new JFrame("Login Page");



    JLabel idLabel = new JLabel("User ID: ");
    JTextField idTxt = new JTextField();


    JLabel passLabel = new JLabel("Password ");
    JPasswordField passwordField = new JPasswordField();

    JButton loginBtn = new JButton("Login");
    JButton resetBtn = new JButton("Reset");
    JLabel messageLabel = new JLabel();

    JButton newUserBtn = new JButton("New User");


    HashMap<String,String> loginInfo = new HashMap<String,String>();



    public LoginPage(HashMap<String,String> loginInfo)
    {
        this.loginInfo = loginInfo;

        idLabel.setBounds(75,100,75,30);
        idTxt.setBounds(150,100,200,30);

        passLabel.setBounds(75,150,75,30);
        passwordField.setBounds(150,150,200,30);

        messageLabel.setBounds(125,300,250,35);

        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        loginBtn.setBounds(150,200,100,25);
        loginBtn.addActionListener(this);

        resetBtn.setBounds(250,200,100,25);
        resetBtn.addActionListener(this);

        newUserBtn.setBounds(200,250,100,25);
        newUserBtn.addActionListener(this);


        loginFrame.add(idLabel);
        loginFrame.add(idTxt);

        loginFrame.add(passLabel);
        loginFrame.add(passwordField);
        loginFrame.add(messageLabel);
        loginFrame.add(loginBtn);
        loginFrame.add(resetBtn);
        loginFrame.add(newUserBtn);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(500,500);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == resetBtn)
        {
            idTxt.setText(null);
            passwordField.setText(null);
        }
        else if (event.getSource() == loginBtn)
        {
            String userId = idTxt.getText();

            currentPatient.setUserId(userId);

            String password = String.valueOf(passwordField.getPassword());
            currentPatient.setPassword(password);

            if (loginInfo.containsKey(userId))
            {
                if (loginInfo.get(userId).equals(password))
                {
                    messageLabel.setText("Login Successful");
                    messageLabel.setForeground(Color.GREEN);

                    loginFrame.dispose();

                    MenuPage menuPage = new MenuPage(userId);  //userId

                }
                else
                {
                    messageLabel.setText("Password incorrect");
                    messageLabel.setForeground(Color.RED);

                }
            }
            else
            {
                messageLabel.setText("User name not found");
                messageLabel.setForeground(Color.RED);

            }

        }
        else if (event.getSource() == newUserBtn)
        {
            loginFrame.dispose();
            RegistrationPage regPage = new RegistrationPage(new IDandPasswords().getSavedloginInfo());
        }



    }

    public static Patient getCurrentPatient()
    {
        return currentPatient;
    }
}
