package com.sinc.project.service;

import java.util.List;

import com.sinc.project.model.vo.ToiletUseInfoVO;

public interface ToiletInfoService {

	/**
	 * 전체 화장실 사용여부 조회
	 * @return
	 */
	public List<Object> getTotalToiletUseInfo();
	
	/**
	 * 특정 층의 화장실 사용여부 조회
	 * @param floor
	 * @return
	 */
	public List<Object> getToiletUseInfo(int floor);
	
	/**
	 * 화장실 사용여부 수정
	 * @param code
	 * @param useyn
	 * @return
	 */
	public int updateToiletUseInfo(int code, String useyn);
	
}
