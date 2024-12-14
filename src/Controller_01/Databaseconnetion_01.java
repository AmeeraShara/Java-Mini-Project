
package Controller_01;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Databaseconnetion_01 {
    Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con=DriverManager.getConnection("jdbc:mysql://localhost/java_lms_01","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Databaseconnetion_01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Databaseconnetion_01.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
     
}
