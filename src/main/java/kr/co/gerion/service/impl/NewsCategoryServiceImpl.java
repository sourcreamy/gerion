package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.NewsCategoryMapper;
import kr.co.gerion.service.NewsCategoryService;
import kr.co.gerion.vo.NewsCategoryVO;

@Service("newsCategoryService")
public class NewsCategoryServiceImpl implements NewsCategoryService{

	
	
	
	@Resource(name="newsCategoryMapper")
	private NewsCategoryMapper newsCategoryMapper;
	
	
	public void insertNewsCategory(NewsCategoryVO newsCategoryVO) throws Exception{
		newsCategoryMapper.insertNewsCategory(newsCategoryVO);
	}
	
	public List<Map<String, Object>> selectNewsCategoryList(Map<String, Object> map) throws Exception{
		return newsCategoryMapper.selectNewsCategoryList(map);
	}
	
	
	
	
	
	
	
	
	
	
	
}
