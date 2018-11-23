package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.BoardDAO;
import DAO.PosterDAO;
import DAO.UserDAO;
import entity.Board;
import entity.Poster;
import entity.User;

/**
 * Servlet implementation class Search
 * 接收查询参数searchwhat,执行模糊查询，返回搜索结果（主题帖）；
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		request.setCharacterEncoding("utf-8");
		String searchwhat = request.getParameter("keyword");
		System.out.println("keyword:"+request.getParameter("keyword"));
		
		PosterDAO posterDAO = PosterDAO.getInstance();
		List<Poster> posters = posterDAO.getBySearchWhat(searchwhat);
		
		request.setAttribute("posters", posters);
		
		HttpSession session = request.getSession();
		String identity = (String) session.getAttribute("identity");
		if(identity == null){
			RequestDispatcher view =request.getRequestDispatcher("searchresult.jsp");
			view.forward(request, response);
		}
		else if(!identity.equals("admin")){
			RequestDispatcher view =request.getRequestDispatcher("searchresult.jsp");
			view.forward(request, response);
		}
		else if(identity.equals("admin")){
			UserDAO userDAO = UserDAO.getInstance();
			List<User> users = userDAO.getAll();
			request.setAttribute("users", users);
			RequestDispatcher view =request.getRequestDispatcher("searchresult.jsp");
			view.forward(request, response);
		}
		

	}

}
