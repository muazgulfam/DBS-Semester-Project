package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AccountDetails extends JFrame implements ActionListener{
    JRadioButton accSaving, accFixed, accCurrent, accRecurring;
    JCheckBox a1, a2, a3, a4, a5, a6;
    JButton submit, cancel;
    String formno;
    
    AccountDetails(String formno){
        this.formno = formno;
        setLayout(null);
        
        JLabel title = new JLabel("Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(280, 40, 400, 40);
        add(title);
        
    //Label for Account Type
        JLabel accType = new JLabel("Account Details");
        accType.setFont(new Font("Raleway", Font.BOLD, 22));
        accType.setBounds(100, 140, 200, 30);
        add(accType);
    //Radio Button 1 for Account type 
        accSaving = new JRadioButton("Saving Account");
        accSaving.setFont(new Font("Raleway", Font.BOLD, 16));
        accSaving.setBackground(Color.WHITE);
        accSaving.setBounds(100, 180, 200, 20);
        add(accSaving);
    //Radio Button 2 for Account type   
        accFixed = new JRadioButton("Fixed Deposit Account");
        accFixed.setFont(new Font("Raleway", Font.BOLD, 16));
        accFixed.setBackground(Color.WHITE);
        accFixed.setBounds(350, 180, 250, 20);
        add(accFixed);    
    //Radio Button 3 for Account type   
        accCurrent = new JRadioButton("Current Account");
        accCurrent.setFont(new Font("Raleway", Font.BOLD, 16));
        accCurrent.setBackground(Color.WHITE);
        accCurrent.setBounds(100, 220, 200, 20);
        add(accCurrent);
    //Radio Button 4 for Account type   
        accRecurring = new JRadioButton("Recurring Deposite Account");
        accRecurring.setFont(new Font("Raleway", Font.BOLD, 16));
        accRecurring.setBackground(Color.WHITE);
        accRecurring.setBounds(350, 220, 250, 20);
        add(accRecurring);
    //Grouping the Radio Buttons    
        ButtonGroup groupAccTypeBtn = new ButtonGroup();
        groupAccTypeBtn.add(accSaving);
        groupAccTypeBtn.add(accFixed);
        groupAccTypeBtn.add(accCurrent);
        groupAccTypeBtn.add(accRecurring);
        
        JLabel card = new JLabel("Card number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        JLabel cardNum = new JLabel("XXXX-XXXX-XXXX-0000");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNum.setBounds(330, 300, 300, 30);
        add(cardNum);
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        JLabel pinNum = new JLabel("XXXX");
        pinNum.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNum.setBounds(330, 370, 300, 30);
        add(pinNum);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);
        
        a1 = new JCheckBox("ATM Card");
        a1.setBackground(Color.WHITE);
        a1.setFont(new Font("Raleway", Font.BOLD, 16));
        a1.setBounds(100,500, 200, 30);
        add(a1);
        
        a2 = new JCheckBox("Internet Banking");
        a2.setBackground(Color.WHITE);
        a2.setFont(new Font("Raleway", Font.BOLD, 16));
        a2.setBounds(350,500, 200, 30);
        add(a2);
        
        a3 = new JCheckBox("E-mail & SMS alerts");
        a3.setBackground(Color.WHITE);
        a3.setFont(new Font("Raleway", Font.BOLD, 16));
        a3.setBounds(100,550, 200, 30);
        add(a3);
        
        a4 = new JCheckBox("Cheque Book");
        a4.setBackground(Color.WHITE);
        a4.setFont(new Font("Raleway", Font.BOLD, 16));
        a4.setBounds(350,550, 200, 30);
        add(a4);
        
        a5 = new JCheckBox("E-Statement");
        a5.setBackground(Color.WHITE);
        a5.setFont(new Font("Raleway", Font.BOLD, 16));
        a5.setBounds(100,600, 200, 30);
        add(a5);
        
        a6 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knowledge");
        a6.setBackground(Color.WHITE);
        a6.setFont(new Font("Raleway", Font.BOLD, 12));
        a6.setBounds(100,680, 600, 30);
        add(a6);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850, 820);
        setLocation(350, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
        //Selecting the account type   
            String accountType = null;
                if(accSaving.isSelected()){
                    accountType = "Saving Account";}
                else if(accFixed.isSelected()){
                    accountType = "Fixed Account";}
                else if(accCurrent.isSelected()){
                    accountType = "Current Account";}
                else if(accRecurring.isSelected()){
                    accountType = "Recurring Deposite Account";}
        
        //Generating Card number        
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        //Generating Pin number    
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
        //Acquired Facilities
            String facility = "";
            if(a1.isSelected()){
                facility = facility + "ATM Card";
            }
            else if(a2.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if(a3.isSelected()){
                facility = facility + " E-mail & SMS alerts";
            }
            else if(a4.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(a5.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }
                else{
                    Jdbc connection = new Jdbc();
                //DML Queries (INSERTING)
                    String query1 = "insert into AccDetails values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"' )";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    connection.s.executeUpdate(query1);
                    connection.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\nPin: " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }    
    
    public static void main(String args[]){
        new AccountDetails("");
    }
}
