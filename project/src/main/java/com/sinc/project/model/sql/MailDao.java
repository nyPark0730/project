package com.sinc.project.model.sql;

import java.util.List;

import com.sinc.project.model.vo.TokenVO;

public interface MailDao {

	public int addKeyword(Object obj);
	
	public List<Object> getKeyword(Object obj);
	
	public int addMail(Object obj);
	
	public int mergeToken(Object obj);
	
	public TokenVO getTokenInfo(Object obj);
	
	public Object getMemberInfo(Object obj);
	
	public Object getMail(Object obj);
}
