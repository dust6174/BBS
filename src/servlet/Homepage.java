package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DAO.PosterDAO;
import entity.Board;
import entity.Poster;

/**
 * Servlet implementation class Homepage
 */
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
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
		BoardDAO boardDAO = BoardDAO.getInstance();
		PosterDAO posterDAO = PosterDAO.getInstance();
		
		Board[] boards = Board.getAllBoard();
		for(Board board:boards){
			String boardid = board.boardid;
			Poster[] posters=posterDAO.getByBoardID(boardid);
			request.setAttribute("board", board);
			request.setAttribute(board.boardname, posters);
		}
		response.sendRedirect("homepage.jsp");
	}

}
