package entity;
import java.io.Serializable;
public class Poster implements Serializable{
     private int posterid;
     private int boardid;
     private int userid;
     private int counter;
     private String postertitle;
     private String postercontent;
     private int seqnum;
     private String postertime;
     
    public int getPosterID(){
        return posterid;
    }
    public void setPosterID(int posterid){
        this.posterid = posterid;
    }    

    public int getBoardID(){
        return boardid;
    }
    public void setBoardID(int boardid){
        this.boardid = boardid;
    }  
    public int getUserID(){
        return userid;
    }
    public void setUserID(int userid){
        this.userid = userid;
    }  
    public int getCounter(){
        return counter;
    }
    public void setCounter(int counter){
        this.counter = counter;
    }  

    public int getSeqNum(){
        return seqnum;
    }
    public void setSeqNum(int seqnum){
        this.seqnum = seqnum;
    }  

    public String getPosterTitle(){
        return postertitle;
    }
    public void setPosterTitle(String postertitle){
        this.postertitle = postertitle;
    }
    public String getPosterContent(){
        return postercontent;
    }
    public void setPosterContent(String postercontent ){
        this.postercontent = postercontent;
    }
    public String getPosterTime(){
        return postertime; 
    }
    public void setPosterTime(String postertime){
        this.postertime = postertime;
    }

}
