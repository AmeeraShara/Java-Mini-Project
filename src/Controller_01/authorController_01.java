
package Controller_01;

import View_01.Author_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class authorController_01 {
    private JTextField txtauthorid, txtname, txtaddress, txtnumber;
    private JTable tblauthor;
    private DefaultTableModel model;

    public authorController_01(JTextField txtauthorid, JTextField txtname, JTextField txtaddress,
                          JTextField txtnumber, JTable tblauthor) {
        this.txtauthorid = txtauthorid;
        this.txtname = txtname;
        this.txtaddress = txtaddress;
        this.txtnumber = txtnumber;
        this.tblauthor = tblauthor;
        this.model = (DefaultTableModel) tblauthor.getModel();
    }
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01"; 
        String user = "root"; 
        String password = ""; 
        return DriverManager.getConnection(url, user, password);
    }
    public void loadAuthor() {
        model.setRowCount(0); 
        String query = "SELECT * FROM author_01";
        
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
    public void addAuthor() {
        String query = "INSERT INTO author_01 (authorid, name,address , number) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtauthorid.getText()));
            pst.setString(2, txtname.getText());
            pst.setString(3, txtaddress.getText());
            pst.setInt(4, Integer.parseInt(txtnumber.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Author Added Successfully!");
            loadAuthor();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding author: " + ex.getMessage());
        }
    }
    public void updateAuthor() {
        String query = "UPDATE author_01 SET name = ?, address = ?, number = ?  WHERE authorid = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, txtname.getText());
            pst.setString(2, txtaddress.getText());
             pst.setInt(3, Integer.parseInt(txtnumber.getText()));
            pst.setInt(4, Integer.parseInt(txtauthorid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Author Updated Successfully!");
            loadAuthor();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating author: " + ex.getMessage());
        }
    }
    public void deleteAuthor() {
        String query = "UPDATE author_01 SET status='inactive' WHERE authorid = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtauthorid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Author Deleted Successfully!");
            loadAuthor();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting author: " + ex.getMessage());
        }
    }
    public void populateFields(int selectedRow) {
        txtauthorid.setText(model.getValueAt(selectedRow, 0).toString());
        txtname.setText(model.getValueAt(selectedRow, 1).toString());
        txtaddress.setText(model.getValueAt(selectedRow, 2).toString());
        txtnumber.setText(model.getValueAt(selectedRow, 3).toString());
    }

    public void clearFields() {
        txtauthorid.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtnumber.setText("");
        
    }
}
