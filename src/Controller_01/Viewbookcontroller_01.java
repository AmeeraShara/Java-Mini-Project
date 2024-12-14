/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Viewbookcontroller_01 {

    private JTable tblvbooks;
    private DefaultTableModel model;

    public Viewbookcontroller_01(JTable tblvbooks) {
        this.model = (DefaultTableModel) tblvbooks.getModel();
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void loadvBook() {
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

}
