package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import entity.User;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
UserDAO userDAO = UserDAO.getInstance();
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");

		// 判断userid是否已存在
		User user = userDAO.getByUserID(userid);
		// userid已存在
		if (user != null) {
			String register = "1";
			response.sendRedirect("adminhomepage.jsp?register="+register);
		}
		// 用户名是可用的
		else if (user == null) {
			// 通过用户名和密码创建新的user
			user = new User();
			user.setUserID(userid);
			user.setUsernName(username);
			user.setUserPassword(userpassword);
			user.setIsLock(false);
			userDAO.addUser(user);
			//通过cookie存储用户名和密码并且重定向到login.jsp
			String id = Integer.toString(userid);
			Cookie cookie1 = new Cookie("userid",id);
			Cookie cookie2 = new Cookie("userpassword", userpassword);
			cookie1.setMaxAge(24*60*60);
			cookie2.setMaxAge(24*60*60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.sendRedirect("adminhomepage.jsp?adduser=1");
		}
	}

}
