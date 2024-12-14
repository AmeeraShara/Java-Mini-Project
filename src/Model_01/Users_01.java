
package Model_01;
public abstract class Users_01 {
    private String txtusername;
    private String txtpassword;
    
   public  Users_01(String txtusername, String txtpassword){
       this.txtusername=txtusername;
       this.txtpassword=txtpassword;
   }
   public String getUsername(){
       return txtusername;
   }
   public String getPassword(){
       return txtpassword;
   }
}
