package DAO;

import java.sql.*;

import entity.Admin;
import utils.DBHelper;

public class AdminDAO {

	public AdminDAO() {
		
	}
	
	public static AdminDAO getInstance() {
		return new AdminDAO();  
	}
	public List<AdminDAO> list(int start, int count) {
		List<AdminDAO1> admins = new ArrayList<AdminDAO1>();
		try {
			
			Connection conn =  MySQL.getCon();
			Statement stem =conn.createStatement();	
			String sql = "select * from admin ";

			Connection c = null;
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, count);			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AdminDAO1 admin = new AdminDAO1();
				String adminid=rs.getString("adminid");
				String adminname = rs.getString("adminname");				
				String adminpassword = rs.getString("adminpassword");
				admin.setadminid(adminid);
				admin.setadminid(adminname);
				
				admin.setadminpassword(adminpassword);
				admins.add(admin);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
	//查找管理员账号
	private String setadminpassword(String adminpassword) {
		// TODO Auto-generated method stub
		return adminpassword;
	}

	private String setadminid(String adminid) {
		// TODO Auto-generated method stub
		return adminid;
	}

	public int getadminpassword() {
		int adminpassword = 0;
		try {

			Connection conn =  MySQL.getCon();
			Statement stem =conn.createStatement();	
			Connection c = null;
			Statement s = c.createStatement();

			String sql = "select adminpassword(*) from admin";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				adminpassword = rs.getInt(1);
			}

			System.out.println("adminpassword:" + adminpassword);

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminpassword;
	}
	//查找管理员密码
	
		public boolean doCreate(  int adminid, String adminpasswor,String adminname)throws Exception{
		    Connection conn =  MySQL.getCon();
			Statement stem =conn.createStatement();
			
			
			Admin r = new Admin();
		    
		    String sql = "insert into user(adminid，adminpassword,adminname) values("
		    				+"'"+adminid+"'"+","+"'"+adminpasswor+","+"'"+adminname+")";
		    stem.executeUpdate(sql);
		    System.out.println("添加用户信息的SQL：" + sql);
		    conn.close();
		    return true;
		}
		//通过用户名和密码 创建新的user
	
public boolean Delete(String userid,String userpassword) throws SQLException {
	

		Connection conn =  MySQL.getCon();
		Statement stem =conn.createStatement();
		
		Admin r = new Admin();

		String sql = "delete userpassword from user where userid = '" + userid + "'";

		stem.executeUpdate(sql);
		
		 System.out.println("删除用户信息的SQL：" + sql);
		    conn.close();			
	return true;
} 
//删除用户密码



public boolean Update(String userid,String userpassword) throws SQLException {
	

	Connection conn =  MySQL.getCon();
	Statement stem =conn.createStatement();
	
	Admin r = new Admin();

	String sql = "update userpassword from user where userid = '" + userid + "'";

	stem.executeUpdate(sql);
	
	 System.out.println("删除用户信息的SQL：" + sql);
	    conn.close();			
return true;
} 
//更改用户密码

}

