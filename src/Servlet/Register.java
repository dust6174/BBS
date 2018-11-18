package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register 实现doPost 接受register.jsp传来的参数：
 * userid,username,userpassword;
 * 检查数据库中是否存在同id用户，存在则注册失败，向request中添加参数register，值为'false'并redirect到register.jsp
 * 注册成功则向cookie中添加参数userid,userpassword,并重定向到login.jsp
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");

		// 判断userid是否已存在
		String result = null;
		// userid已存在
		if (result == userid) {
			boolean register = false;
			request.setAttribute("fail", register);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		// 用户名是可用的
		if (result != userid) {
			// 通过用户名和密码创建新的user
			// TODO

			//通过cookie存储用户名和密码并且重定向到login.jsp
			Cookie cookie1 = new Cookie("userid", userid);
			Cookie cookie2 = new Cookie("userpassword", password);
			cookie1.setMaxAge(24*60*60);
			cookie2.setMaxAge(24*60*60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
