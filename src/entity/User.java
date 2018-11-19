package entity;
import java.io.Serializable;
public class User implements Serializable{
     private int  userid;
     private String username;
     private String userpassword;
     private Boolean islock;

     public int getUserID(){
        return userid;
    }

    public void setUserID(int userid){
        this.userid = userid;
    }

    public String getUserName(){
        return username;
    }

    public void setUsernName(String username){
        this.username = username;
    }
    public String getUserPassword(){
        return userpassword;
    }

    public void setUserPassword(String userpassword){
        this.userpassword = userpassword;
    }
    public boolean getIsLock(){
        return islock;
    }
    public void setIsLock(boolean islock){
        this.islock = islock;
    }

}