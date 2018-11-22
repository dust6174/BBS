package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Board
 */
public class Board extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("identity") == null) {
			String board = request.getParameter("board");
			switch (board) {
			case "1":
				response.sendRedirect("index.jsp?keys=7");
				break;
			case "2":
				response.sendRedirect("index.jsp?keys=1");
				break;
			case "3":
				response.sendRedirect("index.jsp?keys=2");
				break;
			case "4":
				response.sendRedirect("index.jsp?keys=3");
				break;
			case "5":
				response.sendRedirect("index.jsp?keys=4");
				break;
			case "6":
				response.sendRedirect("index.jsp?keys=5");
				break;
			default:
				response.sendRedirect("index.jsp?keys=6");
				break;
			}
		} else {
			String board = request.getParameter("board");
			switch (board) {
			case "1":
				response.sendRedirect("homepage.jsp?keys=7");
				break;
			case "2":
				response.sendRedirect("homepage.jsp?keys=1");
				break;
			case "3":
				response.sendRedirect("homepage.jsp?keys=2");
				break;
			case "4":
				response.sendRedirect("homepage.jsp?keys=3");
				break;
			case "5":
				response.sendRedirect("homepage.jsp?keys=4");
				break;
			case "6":
				response.sendRedirect("homepage.jsp?keys=5");
				break;
			default:
				response.sendRedirect("homepage.jsp?keys=6");
				break;
			}
		}
	}
}