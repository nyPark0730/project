package com.sinc.project.service;

import java.util.List;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.TokenVO;

public interface MailService {

	/**
	 * 키워드 추가
	 * @return
	 */
	public int addKeyword(String memberSeq, String keyword);
	
	/**
	 * 키워드 조회
	 * @param memberSeq
	 * @return
	 */
	public List<Object> getKeyword(String memberSeq);
	
	/**
	 * 메일 추가
	 * @return
	 */
	public int addMail(MailVO mail);
	
	/**
	 * 멤버별 토큰 추가/수정
	 */
	public int mergeToken(String memberSeq, String token);
	
	public TokenVO getTokenInfo(String memberSeq);
	
	public void sendFCM(String recipient);
	
	public boolean compareKeyword(String recipient, String title);
}
