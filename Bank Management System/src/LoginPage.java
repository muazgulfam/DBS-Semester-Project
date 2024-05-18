import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame{
    LoginPage(){
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon imglogo = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo.jpg"));
        Image templogo = ((Image) imglogo.getImage()).getScaledInstance(100, 100 ,Image.SCALE_DEFAULT);
        ImageIcon setImgLogo = new ImageIcon(templogo);

        getContentPane().setBackground(Color.WHITE);

        JLabel label = new JLabel(setImgLogo);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}
