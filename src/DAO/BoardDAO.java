package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Board;
import utils.DBHelper;



public class BoardDAO {
	
	 public static BoardDAO getInstance() {
	        return new BoardDAO();  
	    }

	public List<Board> getAll() {
		List<Board> boards = new ArrayList<Board>();
		Board board = null;
		try {

			Connection conn =  DBHelper.getInstance().getConnection();
			Statement stem =conn.createStatement();	

			String sql = "select * from board";

			ResultSet rs = stem.executeQuery(sql);
			while (rs.next()) {
				board = new Board();
				int boardid = rs.getInt("boardid");
	            String boardtitle = rs.getString("boardtitle");
	            String boardsign = rs.getString("boardsign");
	            board.setBoardID(boardid);
	            board.setBoardTitle(boardtitle);
	            board.setBoardSign(boardsign);
	            boards.add(board);
			}
			DBHelper.closeConnection(conn, stem, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}
	
	public Board getByBoardID(int boardid){
		Board board = null;
		try {
			Connection conn =  DBHelper.getInstance().getConnection();
			Statement stem =conn.createStatement();	

			String sql = "select * from board where boardid = "+boardid+";";
			ResultSet rs = stem.executeQuery(sql);
			if (rs.next()) {
				board = new Board();
	            String boardtitle = rs.getString("boardtitle");
	            String boardsign = rs.getString("boardsign");
	            board.setBoardID(boardid);
	            board.setBoardTitle(boardtitle);
	            board.setBoardSign(boardsign);
			}
			DBHelper.closeConnection(conn, stem, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	public void  updateBoard(Board board) {
		try {
			Connection c = DBHelper.getInstance().getConnection();

			String sql = "update board set boardtitle= ?, boardsign = ? where boardid = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, board.getBoardTitle());
			ps.setString(2, board.getBoardSign());
			ps.setInt(3, board.getBoardID());
			ps.execute();

			DBHelper.closeConnection(c, ps, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addBoard(Board board){
		try {

			Connection c = DBHelper.getInstance().getConnection();

			String sql = "insert into board values(null,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, board.getBoardTitle());
			ps.setString(2, board.getBoardSign());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				board.setBoardID(id);
			}
			DBHelper.closeConnection(c, ps, rs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteBoard(int boardid){
		try {
			Connection c = DBHelper.getInstance().getConnection();
			Statement s = c.createStatement();
			String sql = "delete from board where boardid = " + boardid+";";

			s.execute(sql);

			DBHelper.closeConnection(c, s, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
