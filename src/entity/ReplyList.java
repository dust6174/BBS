package entity;

import java.util.List;

public class ReplyList {

	private List<Reply> replyList;

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "ReplyList [replyList=" + replyList + "]";
	}

	public ReplyList(List<Reply> replyList) {
		super();
		this.replyList = replyList;
	}

	public ReplyList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
