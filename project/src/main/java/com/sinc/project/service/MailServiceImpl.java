package com.sinc.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.ognl.Token;
import org.springframework.stereotype.Service;

import com.sinc.project.model.sql.MailDao;
import com.sinc.project.model.vo.KeywordVO;
import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.TokenVO;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Resource(name="mailDao")
	private MailDao mailDao;

	/**
	 * 키워드 추가
	 */
	@Override
	public int addKeyword(String memberSeq, String keyword) {
		KeywordVO keywordVo = new KeywordVO();
		keywordVo.setMemberseq(memberSeq);
		keywordVo.setKeyword(keyword);
		return mailDao.addKeyword(keywordVo);
	}

	/**
	 * 키워드 조회
	 */
	@Override
	public List<Object> getKeyword(String memberSeq) {
		KeywordVO keywordVo = new KeywordVO();
		keywordVo.setMemberseq(memberSeq);
		return mailDao.getKeyword(keywordVo);
	}

	/**
	 * 메일 INSERT
	 */
	@Override
	public int addMail(MailVO mail) {
		return mailDao.addMail(mail);
	}

	/**
	 * 멤버별 토큰 추가/수정
	 */
	@Override
	public int mergeToken(String memberSeq, String token) {
		TokenVO tokenVo = new TokenVO();
		tokenVo.setMemberseq(memberSeq);
		tokenVo.setToken(token);
		return mailDao.mergeToken(tokenVo);
	} 
}