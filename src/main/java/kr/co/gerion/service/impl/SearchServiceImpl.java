package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.SearchMapper;
import kr.co.gerion.service.SearchService;
import kr.co.gerion.vo.SearchVO;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	
	@Resource(name="searchMapper")
	private SearchMapper searchMapper;
	
	
	public void insertSearch(SearchVO searchVO) throws Exception{
		searchMapper.insertSearch(searchVO);
	}
	
	public List<Map<String, Object>> selectSearchList(Map<String, Object> map) throws Exception{
		return searchMapper.selectSearchList(map);
	}
	
	public Map<String, Object> selectSearch(Map<String, Object> map) throws Exception{
		return searchMapper.selectSearch(map);
	}
	
	public void deleteSearchItem (Map<String, Object> map) throws Exception{
		searchMapper.deleteSearchItem(map);
	}
	
	public void deleteSearchItemAll(Map<String, Object> map) throws Exception{
		searchMapper.deleteSearchItemAll(map);
	}
	
	
	
	
	
	
	
	
	
}
