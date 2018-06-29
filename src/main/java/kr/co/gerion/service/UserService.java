package kr.co.gerion.service;

import java.util.List;
import java.util.Map;

import kr.co.gerion.vo.UserVO;

public interface UserService {

	
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception; 
	public int insertUser(UserVO userVO) throws Exception;
	
	
	
	
	
	
	
	
}
