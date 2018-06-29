package kr.co.gerion.controller;

import java.util.HashMap;
import java.util.List;
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
@RequestMapping(value="/news")
public class NewsController {

	
	private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	
	
	@RequestMapping(value = "/newsPage", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView newsPage(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		try{
		
			String newsUri = request.getParameter("newsUri").toString();
			newsUri.replaceAll("\\^", "\\?");
			newsUri.replaceAll("\\+", "\\=");
			mav.addObject("newsUri", newsUri);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
}
