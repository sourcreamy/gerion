package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.ItemMapper;
import kr.co.gerion.service.ItemService;
import kr.co.gerion.vo.ItemVO;



@Service("itemService")
public class ItemServiceImpl implements ItemService {

	
	@Resource(name="itemMapper")
	private ItemMapper itemMapper;
	
	
	public void insertItem(ItemVO itemVO) throws Exception{
		itemMapper.insertItem(itemVO);
	}
	
	
	public List<Map<String, Object>> selectItemList(Map<String, Object> map) throws Exception{
		return itemMapper.selectItemList(map);
	}
	
	public void  updateItem(ItemVO itemVO) throws Exception{
		itemMapper.updateItem(itemVO);
	}
	
	
	public void insertMidClsCd(Map<String, Object> map) throws Exception{
		itemMapper.insertMidClsCd(map);
	}
	
	public List<Map<String, Object>> selectItemListBySearchword(Map<String, Object> map) throws Exception{
		return itemMapper.selectItemListBySearchword(map);
	}
	
	public int selectItemListCountBySearchword(Map<String, Object> map) throws Exception{
		return itemMapper.selectItemListCountBySearchword(map);
	}
	
	public Map<String, Object> selectItemByItemSrtCd(Map<String, Object> map) throws Exception{
		return itemMapper.selectItemByItemSrtCd(map);
	}
	
	public List<Map<String, Object>> selectItemListBySearchwordAndItemCd(Map<String, Object> map) throws Exception{
		return itemMapper.selectItemListBySearchwordAndItemCd(map);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
