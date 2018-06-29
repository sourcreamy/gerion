package kr.co.gerion.service;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.InterestItemVO;

public interface InterestItemService {

	
	public void insertInterestItem(InterestItemVO interestItemVO) throws Exception;
	public List<Map<String, Object>> selectInterestItemList(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectInterestItem(Map<String, Object> map) throws Exception;
	public void deleteInterestItem(Map<String, Object> map) throws Exception;
	public void deleteInterestItemAll(Map<String, Object> map) throws Exception;
	public void updateInterestItemPurchasePrice(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectInterestItemByItemSrtCd(Map<String, Object> map) throws Exception;
	public void deleteInterestItemByItemSrtCd(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
}
