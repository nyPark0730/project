package com.sinc.project.model.vo;

public class TokenVO {

	private String 	memberseq, token;
	
	public TokenVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenVO(String memberseq, String token) {
		super();
		this.memberseq = memberseq;
		this.token = token;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenVO [memberseq=" + memberseq + ", token=" + token + "]";
	}
}
