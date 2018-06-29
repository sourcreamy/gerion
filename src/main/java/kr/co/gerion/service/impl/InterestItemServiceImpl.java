package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.InterestItemMapper;
import kr.co.gerion.service.InterestItemService;
import kr.co.gerion.vo.InterestItemVO;

@Service("interestItemService")
public class InterestItemServiceImpl implements InterestItemService{

	
	
	@Resource(name="interestItemMapper")
	private InterestItemMapper interestItemMapper;
	
	
	public void insertInterestItem(InterestItemVO interestItemVO) throws Exception{
		interestItemMapper.insertInterestItem(interestItemVO);
	}
	
	public List<Map<String, Object>> selectInterestItemList(Map<String, Object> map) throws Exception{
		return interestItemMapper.selectInterestItemList(map);
	}
	
	public Map<String, Object> selectInterestItem(Map<String, Object> map) throws Exception{
		return interestItemMapper.selectInterestItem(map);
	}
	
	public void deleteInterestItem(Map<String, Object> map) throws Exception{
		interestItemMapper.deleteInterestItem(map);
	}
	
	public void deleteInterestItemAll(Map<String, Object> map) throws Exception{
		interestItemMapper.deleteInterestItemAll(map);
	}
	
	public void updateInterestItemPurchasePrice(Map<String, Object> map) throws Exception{
		interestItemMapper.updateInterestItemPurchasePrice(map);
	}
	
	public Map<String, Object> selectInterestItemByItemSrtCd(Map<String, Object> map) throws Exception{
		return interestItemMapper.selectInterestItemByItemSrtCd(map);
	}
	
	public void deleteInterestItemByItemSrtCd(Map<String, Object> map) throws Exception{
		interestItemMapper.deleteInterestItemByItemSrtCd(map);
	}
	
	
	
	
	
	
	
}
