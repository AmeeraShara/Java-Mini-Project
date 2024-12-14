
package Model_01;

public class Book_01 {
      private int bookid;
     private String title;
    private String author;
    private int publishedyear;

    public Book_01(int bookid,String title, String author,  int publishedyear) {
        this.bookid=bookid;
        this.title = title;
        this.author = author;
        this.publishedyear=publishedyear;
}
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }

    
    public int getbookId(){
        return bookid;
    }
   
    public int getpublishedYear(){
        return publishedyear;
    }
    
    public void searchBook(String title){
        
    }
    public void searchBook(String title, String author){
       
    }
    
   public String displayDetails(){
        return title+author+bookid+publishedyear;
    }
    
}
