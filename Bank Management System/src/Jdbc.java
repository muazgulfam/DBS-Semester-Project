import java.sql.*;
public class Jdbc {
//Object of Connection class
    Connection c;
    public Jdbc(){
    //Exceptional Handling    
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Database@mysql01");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
