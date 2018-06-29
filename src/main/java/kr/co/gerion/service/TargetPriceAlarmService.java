package kr.co.gerion.service;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.TargetPriceAlarmVO;

public interface TargetPriceAlarmService {

	
	public void insertTargetPriceAlarm(TargetPriceAlarmVO targetPriceAlarmVO) throws Exception;
	public List<Map<String, Object>> selectTargetPriceAlarmList(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectTargetPriceAlarm(Map<String, Object> map) throws Exception;
	public void deleteTargetPriceAlarm(Map<String, Object> map) throws Exception;
	public void deleteTargetPriceAlarmList(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
}
