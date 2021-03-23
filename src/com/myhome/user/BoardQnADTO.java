package com.myhome.user;

/**
 * Q&A 게시판의 객체를 담당하는 클래스입니다.
 * @author 노푸른
 *
 */
public class BoardQnADTO {
	
	private String seqQnA; //게시글번호
	private String title; //제목
	private String content; //내용
	private String writeDate; //작성일
	//private String seqUser; //회원 번호
		private String seqAllUser; //회원번호
		private String state; //답변상태

	private int gap; //최신글
	private String nickName; //회원 닉네임
	
	//private String seqQnACategory; //카테고리번호
		private String seqQnAType; //카테고리번호
		private String category; //큐엔에이카테고리

	private String seqQnAComment; //답변번호
	private String cContent; //답변내용
	private String cWriteDate; //답변날짜
	
	private String id; //관리자 id

	public String getSeqQnA() {
		return seqQnA;
	}

	public void setSeqQnA(String seqQnA) {
		this.seqQnA = seqQnA;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getSeqAllUser() {
		return seqAllUser;
	}

	public void setSeqAllUser(String seqAllUser) {
		this.seqAllUser = seqAllUser;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSeqQnAType() {
		return seqQnAType;
	}

	public void setSeqQnAType(String seqQnAType) {
		this.seqQnAType = seqQnAType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeqQnAComment() {
		return seqQnAComment;
	}

	public void setSeqQnAComment(String seqQnAComment) {
		this.seqQnAComment = seqQnAComment;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getcWriteDate() {
		return cWriteDate;
	}

	public void setcWriteDate(String cWriteDate) {
		this.cWriteDate = cWriteDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
