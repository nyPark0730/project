package com.sinc.project.model.sql;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("meetingRoomInfoDao")
public class MeetingRoomInfoDaoImpl implements MeetingRoomInfoDao {

	@Resource(name="sqlSession")
	private SqlSession session;

	@Override
	public List<Object> getTotalMeetingRoomUseInfo() {
		System.out.println("MeetingRoomInfoDaoImpl getTotalMeetingRoomUseInfo");
		return session.selectList("com.sinc.project.meetingRoomUseInfo.totalMeetingRoomUseInfoList");
	}

	@Override
	public List<Object> getMeetingRoomUseInfo(Object obj) {
		System.out.println("MeetingRoomInfoDaoImpl getMeetingRoomUseInfo");
		return session.selectList("com.sinc.project.meetingRoomUseInfo.meetingRoomUseInfoList", obj);
	}

	@Override
	public int updateMeetingRoomUseInfo(Object obj) {
		System.out.println("MeetingRoomInfoDaoImpl updateMeetingRoomUseInfo");
		session.update("com.sinc.project.meetingRoomUseInfo.updateMeetingRoomUseInfo", obj);
		return 0;
	}
}
