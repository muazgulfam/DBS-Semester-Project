import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener{
    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    LoginPage(){
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon imglogo = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo.jpg"));
        Image templogo = ((Image) imglogo.getImage()).getScaledInstance(100, 100 ,Image.SCALE_DEFAULT);
        ImageIcon setImgLogo = new ImageIcon(templogo);

        JLabel label = new JLabel(setImgLogo);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel welcomeText = new JLabel("Welcome to ATM");
        welcomeText.setFont(new Font("Osward", Font.BOLD, 38));
        welcomeText.setBounds(200, 40, 400, 40);
        add(welcomeText);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 150, 30);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(250, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 16));
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(250, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinTextField);

        signin = new JButton("SIGN IN");
        signin.setBounds(250, 300, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(380, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(250, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == signin){

        }
        else if(ae.getSource() == signup){
            
        }
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}
