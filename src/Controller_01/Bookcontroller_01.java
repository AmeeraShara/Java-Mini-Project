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

public class Bookcontroller_01 {

    private JTextField txtbookid, txttitle, txtauthor, txtpubyear;
    private JTable tblbook;
    private DefaultTableModel model;

    public Bookcontroller_01(JTextField txtbookid, JTextField txttitle, JTextField txtauthor,
            JTextField txtpubyear, JTable tblbook) {
        this.txtbookid = txtbookid;
        this.txttitle = txttitle;
        this.txtauthor = txtauthor;
        this.txtpubyear = txtpubyear;
        this.tblbook = tblbook;
        this.model = (DefaultTableModel) tblbook.getModel();
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void loadBooks() {
        model.setRowCount(0);
        String query = "SELECT * FROM book_01";
        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
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

    public void addBook() {
        String query = "INSERT INTO book_01 (bookid, title, author, publishedyear) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtbookid.getText()));
            pst.setString(2, txttitle.getText());
            pst.setString(3, txtauthor.getText());
            pst.setInt(4, Integer.parseInt(txtpubyear.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Added Successfully!");
            loadBooks();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding book: " + ex.getMessage());
        }
    }

    public void updateBook() {
        String query = "UPDATE book_01 SET title = ?, author = ?, publishedyear = ? WHERE bookid = ?";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, txttitle.getText());
            pst.setString(2, txtauthor.getText());
            pst.setInt(3, Integer.parseInt(txtpubyear.getText()));
            pst.setInt(4, Integer.parseInt(txtbookid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Updated Successfully!");
            loadBooks();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating book: " + ex.getMessage());
        }
    }
    
    public void populateFields(int selectedRow) {
        txtbookid.setText(model.getValueAt(selectedRow, 0).toString());
        txttitle.setText(model.getValueAt(selectedRow, 1).toString());
        txtauthor.setText(model.getValueAt(selectedRow, 2).toString());
        txtpubyear.setText(model.getValueAt(selectedRow, 3).toString());

    }


    public void deleteBook() {
        String query = "UPDATE book_01 SET status ='inactive' WHERE bookid = ?";

        try (Connection con = getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, Integer.parseInt(txtbookid.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Book Deleted Successfully!");
            loadBooks();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting book: " + ex.getMessage());
        }
    }

    public void clearFields() {
        txtbookid.setText("");
        txttitle.setText("");
        txtauthor.setText("");
        txtpubyear.setText("");
    }

    
}



/*
Connection con;
    PreparedStatement pst;
    JTable tblbook;

public void book(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost/java_lms_01","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Bookcontroller_01.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Bookcontroller_01.class.getName()).log(Level.SEVERE, null, ex);
        }
                }
    public void book_table() throws SQLException{
        int c;
        ResultSet res;
        
        pst = con.prepareStatement("select * from  book_01");
            res = pst.executeQuery();
            
            ResultSetMetaData red = res.getMetaData();
            c = red.getColumnCount();

            DefaultTableModel d = (DefaultTableModel)tblbook.getModel();
            d.setRowCount(0);

            while (res.next()) {
                
                Vector ve = new Vector();

                for (int i = 1; i <= c; i++) {

                    ve.add(res.getString("bookid"));
                    ve.add(res.getString("title"));
                    ve.add(res.getString("author"));
                    ve.add(res.getString("publishedyear"));
                }
                d.addRow(ve);
            }
}*/
