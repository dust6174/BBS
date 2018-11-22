package Tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import DAO.PosterDAO;
import DAO.ReplyDAO;
import DAO.UserDAO;
import entity.Poster;
import entity.Reply;
import entity.ReplyList;

public class ShowReplyTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException,IOException{		

		PosterDAO pd = PosterDAO.getInstance();
		List<Reply> replys = new ArrayList<Reply>();
		UserDAO ud = UserDAO.getInstance();
		ReplyList rl = new ReplyList();
		rl = (ReplyList)getJspContext().findAttribute("replyList");
		replys = rl.getReplyList();
			//��ȡJspWrite
		    JspWriter out = getJspContext().getOut();
		    //ƴ���ַ���
		    String outPrint = "";
		    int i = 2;
		    outPrint += "<div id=\"postcomments\">\r\n" + 
		    		"				<ol id=\"comment_list\" class=\"commentlist\">";
		    for(Reply r:replys){
		    	String name = ud.getByUserName(r.getUserID());
		    	outPrint += "<li class=\"comment-content\"><span class=\"comment-f\">#";
		    	outPrint += i++;
		    	outPrint += "</span>\r\n" + 
		    			"					<div class=\"comment-main\">\r\n" + 
		    			"							<p>\r\n" + 
		    			"								<a class=\"address\" href=\"#\" rel=\"nofollow\" target=\"_blank\">";
		    	outPrint += name;
		    	outPrint += "</a><span\r\n" + 
		    			"									class=\"time\">";
		    	outPrint += r.getReplyTime();
		    	outPrint += "</span><br>";
		    	outPrint += r.getReplyContent();
		    	outPrint += "</p>\r\n" + 
		    			"						</div></li>";
		    }
		    outPrint += "</ol>\r\n" + 
		    		"			</div>";
		    out.print(outPrint);
	}
}
