package kr.co.gerion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/menu")
public class MenuController {

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	
	
	@RequestMapping(value = "/menu", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView menu(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		try{
			HttpSession session = request.getSession();
			
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap == null){
				mav.setViewName("/menu/menu-sub");	
				//WebUtils.messageAndRedirectUrl(mav, "이미 사용중인 아이디 입니다.", "/baseinfo/add-employee.do");
			}else{
				mav.addObject("usernick", userSessionMap.get("user_nick"));
				mav.addObject("thumbnail", userSessionMap.get("thumbnail_image_url"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/menu-sub", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView menuSub(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/notification", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView notification(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/notification-list", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView notificationList(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/support", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView support(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/support-content", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView supportContent(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/event", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView event(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/event-content", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView eventContent(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	@RequestMapping(value = "/primary", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView primary(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	
	
	
}
