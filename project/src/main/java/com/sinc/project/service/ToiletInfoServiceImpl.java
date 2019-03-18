package com.sinc.project.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
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

	/**
	 * 특정 층의 화장실 사용여부 조회
	 * @param floor
	 * @return
	 */
	@Override
	public JSONObject getToiletUseInfo(int floor, String gender) {
		
		ToiletUseInfoVO toiletUseInfo = new ToiletUseInfoVO();
		toiletUseInfo.setFloor(floor);		// 층
		toiletUseInfo.setGender(gender);	// 성별
		
		JSONObject jObj = new JSONObject();
		jObj.put("data", toiletInfoDao.getToiletUseInfo(toiletUseInfo));
		return jObj;
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