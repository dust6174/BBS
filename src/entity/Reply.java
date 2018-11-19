package entity;
import java.io.Serializable;
public class Reply implements Serializable{
    private int  replyid;
    private int  posterid;
    private int  userid;
    private String replycontent;
    private String replytime;

    public int getReplyID(){
        return replyid;
    }
    public void setReplyID(int replyid){
        this.replyid = replyid;
    }
    public int getPosterID(){
        return posterid;
    }
    public void setPosterID(int posterid){
        this.posterid = posterid;
    }
    public int getUserID(){
        return userid;
    }
    public void setUserID(int userid){
        this.userid = userid;
    }
    public String getReplyContent(){
        return replycontent;
    }
    public void setReplyContent(String replycontent){
        this.replycontent = replycontent;
    }
    public String getReplyTime(){
        return replytime;
    }
    public void setReplyTime(String replytime){
        this.replytime = replytime;
    }

}
