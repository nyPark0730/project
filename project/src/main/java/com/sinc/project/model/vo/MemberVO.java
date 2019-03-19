package com.sinc.project.model.vo;

public class MemberVO {

	private String 	memberseq, membername, department, team, phone, email;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String memberseq, String membername, String department, String team, String phone, String email) {
		super();
		this.memberseq = memberseq;
		this.membername = membername;
		this.department = department;
		this.team = team;
		this.phone = phone;
		this.email = email;
	}

	public String getMemberseq() {
		return memberseq;
	}

	public void setMemberseq(String memberseq) {
		this.memberseq = memberseq;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [memberseq=" + memberseq + ", membername=" + membername + ", department=" + department
				+ ", team=" + team + ", phone=" + phone + ", email=" + email + "]";
	}
	
}
