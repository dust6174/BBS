package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import entity.User;
import sun.security.jca.GetInstance;

/**
 * Servlet implementation class PersonalInfo
 * 从session中获取userid，从数据库中获取username,islock，添加到request中，redirect到personalinfo.jsp；
 */
public class PersonalInfo extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		UserDAO userDAO = UserDAO.GetInstance();
		User user = userDAO.getByID(userid);
		String username = user.username;
		String userpassword = user.password;
		boolean islock = user.islock;
			
		//通过userid从数据库中获取username,password,islock
		
		request.setAttribute("username", username);
		request.setAttribute("userpassword", userpassword);
		request.setAttribute("islock", islock);
		request.getRequestDispatcher("personalinfo.jsp").forward(request, response);
	}

}
