package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
