package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePersonalInfo
 * 接收参数:新的username,userpassword;
 * 更新数据库中的信息，将username,userpassword,islock放入request,redirect到personalInfo页面
 */
public class ChangePersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		String userid = (String) session.getAttribute("userid");
		Boolean islock = (Boolean) session.getAttribute("islock");
		//通过userid来update数据库中的username和userpassword
		//TODO
		
		request.setAttribute("username", username);
		request.setAttribute("userpassword", userpassword);
		request.setAttribute("islock", islock);
		request.getRequestDispatcher("personalinfo.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
