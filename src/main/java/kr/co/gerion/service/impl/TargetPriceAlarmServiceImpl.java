package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.TargetPriceAlarmMapper;
import kr.co.gerion.service.TargetPriceAlarmService;
import kr.co.gerion.vo.TargetPriceAlarmVO;

@Service("targetPriceAlarmService")
public class TargetPriceAlarmServiceImpl implements TargetPriceAlarmService {

	
	@Resource(name="targetPriceAlarmMapper")
	private TargetPriceAlarmMapper targetPriceAlarmMapper;
	
	
	
	public void insertTargetPriceAlarm(TargetPriceAlarmVO targetPriceAlarmVO) throws Exception{
		targetPriceAlarmMapper.insertTargetPriceAlarm(targetPriceAlarmVO);
	}
	
	public List<Map<String, Object>> selectTargetPriceAlarmList(Map<String, Object> map) throws Exception{
		return targetPriceAlarmMapper.selectTargetPriceAlarmList(map);
	}
	
	public Map<String, Object> selectTargetPriceAlarm(Map<String, Object> map) throws Exception{
		return targetPriceAlarmMapper.selectTargetPriceAlarm(map);
	}
	
	public void deleteTargetPriceAlarm(Map<String, Object> map) throws Exception{
		targetPriceAlarmMapper.deleteTargetPriceAlarm(map);
	}
	
	public void deleteTargetPriceAlarmList(Map<String, Object> map) throws Exception{
		targetPriceAlarmMapper.deleteTargetPriceAlarmList(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
