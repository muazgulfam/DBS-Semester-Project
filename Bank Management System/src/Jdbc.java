import java.sql.*;
public class Jdbc {
//Object of Connection class
    Connection c;
    Statement s;
    public Jdbc(){
    //Exceptional Handling    
        try {
        //Step 1: Register the Query
            //Class.forName(com.mysql.cj.jdbc.Driver);
        //Step 2: Creating the Connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Database@mysql01");
        //Step 3: Create Statement
            s = c.createStatement();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
