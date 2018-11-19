package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DAO.UserDAO;
import entity.Admin;
import entity.User;

/**
 * Servlet implementation class Login
 * 实现doPost
 * 接收login.jsp传来的参数：identity,值为'admin'/'user'
 * userid,userpassword/adminid,adminpassword;与数据库中对比；
 * 如存在此用户，登录成功，在session中添加参数identity,userid,username,islock（值为'true'或'false'）,并redirect到homepage.jsp；
 * 如不存在此用户，登录失败，在request中添加参数login,值为'false',redirect到login.jsp;
 * 如存在此管理员，登录成功，在session中添加参数identity,adminid,adminname,并redirect到adminhomepage.jsp；
 * 如不存在此管理员，登录失败，在request中添加参数login,值为'false',redirect到login.jsp;
 * 如果登录成功，在session中添加参数islogin,值为'true'
 */
public class Login extends HttpServlet {
	private UserDAO userDAO = UserDAO.getInstance();
	private AdminDAO adminDAO = AdminDAO.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String identity = request.getParameter("identity");
		if(identity.equals("user")){
			String userid = request.getParameter("userid");
			String userpassword = request.getParameter("userpassword");
			User user = userDAO.getByID(userid);
			
			// 不存在该用户，即没有数据被选出
			if (user == null) {
				String login = "不存在此用户";
				//request.setAttribute("login", login);
				//request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp?login="+login);
			}
			// 存在该用户
			// 通过参数identity,userid,username在数据库中select islock的值
			else if (user != null) {
				//验证密码是否正确
				//如果正确
				if(user.password == userpassword){
					HttpSession session = request.getSession();
					// 在session中添加参数identity,userid,username,islock（值为'true'或'false'）
					session.setAttribute("identity",identity);
					session.setAttribute("userid",userid);
					session.setAttribute("username", user.username);
					session.setAttribute("islock", user.islock);
					// 登录成功，在session中添加参数islogin,值为'true'
					session.setAttribute("islogin", true);
					response.sendRedirect("homepage.jsp");
				}
				else if (user.password != userpassword) {
					String login = "密码错误";
					//request.setAttribute("login", login);
					//request.getRequestDispatcher("login.jsp").forward(request, response);
					response.sendRedirect("login.jsp?login="+login);					
				}

			}	
		}
		
		if(identity.equals("admin")){
			String adminid = request.getParameter("adminid");
			Admin admin = AdminDAO.getByID(adminid);

			// 不存在该管理员，即没有数据被选出
			if (admin == null) {
				String login = "不存在此管理员";
				//request.setAttribute("login", login);
				//request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp?login="+login);
			}
			// 存在该管理员
			// 通过参数identity,adminid,adminrname在数据库中的值
			else if (admin != null) {
				HttpSession session = request.getSession();
				// 在session中添加参数identity,userid,username,islock（值为'true'或'false'）
				session.setAttribute("identity",identity);
				session.setAttribute("adminid",adminid);
				session.setAttribute("adminname", admin.username);
				// 登录成功，在session中添加参数islogin,值为'true'
				session.setAttribute("islogin", true);
				response.sendRedirect("adminhomepage.jsp");
			}	
			}	
		}

}
