package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.UserCategoryMapper;
import kr.co.gerion.service.UserCategoryService;
import kr.co.gerion.vo.UserCategoryVO;

@Service("userCategoryService")
public class UserCategoryServiceImpl implements UserCategoryService{

	
	@Resource(name="userCategoryMapper")
	private UserCategoryMapper userCategoryMapper;
	
	
	public void insertUserCategory(UserCategoryVO userCategoryVO) throws Exception{
		userCategoryMapper.insertUserCategory(userCategoryVO);
	}
	
	public List<Map<String, Object>> selectUserCategoryList(Map<String, Object> map) throws Exception{
		return userCategoryMapper.selectUserCategoryList(map);
	}
	
	public void deleteUserCategory(Map<String, Object> map) throws Exception{
		userCategoryMapper.deleteUserCategory(map);
	}
	
	
	
	
	
	
	
}
