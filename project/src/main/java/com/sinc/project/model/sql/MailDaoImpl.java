package com.sinc.project.model.sql;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.model.vo.MailVO;
import com.sinc.project.model.vo.TokenVO;

@Repository("mailDao")
public class MailDaoImpl implements MailDao {

	@Resource(name="sqlSession")
	private SqlSession session;

	@Override
	public int addKeyword(Object obj) {
		System.out.println("MailDaoImpl addKeyword"+ obj);
		return session.insert("com.sinc.project.mailSystem.addKeyword", obj);
	}

	@Override
	public List<Object> getKeyword(Object obj) {
		System.out.println("MailDaoImpl getKeyword");
		return session.selectList("com.sinc.project.mailSystem.memberKeywordList", obj);
	}

	@Override
	public int deleteKeyword(Object obj) {
		return session.delete("com.sinc.project.mailSystem.deleteKeyword", obj);
	}
	@Override
	public int addMail(Object obj) {
		System.out.println("MailDaoImpl addMail");
		session.insert("com.sinc.project.mailSystem.addMail", obj);
		return ((MailVO)obj).getMailseq();
	}

	@Override
	public int mergeToken(Object obj) {
		return session.update("com.sinc.project.mailSystem.mergeToken", obj);
	}

	@Override
	public TokenVO getTokenInfo(Object obj) {
		System.out.println("MailDaoImpl getTokenInfo");
		return session.selectOne("com.sinc.project.mailSystem.memberTokenList", obj);
	}

	@Override
	public Object getMemberInfo(Object obj) {
		System.out.println("MailDaoImpl getMemberInfo");
		return session.selectOne("com.sinc.project.mailSystem.getMemberInfo", obj);
	}

	@Override
	public Object getMail(Object obj) {
		System.out.println("MailDaoImpl getMail");
		return session.selectOne("com.sinc.project.mailSystem.getMail", obj);
	}

}
