package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Poster;
import utils.DBHelper;

//实现模糊查询
public class PosterDAO {
	 public static PosterDAO getInstance() {
	        return new PosterDAO();  
	    }
	 public List<Poster> getAll() {
			List<Poster> posters = new ArrayList<Poster>();
			Poster poster = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	

				String sql = "select * from poster order by boardid,seqnum,postertime;";
				//按板块、置顶、时间排序
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					poster = new Poster();
					int posterid = rs.getInt("posterid");
					int boardid = rs.getInt("boardid");
					int userid = rs.getInt("userid");
					int counter = rs.getInt("counter");
					int seqnum = rs.getInt("seqnum");
		            String postertitle = rs.getString("postertitle");
		            String postercontent = rs.getString("postcontent");
		            String postertime = rs.getString("postertime");
		            poster.setPosterID(posterid);
		            poster.setBoardID(boardid);
		            poster.setUserID(userid);
		            poster.setCounter(counter);
		            poster.setPosterTitle(postertitle);
		            poster.setPosterContent(postercontent);
		            poster.setSeqNum(seqnum);
		            poster.setPosterTime(postertime);
		            posters.add(poster);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return posters;
		}
	 public List<Poster> getByBoardID(int boardid) {
			List<Poster> posters = new ArrayList<Poster>();
			Poster poster = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	

				String sql = "select * from poster where boardid = "+boardid+" order by seqnum,postertime;;";
				//时间排序
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					poster = new Poster();
					int posterid = rs.getInt("posterid");
					int userid = rs.getInt("userid");
					int counter = rs.getInt("counter");
					int seqnum = rs.getInt("seqnum");
		            String postertitle = rs.getString("postertitle");
		            String postercontent = rs.getString("postcontent");
		            String postertime = rs.getString("postertime");
		            poster.setPosterID(posterid);
		            poster.setBoardID(boardid);
		            poster.setUserID(userid);
		            poster.setCounter(counter);
		            poster.setPosterTitle(postertitle);
		            poster.setPosterContent(postercontent);
		            poster.setSeqNum(seqnum);
		            poster.setPosterTime(postertime);
		            posters.add(poster);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return posters;
		}
	 public List<Poster> getByUserID(int userid) {
			List<Poster> posters = new ArrayList<Poster>();
			Poster poster = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	

				String sql = "select * from poster where userid = "+userid+" order by boardid,seqnum,postertime;";
				//按板块、时间排序
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					poster = new Poster();
					int posterid = rs.getInt("posterid");
					int boardid = rs.getInt("boardid");
					int counter = rs.getInt("counter");
					int seqnum = rs.getInt("seqnum");
		            String postertitle = rs.getString("postertitle");
		            String postercontent = rs.getString("postcontent");
		            String postertime = rs.getString("postertime");
		            poster.setPosterID(posterid);
		            poster.setBoardID(boardid);
		            poster.setUserID(userid);
		            poster.setCounter(counter);
		            poster.setPosterTitle(postertitle);
		            poster.setPosterContent(postercontent);
		            poster.setSeqNum(seqnum);
		            poster.setPosterTime(postertime);
		            posters.add(poster);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return posters;
		}
	 public List<Poster> getByPosterID(int posterid) {
			List<Poster> posters = new ArrayList<Poster>();
			Poster poster = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	

				String sql = "select * from poster where posterid = "+posterid+";";
				//时间排序
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					poster = new Poster();
					int boardid = rs.getInt("boardid");
					int userid = rs.getInt("userid");
					int counter = rs.getInt("counter");
					int seqnum = rs.getInt("seqnum");
		            String postertitle = rs.getString("postertitle");
		            String postercontent = rs.getString("postcontent");
		            String postertime = rs.getString("postertime");
		            poster.setPosterID(posterid);
		            poster.setBoardID(boardid);
		            poster.setUserID(userid);
		            poster.setCounter(counter);
		            poster.setPosterTitle(postertitle);
		            poster.setPosterContent(postercontent);
		            poster.setSeqNum(seqnum);
		            poster.setPosterTime(postertime);
		            posters.add(poster);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return posters;
		}
	 public void updatePoster(Poster poster){
		 try {
				Connection c = DBHelper.getInstance().getConnection();

				String sql = "update poster set boardid= ?, postertitle = ?,postercontent = ?,seqnum = ? where posterid = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, poster.getBoardID());
				ps.setString(2, poster.getPosterTitle());
				ps.setString(3, poster.getPosterContent());
				ps.setInt(4, poster.getSeqNum());
				ps.setInt(5, poster.getPosterID());
				ps.execute();
				DBHelper.closeConnection(c, ps, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 public List<Poster> getBySearchWhat(String searchwhat) {
			List<Poster> posters = new ArrayList<Poster>();
			Poster poster = null;
			try {

				Connection conn =  DBHelper.getInstance().getConnection();
				Statement stem =conn.createStatement();	
				
				searchwhat = "%"+searchwhat+"%";
				String sql = "select * from poster "
						+ "inner join board on poster.boardid = board.boardid "
						+ "inner join user on poster.userid = user.userid "
						+ "where (postertitle like "+ searchwhat
						+ " or username like"+searchwhat
						+ " or boardname like"+searchwhat+")"
						+ " order by boardid,seqnum,postertime;";
				//按板块、时间排序
				ResultSet rs = stem.executeQuery(sql);
				while (rs.next()) {
					poster = new Poster();
					int posterid = rs.getInt("posterid");
					int boardid = rs.getInt("boardid");
					int userid = rs.getInt("userid");
					int counter = rs.getInt("counter");
					int seqnum = rs.getInt("seqnum");
		            String postertitle = rs.getString("postertitle");
		            String postercontent = rs.getString("postcontent");
		            String postertime = rs.getString("postertime");
		            poster.setPosterID(posterid);
		            poster.setBoardID(boardid);
		            poster.setUserID(userid);
		            poster.setCounter(counter);
		            poster.setPosterTitle(postertitle);
		            poster.setPosterContent(postercontent);
		            poster.setSeqNum(seqnum);
		            poster.setPosterTime(postertime);
		            posters.add(poster);
				}
				DBHelper.closeConnection(conn, stem, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return posters;
		}
	 public void  counterAddOne(Poster poster) {
		 try {
				Connection c = DBHelper.getInstance().getConnection();

				String sql = "update poster set counter = (counter+1) where posterid = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, poster.getPosterID());
				ps.execute();
				DBHelper.closeConnection(c, ps, null);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}
	 public void setTop(Poster poster){
		 try {
				Connection c = DBHelper.getInstance().getConnection();

				String sql = "update poster set seqnum = (seqnum + 1) where posterid = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, poster.getPosterID());
				ps.execute();
				DBHelper.closeConnection(c, ps, null);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	 }
	 public void addPoster(Poster poster){
		 try {
				Connection c = DBHelper.getInstance().getConnection();

				String sql = "insert into poster values(null,?,?,0,?,?,0,?)";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setInt(1, poster.getBoardID() );
				ps.setInt(2, poster.getUserID());
				ps.setString(3, poster.getPosterTitle());
				ps.setString(4, poster.getPosterContent());
				ps.setString(5, poster.getPosterTime());
				ps.execute();
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					poster.setPosterID(id);
				}
				DBHelper.closeConnection(c, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
	 } 
	 public void deletePoster(int posterid){
			try {
				Connection c = DBHelper.getInstance().getConnection();
				Statement s = c.createStatement();
				String sql = "delete from poster where posterid = " + posterid+";";
				s.execute(sql);
				DBHelper.closeConnection(c, s, null);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
