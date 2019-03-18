package com.sinc.project.service;

import java.util.List;

import com.sinc.project.model.vo.ToiletUseInfoVO;

public interface MeetingRoomInfoService {

	/**
	 * 전체 회의실 사용여부 조회
	 * @return
	 */
	public List<Object> getTotalMeetingRoomUseInfo();
	
	/**
	 * 특정 층의 회의실 사용여부 조회
	 * @param floor
	 * @return
	 */
	public List<Object> getMeetingRoomUseInfo(int floor);
	
	/**
	 * 회의실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	public int updateMeetingRoomUseInfo(int code, String useyn);
	
}
