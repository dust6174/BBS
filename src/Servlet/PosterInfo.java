package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import entity.Poster;
import entity.Reply;

/**
 * Servlet implementation class PosterInfo
 * requset中接收posterid，
 * 将主题帖和相关跟帖放在requset中，redirect到poster.jsp
 */
public class PosterInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PosterInfo() {
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
		PosterDAO posterDAO = PosterDAO.getInstance();
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		String posterid = request.getParameter("posterid");

		//通过posterid获得整个poster对象（即select *）
		//通过posterid获得所有所有该poster的跟帖
		Poster poster = posterDAO.getByID(posterid);
		Reply[] replyList = replyDAO.getByPosterID(posterid);	
		request.setAttribute("poster", poster);
		request.setAttribute("replyList", replyList);
		response.sendRedirect("poster.jsp");
	}

}
