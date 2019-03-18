package com.sinc.project.model.sql;

import java.util.HashMap;
import java.util.List;

public interface ToiletInfoDao {

	public List<Object> getTotalToiletUseInfo();
	
	public List<HashMap<String, Object>> getToiletUseInfo(Object obj);
	
	public int updateToiletUseInfo(Object obj);
	
}
