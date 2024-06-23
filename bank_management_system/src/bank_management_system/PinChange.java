package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton change, back;
    String pinNumber;
    
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN:");
        text.setBounds(250, 280, 500, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel pinText = new JLabel("Re-Enter New PIN:");
        pinText.setBounds(165, 360, 180, 25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel repinText = new JLabel("New Pin:");
        repinText.setBounds(165, 320, 180, 25);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(repinText);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered Pin doesn't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter the New PIN");    
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter the New PIN");    
                    return;
                }
                
                Jdbc jdbc = new Jdbc();
                String query1 = "UPDATE bank set pin = '"+rpin+"' WHERE pin = '"+pinNumber+"'";
                String query2 = "UPDATE login set pin = '"+rpin+"' WHERE pin = '"+pinNumber+"'";
                String query3 = "UPDATE AccDetails set pin = '"+rpin+"' WHERE pin = '"+pinNumber+"'";
                
                jdbc.s.executeUpdate(query1);
                jdbc.s.executeUpdate(query2);
                jdbc.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully!!");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
