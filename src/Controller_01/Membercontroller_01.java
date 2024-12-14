
package Controller_01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Membercontroller_01 {
        
    private JTextField txtmemberid, txtname, txtcinfo, txtexpdate,txtcnumber;
    private JTable tblmember;
    private DefaultTableModel model;

    public Membercontroller_01(JTextField txtmemberid, JTextField txtname, JTextField txtcinfo,
                          JTextField txtexpdate,JTextField txtcnumber, JTable tblmember) {
        this.txtmemberid = txtmemberid;
        this.txtname = txtname;
        this.txtcinfo = txtcinfo;
        this.txtexpdate = txtexpdate;
        this.txtcnumber=txtcnumber;
        this.tblmember = tblmember;
        this.model = (DefaultTableModel) tblmember.getModel();
    }
    
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01"; 
        String user = "root"; 
        String password = ""; 
        return DriverManager.getConnection(url, user, password);
    }
    public void loadMember() {
        model.setRowCount(0); 
        String query = "SELECT * FROM member_01";
        
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + ex.getMessage());
        }
    }
    public void addMember() {
        String query = "INSERT INTO member_01 (memberid, name,contactinfo , expirationdate,cardnumber) VALUES (?, ?, ?, ?,?)";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtmemberid.getText()));
            pst.setString(2, txtname.getText());
            pst.setString(3, txtcinfo.getText());
            pst.setInt(4, Integer.parseInt(txtexpdate.getText()));
             pst.setInt(5, Integer.parseInt(txtcnumber.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Member Added Successfully!");
            loadMember();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding member: " + ex.getMessage());
        }
    }
    public void updateMember() {
        String query = "UPDATE member_01 SET name = ?, contactinfo = ?, expirationdate = ? ,cardnumber=? WHERE memberid = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, txtname.getText());
            pst.setString(2, txtcinfo.getText());
            pst.setInt(3, Integer.parseInt(txtexpdate.getText()));
             pst.setInt(4, Integer.parseInt(txtcnumber.getText()));
            pst.setInt(5, Integer.parseInt(txtmemberid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Member Updated Successfully!");
            loadMember();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating member: " + ex.getMessage());
        }
    }
    public void deleteMember() {
        String query = "UPDATE member_01 SET status='inactive' WHERE memberid = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtmemberid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Member Deleted Successfully!");
            loadMember();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting member: " + ex.getMessage());
        }
    }
public void populateFields(int selectedRow){
    txtmemberid.setText(model.getValueAt(selectedRow, 0).toString());
    txtname.setText(model.getValueAt(selectedRow, 1).toString());
    txtcinfo.setText(model.getValueAt(selectedRow, 2).toString());
    txtexpdate.setText(model.getValueAt(selectedRow, 3).toString());
    txtcnumber.setText(model.getValueAt(selectedRow, 4).toString());
        
}
    public void clearFields() {
        txtmemberid.setText("");
        txtname.setText("");
        txtcinfo.setText("");
        txtexpdate.setText("");
        txtcnumber.setText("");
    }
}
            