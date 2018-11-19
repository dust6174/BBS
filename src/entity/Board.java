package entity;
import java.io.Serializable;
public class Board implements Serializable{
     private int  boardid;
     private String boardtitle;
     private String boardsign;

     public int getBoardID(){
         return boardid;
    }
    public void setBoardID(int boardid){
        this.boardid = boardid;
    }

     public String getBoardTitle() {
        return boardtitle;
    }
    public void setBoardTitle(String boardtitle){
        this.boardtitle = boardtitle;
    }

    public String getBoardSign() {
        return boardsign;
    }
    public void setBoardSign(String boardsign){
        this.boardsign = boardsign;
    }
}
