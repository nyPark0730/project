package com.sinc.project.model.sql;

import java.util.List;

public interface MeetingRoomInfoDao {

	public List<Object> getTotalMeetingRoomUseInfo();
	
	public List<Object> getMeetingRoomUseInfo(Object obj);
	
	public int updateMeetingRoomUseInfo(Object obj);
	
}
