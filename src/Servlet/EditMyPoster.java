package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PosterDAO;
import entity.Poster;

/**
 * 鎺ユ敹鐢眕oster.jsp浼犳潵鐨刾osterid
 * 鍙戣捣涓婚鐨勪汉鍙互瀵硅嚜宸辩殑涓婚甯栧瓙杩涜缂栬緫
 * 缂栬緫瀹宲oster涔嬪悗灏卞彲浠edirect鍒皃oster.jsp
 */
public class EditMyPoster extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int posterid = Integer.parseInt(request.getParameter("posterid"));
		String postertitle = request.getParameter("postertitle");
		String postercontent = request.getParameter("postercontent");
		PosterDAO pd = PosterDAO.getInstance();
		Poster p = pd.getByPosterID(posterid);
		//閫氳繃posterid淇敼鏁版嵁搴撲腑postercontent鐨勫��
		Poster poster = new Poster();
		poster.setBoardID(p.getBoardID());
		poster.setPosterContent(postercontent);
		poster.setPosterID(posterid);
		poster.setPosterTitle(postertitle);
		poster.setSeqNum(p.getSeqNum());
		pd.updatePoster(poster);
		
		response.sendRedirect("PosterInfo?id="+posterid);
	}


}
