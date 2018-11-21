package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: 2333").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//防止同时登录管理员和用户
		HttpSession session = request.getSession();
		if(session.getAttribute("islogin") != null){
			response.sendRedirect("login.jsp?login=请勿重复登录");
		}
		
		String identity = request.getParameter("identity");
		System.out.println("identity:"+identity);
		if(identity.equals("user")){
			int userid = Integer.parseInt(request.getParameter("userid"));
			String userpassword = request.getParameter("userpassword");
			User user = userDAO.getByUserID(userid);
			
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
				if(user.getUserPassword().equals(userpassword)){
					// 在session中添加参数identity,userid,username,islock（值为'true'或'false'）
					session.setAttribute("identity",identity);
					session.setAttribute("userid",userid);
					session.setAttribute("username", user.getUserName());
					session.setAttribute("islock", user.getIsLock());
					// 登录成功，在session中添加参数islogin,值为'true'
					session.setAttribute("islogin", true);
					
					//通过cookie存储ID和密码并且重定向到homepage.jsp
					String id = Integer.toString(userid);
					Cookie cookie1 = new Cookie("userid",id);
					Cookie cookie2 = new Cookie("userpassword", userpassword);
					cookie1.setMaxAge(24*60*60);
					cookie2.setMaxAge(24*60*60);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
					
					response.sendRedirect("homepage.jsp");
				}
				else if (!user.getUserPassword().equals(userpassword)) {
					String login = "密码错误";
					//request.setAttribute("login", login);
					//request.getRequestDispatcher("login.jsp").forward(request, response);
					response.sendRedirect("login.jsp?login="+login);					
				}

			}	
		}
		
		else if(identity.equals("admin")){
			int adminid = Integer.parseInt(request.getParameter("adminid"));
			String adminpassword = request.getParameter("adminpassword");
			Admin admin = adminDAO.getAdminByID(adminid);

			// 不存在该管理员，即没有数据被选出
			if (admin == null) {
				String login = "不存在此管理员";
				//request.setAttribute("login", login);
				//request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp?login="+login);
			}
			// 存在该管理员
			// 通过参数identity,adminid,adminrname在数据库中的值
			else if(admin != null){
				if(admin.getAdminPassword().equals(adminpassword)) {
					// 在session中添加参数identity,userid,username,islock（值为'true'或'false'）
					session.setAttribute("identity",identity);
					session.setAttribute("adminid",adminid);
					session.setAttribute("adminname", admin.getAdminName());
					// 登录成功，在session中添加参数islogin,值为'true'
					session.setAttribute("islogin", true);
					
					//通过cookie存储管理员ID和密码并且重定向到aminhomepage.jsp
					String id = Integer.toString(adminid);
					Cookie cookie1 = new Cookie("adminid",id);
					Cookie cookie2 = new Cookie("adminpassword", adminpassword);
					cookie1.setMaxAge(24*60*60);
					cookie2.setMaxAge(24*60*60);
					response.addCookie(cookie1);
					response.addCookie(cookie2);
					
					response.sendRedirect("adminhomepage.jsp");
				}
				else if(!admin.getAdminPassword().equals(adminpassword)){
					String login = "密码错误";
					//request.setAttribute("login", login);
					//request.getRequestDispatcher("login.jsp").forward(request, response);
					response.sendRedirect("login.jsp?login="+login);
				}
			}
			}	
		}

}
