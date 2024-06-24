package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
    String pinNumber;
    
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("National Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel("National Bank");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            Jdbc jdbc = new Jdbc();
            ResultSet rs = jdbc.s.executeQuery("SELECT * FROM login WHERE pin = '"+pinNumber+"'");
            //ResultSet rs = jdbc.s.executeQuery("SELECT * FROM login WHERE pin = 9175");
            while(rs.next()){
            //Appending the data instead of overWriting
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "********" + rs.getString("cardNumber").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        } 
        
        try{
            Jdbc jdbc = new Jdbc();
            int bal = 0;
            ResultSet rs = jdbc.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }
                    else if(rs.getString("type").equals("Withdrawl")){
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current Balance is Rs " + bal);
        }
        catch(Exception e){
            System.out.println(e);
        } 
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
