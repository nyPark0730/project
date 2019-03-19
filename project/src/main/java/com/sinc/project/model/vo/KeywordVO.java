package com.sinc.project.model.vo;

public class KeywordVO {

	private String 	memberseq, keyword;
	
	public KeywordVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KeywordVO(String memberseq, String keyword) {
		super();
		this.memberseq = memberseq;
		this.keyword = keyword;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "KeywordVO [memberseq=" + memberseq + ", keyword=" + keyword + "]";
	}

}
