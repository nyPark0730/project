package com.sinc.project.model.sql;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("toiletInfoDao")
public class ToiletInfoDaoImpl implements ToiletInfoDao {

	@Resource(name="sqlSession")
	private SqlSession session;

	@Override
	public List<Object> getTotalToiletUseInfo() {
		System.out.println("ToiletInfoDaoImpl getTotalToiletUseInfo");
		return session.selectList("com.sinc.project.toiletUseInfo.totalToiletUseInfoList");
	}

	@Override
	public List<Object> getToiletUseInfo(Object obj) {
		System.out.println("ToiletInfoDaoImpl getToiletUseInfo");
		return session.selectList("com.sinc.project.toiletUseInfo.toiletUseInfoList", obj);
	}

	@Override
	public int updateToiletUseInfo(Object obj) {
		System.out.println("ToiletInfoDaoImpl updateToiletUseInfo");
		session.update("com.sinc.project.toiletUseInfo.updateToiletUseInfo", obj);
		return 0;
	}
}
