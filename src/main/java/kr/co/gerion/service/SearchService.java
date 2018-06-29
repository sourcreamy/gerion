package kr.co.gerion.service;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.SearchVO;

public interface SearchService {

	public void insertSearch(SearchVO searchVO) throws Exception;
	public List<Map<String, Object>> selectSearchList(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectSearch(Map<String, Object> map) throws Exception;
	public void deleteSearchItem (Map<String, Object> map) throws Exception;
	public void deleteSearchItemAll(Map<String, Object> map) throws Exception;
	
	
}
