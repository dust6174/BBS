package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import entity.User;
import utils.DBHelper;

//实现getById；
//不存在返回null;
//存在返回user(userid,username,userpasssword,islock);
public class UserDAO {
	 public static UserDAO getInstance() {
	        return new UserDAO();  
	    }

	    public User getUserByID(int userid) {
	        User user =null;
	        try {
	            
	            Connection conn =  DBHelper.getInstance().getConnection();
	            Statement stem =conn.createStatement(); 
	            String sql = "select * from user where userid = "+userid+";";
	            ResultSet rs= stem.executeQuery(sql);
	            
	            if (rs.next()) {
	                user = new User();
	                String username  = rs.getString("username");
	                String userpassword = rs.getString("userpassword");
	                Boolean islock = rs.getBoolean("islock");
	                user.setUserID(userid);
	                user.setUsernName(username);
	                user.setUserPassword(userpassword);
	                user.setIsLock(islock);
	            }
	                DBHelper.closeConnection(conn, stem, rs);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	    public List<User> getAll(){
	    	
	    }

}
