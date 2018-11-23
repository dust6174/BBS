package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PosterDAO;
import DAO.UserDAO;
import entity.Poster;
import entity.User;

/**
 * 鎺ユ敹鍙傛暟锛宐oardid,userid,postertitle,postercontent
 * 鍙戝笘锛屽湪Poster涓坊鍔犳柊鐨勫彂甯� redirct鍒癰oard.jsp锛�
 */
public class AddPoster extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int boardid = Integer.parseInt(request.getParameter("boardid"));
		int userid = (int) session.getAttribute("userid");
		String postertitle = request.getParameter("postertitle");
		String postercontent = request.getParameter("postercontent");
		
		User user = UserDAO.getInstance().getByUserID(userid);
		if(user.getIsLock() == true){
			response.sendRedirect("addPoster.jsp?islock=1");
		}

		// 寰楀埌鍙戝笘鏃剁殑鏃堕棿
		else {
			Date date = new Date();
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String posterdatetime = s.format(date);
			
			//鏍规嵁boardid,userid,postertitle,postercontent锛宲osterdatetime鏉ュ彂甯栵紙鍗冲垱寤轰竴涓柊鐨刾oster瀵硅薄锛�
			Poster poster = new Poster();
			poster.setBoardID(boardid);
			poster.setUserID(userid);
			poster.setPosterTitle(postertitle);
			poster.setPosterContent(postercontent);
			poster.setPosterTime(posterdatetime);
			PosterDAO pd = PosterDAO.getInstance();
			pd.addPoster(poster);
			
			response.sendRedirect("homepage.jsp?keys="+boardid);
		}
		
	}

	

}
