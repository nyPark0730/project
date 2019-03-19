package com.sinc.project.model.vo;

public class MailVO {

	private int		mailseq;
	private String 	sender, recipient, smode, title, contents, maildate;
	
	public MailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MailVO(int mailseq, String sender, String recipient, String smode, String title, String contents,
			String maildate) {
		super();
		this.mailseq = mailseq;
		this.sender = sender;
		this.recipient = recipient;
		this.smode = smode;
		this.title = title;
		this.contents = contents;
		this.maildate = maildate;
	}

	public int getMailseq() {
		return mailseq;
	}

	public void setMailseq(int mailseq) {
		this.mailseq = mailseq;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSmode() {
		return smode;
	}

	public void setSmode(String smode) {
		this.smode = smode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getMaildate() {
		return maildate;
	}

	public void setMaildate(String maildate) {
		this.maildate = maildate;
	}

	@Override
	public String toString() {
		return "MailVO [mailseq=" + mailseq + ", sender=" + sender + ", recipient=" + recipient + ", smode=" + smode
				+ ", title=" + title + ", contents=" + contents + ", maildate=" + maildate + "]";
	}
}
