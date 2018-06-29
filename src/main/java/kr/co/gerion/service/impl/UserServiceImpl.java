package kr.co.gerion.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.gerion.mapper.UserMapper;
import kr.co.gerion.service.UserService;
import kr.co.gerion.vo.UserVO;


@Service("userService")
public class UserServiceImpl implements UserService{

	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	
	
	public Map<String, Object> selectUser(Map<String, Object> map) throws Exception{
		return userMapper.selectUser(map);
	}

	public int insertUser(UserVO userVO) throws Exception{
		return userMapper.insertUser(userVO);
	}

	
}
