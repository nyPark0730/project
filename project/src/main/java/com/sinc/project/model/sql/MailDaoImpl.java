package com.sinc.project.model.sql;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.model.vo.MailVO;

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
	public int addMail(Object obj) {
		System.out.println("MailDaoImpl addMail");
		return session.insert("com.sinc.project.mailSystem.addMail", obj);
	}

	@Override
	public int mergeToken(Object obj) {
		return session.update("com.sinc.project.mailSystem.mergeToken", obj);
	}
}
