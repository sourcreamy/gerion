package kr.co.gerion.mapper;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.UserCategoryVO;

public interface UserCategoryMapper {

	
	
	
	public void insertUserCategory(UserCategoryVO userCategoryVO) throws Exception;
	public List<Map<String, Object>> selectUserCategoryList(Map<String, Object> map) throws Exception;
	public void deleteUserCategory(Map<String, Object> map) throws Exception;
		
	
	
	
	
	
	
	
	
	
	
	
	
}
