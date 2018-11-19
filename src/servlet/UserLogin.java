package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entity.User;

/**
 * Servlet implementation class Login 实现doPost
 * 接收login.jsp传来的参数：identity,值为'admin'/'user'
 * userid,userpassword/adminid,adminpassword;与数据库中对比；
 * 如存在此用户，登录成功，在session中添加参数identity,userid,username,islock（值为'true'或'false'）,并redirect到homepage.jsp；
 * 如不存在此用户，登录失败，在request中添加参数login,值为'false',redirect到login.jsp;
 * 如存在此管理员，登录成功，在session中添加参数identity,adminid,adminname,并redirect到adminhomepage.jsp；
 * 如不存在此管理员，登录失败，在request中添加参数login,值为'false',redirect到login.jsp;
 * 如果登录成功，在session中添加参数islogin,值为'true'
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAO.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identity = request.getParameter("identity");
		String userid = request.getParameter("userid");

		HttpSession session = request.getSession();

		User = userDAO.getByID(userid);
		String username = User.username;
		boolean islock = User.islock;
		// 通过参数identity,userid,username在数据库中select islock的值
		
		// 不存在该用户，即没有数据被选出
		if (result == (Boolean) null) {
			boolean login = false;
			request.setAttribute("fail", login);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		// 存在该用户
		else if (result == true || result == false) {
			// 在session中添加参数identity,userid,username,islock（值为'true'或'false'）
			session.setAttribute("identity", identity);
			session.setAttribute("userid", userid);
			session.setAttribute("username", username);
			session.setAttribute("islock", islock);
			// 登录成功，在session中添加参数islogin,值为'true'
			session.setAttribute("islogin", true);
			response.sendRedirect("homepage.jsp");
		}
	}

}
