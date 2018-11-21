package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DAO.PosterDAO;
import DAO.UserDAO;
import entity.Board;
import entity.Poster;
import entity.User;

/**
 * Servlet implementation class ShowAll
 */
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAll() {
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
		// TODO Auto-generated method stub
		PosterDAO posterDAO = PosterDAO.getInstance();
		List<Poster> posters = posterDAO.getAll();
		System.out.println(posters);
		request.setAttribute("posters", posters);
		
		UserDAO userDAO = UserDAO.getInstance();
		List<User> users = userDAO.getAll();
		request.setAttribute("users", users);
		
		RequestDispatcher view =request.getRequestDispatcher("showall.jsp");
			view.include(request, response);	
	}

}
