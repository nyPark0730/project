package com.sinc.project.service;

import java.util.List;

public interface ToiletInfoService {

	/**
	 * 전체 화장실 사용여부 조회
	 * @return
	 */
	public List<Object> getTotalToiletUseInfo();
	
	/**
	 * 특정 성별 화장실 사용여부 조회
	 * @param gender
	 * @return
	 */
	public List<Object> getToiletUseInfoByGender(String gender);
	
	/**
	 * 특정 층의 화장실 사용여부 조회
	 * @param floor
	 * @return
	 */
	public List<Object> getToiletUseInfo(int floor, String gender);
	
	/**
	 * 화장실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	public int updateToiletUseInfo(int code, String useyn);
	
}
