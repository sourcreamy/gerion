package kr.co.gerion.mapper;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.UserVO;

public interface UserMapper {


	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception; 
	public int insertUser(UserVO userVO) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
}
