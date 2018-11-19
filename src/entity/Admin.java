package entity;
import java.io.Serializable;
public class Admin implements Serializable{
     private int  adminid;
     private String adminname;
     private String adminpassword;

     public int getAdminID(){
    	 return adminid;
    }

     public String getAdminName() {
 		return adminname;
 	}

     public String getAdminPassword() {
 		return adminpassword;
 	}
     public void setAdminID(int adminid){
         this.adminid = adminid;
    }

     public void setAdminName(String adminname) {
        this.adminname = adminname;
    }

     public void setAdminPassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }
 	
}
