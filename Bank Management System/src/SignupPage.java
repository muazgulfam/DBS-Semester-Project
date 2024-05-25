import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
//import com.toedter.calender.JDateChooser;  Error in importing JAR file of calender

public class SignupPage extends JFrame implements ActionListener{

    long randomNum;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, otherGender, married, single, otherMarital;

    SignupPage(){
    //Generating Random number
        Random rand = new Random(); 
        randomNum = Math.abs((rand.nextLong() % 9000L) + 1000L);

        JLabel formNum = new JLabel("APPLICATION FORM NO. " + randomNum);
        formNum.setFont(new Font("Raleway", Font.BOLD, 38));
        setLayout(null);
        formNum.setBounds(140, 20, 600, 40);
        add(formNum);

        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        personalDetail.setBounds(290, 80, 400, 30);
        add(personalDetail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dobTextField.setBounds(300, 240, 400, 30);
        add(dobTextField);

        /*JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);*/

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        otherGender = new JRadioButton("Other");
        otherGender.setBounds(630, 290, 120, 30);
        otherGender.setBackground(Color.WHITE);
        add(otherGender);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGender);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(300, 390, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);
        
        married = new JRadioButton("Married");
        married.setBounds(450, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);


        otherMarital = new JRadioButton("Other");
        otherMarital.setBounds(630, 390, 120, 30);
        otherMarital.setBackground(Color.WHITE);
        add(otherMarital);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(single);
        maritalGroup.add(otherMarital);

        JLabel adress = new JLabel("Adress:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        adress.setBounds(100, 440, 200, 30);
        add(add(adress));

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(add(addressTextField));

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        setLayout(null);
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + randomNum;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = "" + dobTextField.getText();
        String gender = null;
            if(male.isSelected()){
                gender = "male";
            }
            else if(female.isSelected()){
                gender = "female";
            }
            else if(otherGender.isSelected()){
                gender = "other";
            }
        String email = emailTextField.getText();
        String marital = null;
            if(single.isSelected()){
                marital = "single";
            }
            else if(married.isSelected()){
                marital = "Married";
            }
            else if(otherMarital.isSelected()){
                marital = "Other";
            }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
    
        try {
        //Validation Check
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father Name is required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of birth is required");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required");
            }
        //Establishing Connection
            else{
                Jdbc c = new Jdbc();
                String query = "INSERT INTO signup VALUES ('"+formno+"', '"+name+"','"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                //4th step: Execute Query
                    c.s.executeQuery(query);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupPage();
    }
}