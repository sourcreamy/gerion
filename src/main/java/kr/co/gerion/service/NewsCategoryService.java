package kr.co.gerion.service;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.NewsCategoryVO;

public interface NewsCategoryService {

	
	public void insertNewsCategory(NewsCategoryVO newsCategoryVO) throws Exception;
	public List<Map<String, Object>> selectNewsCategoryList(Map<String, Object> map) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
}
