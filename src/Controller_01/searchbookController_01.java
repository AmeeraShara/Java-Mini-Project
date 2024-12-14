
package Controller_01;
import Model_01.Book_01;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchbookController_01 {
 
   public JComboBox cmbauthor;
    public  JComboBox cmbtitle;
    public JTable tblsearchbook;
    public DefaultTableModel model;
   
    public searchbookController_01(JComboBox cmbauthor, JComboBox cmbtitle, JTable tblsearchbook){
        this.cmbauthor=cmbauthor;
        this.cmbtitle=cmbtitle;
        this.tblsearchbook=tblsearchbook;
        this.model = (DefaultTableModel) tblsearchbook.getModel();
    }
   
     private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/java_lms_01";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
     public List<Book_01> searchByAuthorName(String authorName) {
        List<Book_01> books = new ArrayList<>();
        String sql = "SELECT * FROM book_01 WHERE author = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
           
            statement.setString(1, authorName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book_01 book = new Book_01(
                    resultSet.getInt("bookid"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getInt("publishedyear")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return books;
    }
      public List<Book_01> searchByAuthorAndTitle(String authorName, String bookTitle) {
        List<Book_01> books = new ArrayList<>();
        String sql = "SELECT * FROM book_01 WHERE author = ? AND title = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
           
            statement.setString(1, authorName);
            statement.setString(2, bookTitle);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book_01 book = new Book_01(
                     resultSet.getInt("bookid"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getInt("publishedyear")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
      public void performSearch() {
        String authorName;
        authorName = (String) cmbauthor.getSelectedItem();
        String bookTitle =(String) cmbtitle.getSelectedItem();

        List<Book_01> searchResults;

        if (!authorName.isEmpty() && bookTitle.isEmpty()) {
            searchResults = searchByAuthorName(authorName);
        } else if (!authorName.isEmpty() && !bookTitle.isEmpty()) {
            searchResults = searchByAuthorAndTitle(authorName, bookTitle);
        } else {
            System.out.println("Please enter at least the author name.");
            return;
        }
        updateTable(searchResults);
    }
      private void updateTable(List<Book_01> books) {
        String[] columnNames = {"bookid", "title", "author", "publishedyear"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Book_01 book : books) {
            Object[] rowData = {book.getbookId(), book.getTitle(), book.getAuthor(), book.getpublishedYear()};
            tableModel.addRow(rowData);
        }
        tblsearchbook.setModel(tableModel);
    }

      public List<String> getAllAuthors() {
        List<String> authors = new ArrayList<>();
        String sql = "SELECT DISTINCT author FROM book_01";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                authors.add(resultSet.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public List<String> getAllBookTitles() {
        List<String> bookTitles = new ArrayList<>();
        String sql = "SELECT DISTINCT title FROM book_01";

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                bookTitles.add(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookTitles;
    }

    public void clearFields() {
        cmbtitle.setSelectedIndex(-1);
        cmbauthor.setSelectedIndex(-1);
    }



     
     
     
     
     
     

}
   


   

 

