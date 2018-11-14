/**
 * 
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wben 
 *
 */
public class DBHelper {

	public String url = "jdbc:mysql://localhost:3306/studb?useUnicode=true&characterEncoding=UTF-8";
	public String username = "root";
	public String password = "root";
	public static DBHelper instance = null;

	// 通过静态代码块注册数据库驱动，保证注册只执行一次
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DBHelper() {
	}

	/**
	 * 获得类实例
	 * 
	 * @return
	 */
	public static DBHelper getInstance() {
		// 给类加锁,防止线程并发
		synchronized (DBHelper.class) {
			if (instance == null) {
				instance = new DBHelper();
			}
		}
		return instance;
	}

	/**
	 * 获得连接
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
