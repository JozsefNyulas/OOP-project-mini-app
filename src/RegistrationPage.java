import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RegistrationPage implements ActionListener
{


        protected static String currentPatient;

        JFrame regFrame = new JFrame("Registration Page");


        JLabel idLabel = new JLabel("new ID ");
        JTextField idTxt = new JTextField();

        JLabel passLabel = new JLabel("Password ");
        JPasswordField passwordField = new JPasswordField();

        JButton registerBtn = new JButton("Register");
        JButton resetBtn = new JButton("Reset");
        JLabel messageLabel = new JLabel();



        IDandPasswords iDandPasswords = new IDandPasswords();
        HashMap<String,String> loginInfo = iDandPasswords.getSavedloginInfo();






        public RegistrationPage(HashMap<String,String> loginInfo)
        {

            this.loginInfo = loginInfo;

            idLabel.setBounds(75,100,75,30);
            idTxt.setBounds(150,100,200,30);

            passLabel.setBounds(75,150,75,30);
            passwordField.setBounds(150,150,200,30);

            messageLabel.setBounds(125,300,250,35);

            messageLabel.setFont(new Font(null, Font.ITALIC,25));

            registerBtn.setBounds(150,200,100,25);
            registerBtn.addActionListener(this);

            resetBtn.setBounds(250,200,100,25);
            resetBtn.addActionListener(this);


            regFrame.add(idLabel);
            regFrame.add(idTxt);

            regFrame.add(passLabel);
            regFrame.add(passwordField);
            regFrame.add(messageLabel);
            regFrame.add(registerBtn);
            regFrame.add(resetBtn);
            regFrame.setLocationRelativeTo(null);
            regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            regFrame.setSize(500,500);
            regFrame.setLayout(null);
            regFrame.setLocationRelativeTo(null);
            regFrame.setVisible(true);


        }


        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == resetBtn)
            {
                idTxt.setText(null);
                passwordField.setText(null);
            }
            else if (event.getSource() == registerBtn)
            {

                String userId = idTxt.getText();
                currentPatient = userId;
                String password = String.valueOf(passwordField.getPassword());

                loginInfo.put(userId,password);

                if (loginInfo.containsKey(userId))
                {
                    if (loginInfo.get(userId).equals(password))
                    {
                        messageLabel.setText("User exists");
                        messageLabel.setForeground(Color.RED);

                        regFrame.dispose();

                        MenuPage menuPage = new MenuPage(userId);  //userId

                    }
                    else
                    {
                        messageLabel.setText("Registration succesful");
                        messageLabel.setForeground(Color.GREEN);

                    }
                }
                else
                {
                    messageLabel.setText("User name not found");
                    messageLabel.setForeground(Color.RED);

                }

            }


        }

        public static String getCurrentPatient()
        {
            return currentPatient;
        }



    }


