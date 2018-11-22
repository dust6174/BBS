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
import entity.Board;
import entity.Poster;

/**
 * Servlet implementation class EditPoster
 */
public class EditPoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPoster() {
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
		int posterid = Integer.parseInt(request.getParameter("posterid"));
		System.out.println("poster:"+request.getParameter("posterid"));
		
		PosterDAO posterDAO = PosterDAO.getInstance();
		Poster poster = posterDAO.getByPosterID(posterid);
		
		request.setAttribute("poster", poster);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<Board> boards = boardDAO.getAll();
		request.setAttribute("boards", boards);
		
		RequestDispatcher view =request.getRequestDispatcher("editposter.jsp");
		view.forward(request, response);	
	}

}
