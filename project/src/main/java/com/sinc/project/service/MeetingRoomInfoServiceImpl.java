package com.sinc.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.model.sql.MeetingRoomInfoDao;
import com.sinc.project.model.vo.MeetingRoomUseInfoVO;
import com.sinc.project.model.vo.ToiletUseInfoVO;

@Service("meetingRoomInfoService")
public class MeetingRoomInfoServiceImpl implements MeetingRoomInfoService {

	@Resource(name="meetingRoomInfoDao")
	private MeetingRoomInfoDao meetingRoomInfoDao;

	/**
	 * 전체 회의실 사용여부 조회
	 * @return
	 */
	@Override
	public List<Object> getTotalMeetingRoomUseInfo() {
		System.out.println("ToiletInfoServiceImpl getTotalToiletUseInfo");
		return meetingRoomInfoDao.getTotalMeetingRoomUseInfo();
	}

	/**
	 * 특정 층의 회의실 사용여부 조회
	 * @param floor
	 * @return
	 */
	@Override
	public List<Object> getMeetingRoomUseInfo(int floor) {
		
		MeetingRoomUseInfoVO meetingRoomUseInfo = new MeetingRoomUseInfoVO();
		meetingRoomUseInfo.setFloor(floor);	// 층
		return meetingRoomInfoDao.getMeetingRoomUseInfo(meetingRoomUseInfo);
	}

	/**
	 * 회의실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	@Override
	public int updateMeetingRoomUseInfo(int code, String useyn) {
		
		ToiletUseInfoVO toiletUseInfo = new ToiletUseInfoVO();
		toiletUseInfo.setSensorcode(code);	// 센서코드
		
		// 사용여부
		if (useyn.equals("Y") || useyn.equals("N")) {
			toiletUseInfo.setUseyn(useyn);
		} else {
			toiletUseInfo.setUseyn("N");
		}
		
		return meetingRoomInfoDao.updateMeetingRoomUseInfo(toiletUseInfo);
	} 
}