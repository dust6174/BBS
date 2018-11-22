package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import entity.User;
import utils.DBHelper;

//ʵ��getById��
//�����ڷ���null;
//���ڷ���user(userid,username,userpasssword,islock);
public class UserDAO {
	 public static UserDAO getInstance() {
	        return new UserDAO();  
	    }

	    public User getByUserID(int userid) {
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
	    public String getByUserName(int userid) {
	    	String name = "";
	        try {
	            
	            Connection conn =  DBHelper.getInstance().getConnection();
	            Statement stem =conn.createStatement(); 
	            String sql = "select * from user where userid = "+userid+";";
	            ResultSet rs= stem.executeQuery(sql);
	            
	            if (rs.next()) {
	            	name  = rs.getString("username");
	            }
	                DBHelper.closeConnection(conn, stem, rs);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return name;
	    }
	    public List<User> getAll(){
	    	List<User> users = new ArrayList<User>();
			User user = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	

				String sql = "select * from user;";
				//����顢�ö���ʱ������
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					user = new User();
					int userid = rs.getInt("userid");
		            String username = rs.getString("username");
		            String userpassword = rs.getString("userpassword");
		            Boolean islock = rs.getBoolean("islock");
		            user.setUserID(userid);
		            user.setUsernName(username);
		            user.setUserPassword(userpassword);
		            user.setIsLock(islock);
		            users.add(user);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return users;	
	    }
	    public void updateUser(User user){
			 try {
					Connection c = DBHelper.getInstance().getConnection();

					String sql = "update user set username= ?, userpassword = ?,islock = ? where userid = ?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getUserPassword());
					ps.setBoolean(3, user.getIsLock());
					ps.setInt(4, user.getUserID());
					ps.execute();
					DBHelper.closeConnection(c, ps, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
		 }
	     public void addLock(User user){
	    	 try {
					Connection c = DBHelper.getInstance().getConnection();

					String sql = "update user set islock = true where userid = ?;";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setInt(1, user.getUserID());
					ps.execute();
					DBHelper.closeConnection(c, ps, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
	     }
	     public void disLock(User user){
	    	 try {
					Connection c = DBHelper.getInstance().getConnection();

					String sql = "update user set islock = false where userid = ?;";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setInt(1, user.getUserID());
					ps.execute();
					DBHelper.closeConnection(c, ps, null);
				} catch (Exception e) {
					e.printStackTrace();
				} 
	     }
	     public List<User> getBySearchWhat(String searchwhat){
	    	 List<User> users = new ArrayList<User>();
				User user = null;
				try {

					Connection conn =  DBHelper.getInstance().getConnection();
					Statement stem =conn.createStatement();	
					
					searchwhat = "%"+searchwhat+"%";
					String sql = "select * from user "
							+ "where (userid like "+ searchwhat
							+ " or username like"+searchwhat+");";
					//����顢ʱ������
					ResultSet rs = stem.executeQuery(sql);
					while (rs.next()) {
						user = new User();
						int userid = rs.getInt("userid");
			            String username = rs.getString("username");
			            String userpassword = rs.getString("userpassword");
			            Boolean islock = rs.getBoolean("islock");
			            user.setUserID(userid);
			            user.setUsernName(username);
			            user.setUserPassword(userpassword);
			            user.setIsLock(islock);
			            users.add(user);
			            users.add(user);
					}
					DBHelper.closeConnection(conn, stem, rs);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return users;
	     }
	     public void addUser(User user) {
    		 try {
    				Connection c = DBHelper.getInstance().getConnection();

    				String sql = "insert into user values(?,?,?,?)";
    				PreparedStatement ps = c.prepareStatement(sql);
    				ps.setInt(1, user.getUserID() );
    				ps.setString(2, user.getUserName());
    				ps.setString(3, user.getUserPassword());
    				ps.setBoolean(4, user.getIsLock());
    				ps.execute();
    				DBHelper.closeConnection(c, ps, null);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
		}
	     public void deleteUser(int userid){
	    	 try {
					Connection c = DBHelper.getInstance().getConnection();
					Statement s = c.createStatement();
					String sql = "delete from poster where userid = " + userid+";";
					s.execute(sql);
					DBHelper.closeConnection(c, s, null);

				} catch (Exception e) {
					e.printStackTrace();
				}
	     }
	     

}
