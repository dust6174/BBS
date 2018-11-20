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

    public Admin getAdminByID(int adminid) {
        Admin admin =null;
        try {
            
            Connection conn =  DBHelper.getInstance().getConnection();
            Statement stem =conn.createStatement(); 
            String sql = "select * from admin where adminid = "+adminid+";";
            ResultSet rs= stem.executeQuery(sql);
            
            if (rs.next()) {
                admin = new Admin();
                String adminname  = rs.getString("adminname");
                String adminpassword = rs.getString("adminpassword");
                admin.setAdminID(adminid);
                admin.setAdminName(adminname);
                admin.setAdminPassword(adminpassword);
            }
                DBHelper.closeConnection(conn, stem, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
}

}

