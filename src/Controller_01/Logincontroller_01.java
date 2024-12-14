
package Controller_01;


import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logincontroller_01 {
    private JTextField txtusername;
    private JPasswordField txtpassword;
    private JButton btnlogin,btnclose;

    public Logincontroller_01(JTextField txtusername, JPasswordField txtpassword, JButton btnlogin, JButton btnclose) {
        this.txtusername = txtusername;
        this.txtpassword = txtpassword;
        this.btnlogin = btnlogin;
        this.btnclose = btnclose;
    }
    private java.sql.Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void addMember() {
        String query = "INSERT INTO user_01 (useranme, password) VALUES (?, ?)";

        try (java.sql.Connection con = getConnection(); java.sql.PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(2, txtusername.getText());
            pst.setString(3, txtpassword.getText());

            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding user: " + ex.getMessage());
        }
    }

}
