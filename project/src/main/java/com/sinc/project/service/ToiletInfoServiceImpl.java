package com.sinc.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.model.sql.ToiletInfoDao;
import com.sinc.project.model.vo.ToiletUseInfoVO;

@Service("toiletInfoService")
public class ToiletInfoServiceImpl implements ToiletInfoService {

	@Resource(name="toiletInfoDao")
	private ToiletInfoDao toiletInfoDao;

	/**
	 * 전체 화장실 사용여부 조회
	 * @return
	 */
	@Override
	public List<Object> getTotalToiletUseInfo() {
		System.out.println("ToiletInfoServiceImpl getTotalToiletUseInfo");
		return toiletInfoDao.getTotalToiletUseInfo();
	}

	@Override
	public List<Object> getToiletUseInfoByGender(String gender) {
		System.out.println("ToiletInfoServiceImpl getToiletUseInfoByGender");
		ToiletUseInfoVO toiletUseInfo = new ToiletUseInfoVO();
		toiletUseInfo.setGender(gender);	// 성별
		return toiletInfoDao.getToiletUseInfoByGender(toiletUseInfo);
	} 
	
	/**
	 * 특정 층의 화장실 사용여부 조회
	 * @param floor
	 * @return
	 */
	@Override
	public List<Object> getToiletUseInfo(int floor, String gender) {
		
		ToiletUseInfoVO toiletUseInfo = new ToiletUseInfoVO();
		toiletUseInfo.setFloor(floor);		// 층
		toiletUseInfo.setGender(gender);	// 성별
		
		//JSONArray jObj = new JSONArray(toiletInfoDao.getToiletUseInfo(toiletUseInfo));
		//jObj.put("data", toiletInfoDao.getToiletUseInfo(toiletUseInfo));
		return toiletInfoDao.getToiletUseInfo(toiletUseInfo);
	}

	/**
	 * 화장실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	@Override
	public int updateToiletUseInfo(int code, String useyn) {
		
		ToiletUseInfoVO toiletUseInfo = new ToiletUseInfoVO();
		toiletUseInfo.setSensorcode(code);	// 센서코드
		
		// 사용여부
		if (useyn.equals("Y") || useyn.equals("N")) {
			toiletUseInfo.setUseyn(useyn);
		} else {
			toiletUseInfo.setUseyn("N");
		}
		
		return toiletInfoDao.updateToiletUseInfo(toiletUseInfo);
	}

}