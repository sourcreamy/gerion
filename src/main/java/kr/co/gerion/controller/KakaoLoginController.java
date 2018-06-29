package kr.co.gerion.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gerion.service.UserService;
import kr.co.gerion.utils.BaseAppConstants;
import kr.co.gerion.utils.KakaoUtils;
import kr.co.gerion.vo.UserVO;

@Controller
@RequestMapping(value="/kakao")
public class KakaoLoginController {

	//private String RestApiKey = "e3a057034847accf088ffd0b3ad83801";
	
	@Value("#{appProp['RestApiKey']}")
    private String RestApiKey;
    
    @Value("#{appProp['Redirect_URI']}")
    private String Redirect_URI;
	
    
    @Autowired
    private UserService userService;
	
	@RequestMapping(value = "/kakaoLogin",produces="application/json", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView kakaoLogin(@RequestParam("code") String code,ModelAndView mav,HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		
		try{
			
			JsonNode jsonToken  = KakaoUtils.getAccessToken(code,RestApiKey,Redirect_URI);			
			JsonNode userInfo = KakaoUtils.getKakaoUserInfo(jsonToken.get("access_token").toString(),RestApiKey,Redirect_URI);
			String id = userInfo.path("id").asText();
			String nickname = null;
			String thumbnailImage = null;
			String profileImage = null;
			 		
		    
			JsonNode properties = userInfo.path("properties");
			if (!properties.isMissingNode()) {
				nickname = properties.path("nickname").asText();
				thumbnailImage = properties.path("thumbnail_image").asText();
				profileImage = properties.path("profile_image").asText();
			}
			
				// id로 사용자를 select 하고 데이터가 없다면 insert를 진행 한다.  
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", id);
			Map<String, Object> userMap = userService.selectUser(map);
				
			if(userMap == null){
				UserVO userVO = new UserVO();
				userVO.setAccessToken(jsonToken.get("access_token").toString());
				userVO.setAdviserYn("N");
				userVO.setExpiresIn(jsonToken.get("expires_in").toString());
				userVO.setMainMenu("");
				userVO.setRefreshToken(jsonToken.get("refresh_token").toString());
				userVO.setThumbnailImageUrl(thumbnailImage);
				userVO.setTokenType(jsonToken.get("token_type").toString());
				userVO.setUserGrade(BaseAppConstants.USER_GRADE_NORMAL);
				userVO.setUserId(id);
				userVO.setUserNick(nickname);
				userVO.setUserRole(BaseAppConstants.USER_ROLE_NORMAL);
				userVO.setUserStatus(BaseAppConstants.USER_STATUS_NORMAL);
				userService.insertUser(userVO);
				userMap = userService.selectUser(map);
				session.setAttribute("user", userMap);
			}else{
				session.setAttribute("user", userMap);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.setViewName("redirect:/menu/menu.do");
		return mav;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
	
		try{
			Map<String, Object> userSessionMap = (Map<String, Object>)session.getAttribute("user");
			JsonNode userInfo = KakaoUtils.kakaoUserLogout(userSessionMap.get("access_token").toString());
			session.invalidate();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "redirect:/menu/menu.do";
	}
	
	
	
}
