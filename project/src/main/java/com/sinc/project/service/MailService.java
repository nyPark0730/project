package com.sinc.project.service;

import java.util.List;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.MemberVO;
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
	 * 키워드 삭제
	 * @param memberSeq
	 * @param keyword
	 * @return
	 */
	public int deleteKeyword(String memberSeq, String keyword);
	
	/**
	 * 메일 추가
	 * @return
	 */
	public int addMail(MailVO mail);
	
	/**
	 * 멤버별 토큰 추가/수정
	 */
	public int mergeToken(String memberSeq, String token);
	
	/**
	 * 멤버의 토큰 정보 조회
	 * @param memberSeq
	 * @return
	 */
	public TokenVO getTokenInfo(String memberSeq);
	
	/**
	 * 알람 보내기
	 * @param senderInfo
	 * @param recipient
	 * @param title
	 */
	public void sendFCM(MemberVO senderInfo, String recipient, String title, int mailSeq);
	
	/**
	 * 키워드와 메일 제목 비교
	 * @param recipient
	 * @param title
	 * @return
	 */
	public boolean compareKeyword(String recipient, String title, String contents);
	
	/**
	 * 멤버 정보 조회
	 * @param sender
	 * @return
	 */
	public Object getMemberInfo(String sender);
	
	/**
	 * 메일시퀀스로 받은 메일 조회
	 * @param mailseq
	 * @return
	 */
	public Object getMail(int mailseq);
	
	/**
	 * 멤버 추가
	 */
	public void addMember(MemberVO memberinfo);

}
