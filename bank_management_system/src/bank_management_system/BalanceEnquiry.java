package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        Jdbc jdbc = new Jdbc();
        int balance = 0;
            try{
            //ResultSet is an object of SQL class
                ResultSet rs = jdbc.s.executeQuery("SELECT * FROM bank where pin = '"+pinNumber+"'");
            //Loops each row of the selected database
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else if(rs.getString("type").equals("Withdrawl")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            } 
            
            JLabel text = new JLabel("Your current balanceis Rs " + balance);
            text.setForeground(Color.WHITE);
            text.setBounds(170, 300, 400, 30);
            image.add(text);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
