package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ReplyDAO;
import entity.Reply;

/**
 * Servlet implementation class AddReply 鎺ユ敹鍙傛暟锛宲osterid,userid,replycontent
 * 璺熷笘锛屽湪Reply涓坊鍔犳柊鐨勮窡甯� redirct鍒皃oster.jsp锛�
 */
public class AddReply extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		int posterid = Integer.parseInt(request.getParameter("posterid"));
		int userid = (int) session.getAttribute("userid");
		String replycontent = request.getParameter("replycontent");

		// 寰楀埌璺熷笘鏃剁殑鏃堕棿
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String replydatetime = s.format(date);

		// 閫氳繃posterid锛寀serid锛宺eplycontent锛宺eplydatetime鏉ュ垱寤烘柊reply
		Reply reply = new Reply();
		reply.setPosterID(posterid);
		reply.setUserID(userid);
		reply.setReplyContent(replycontent);
		reply.setReplyTime(replydatetime);
		ReplyDAO rd = ReplyDAO.getInstance();
		rd.addReply(reply);
		
		response.sendRedirect("PosterInfo?id="+posterid);
	}

}
