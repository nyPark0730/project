package com.sinc.project.model.sql;

import java.util.List;

public interface ToiletInfoDao {

	public List<Object> getTotalToiletUseInfo();
	
	public List<Object> getToiletUseInfo(Object obj);
	
	public int updateToiletUseInfo(Object obj);
	
}
