package com.myhome.user;

/**
 * 커뮤니티 게시판 댓글의 객체를 담당하는 클래스입니다.
 * @author 노푸른
 *
 */
public class CommentCommunityDTO {
	
	private String seqCommunityComment;
	private String seqCommunity;
	private String seqAllUser;
	private String writeDate;
	private String ccontent;
	
	private String nickName;
	

	public String getSeqCommunityComment() {
		return seqCommunityComment;
	}

	public void setSeqCommunityComment(String seqCommunityComment) {
		this.seqCommunityComment = seqCommunityComment;
	}

	public String getSeqCommunity() {
		return seqCommunity;
	}

	public void setSeqCommunity(String seqCommunity) {
		this.seqCommunity = seqCommunity;
	}

	public String getSeqAllUser() {
		return seqAllUser;
	}

	public void setSeqAllUser(String seqAllUser) {
		this.seqAllUser = seqAllUser;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
	
	

}
