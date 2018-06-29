package kr.co.gerion.mapper;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.ItemVO;

public interface ItemMapper {

	
	public void insertItem(ItemVO itemVO) throws Exception;
	public List<Map<String, Object>> selectItemList(Map<String, Object> map) throws Exception;
	public void  updateItem(ItemVO itemVO) throws Exception;
	public void insertMidClsCd(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> selectItemListBySearchword(Map<String, Object> map) throws Exception;
	public int selectItemListCountBySearchword(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectItemByItemSrtCd(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> selectItemListBySearchwordAndItemCd(Map<String, Object> map) throws Exception;
		
	
	
}
