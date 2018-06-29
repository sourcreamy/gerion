package kr.co.gerion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gerion.Rss.Feed;
import kr.co.gerion.Rss.FeedMessage;
import kr.co.gerion.Rss.RSSFeedParser;
import kr.co.gerion.service.NewsCategoryService;
import kr.co.gerion.service.UserCategoryService;

@Controller
@RequestMapping(value="/research")
public class ResearchController {

	
	private static final Logger logger = LoggerFactory.getLogger(ResearchController.class);
	
	
	@Autowired
	private UserCategoryService userCategoryService;
	
	@Autowired
	private NewsCategoryService newsCategoryService;
	
	
	@RequestMapping(value = "/news", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView research(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			//String searchWord = request.getParameter("searchWord").toString();
			String searchWord = "";
			
			if(userSessionMap != null){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", userSessionMap.get("user_id").toString());
				map.put("searchWord", searchWord);
				
				List<Map<String, Object>> newsCategoryList = newsCategoryService.selectNewsCategoryList(map);
				List<Map<String, Object>> userCategoryList = userCategoryService.selectUserCategoryList(map);
				
				for(int i = 0; i < newsCategoryList.size(); i++){
					Map<String, Object> categoryMap = newsCategoryList.get(i); 
					searchWord += categoryMap.get("news_category_name").toString();
					if(i < newsCategoryList.size()-1){
						searchWord += "+";
					}
				}
				if(userCategoryList.size() > 0){
					searchWord += "+";
				}
				for(int i = 0; i < userCategoryList.size(); i++){
					Map<String, Object> categoryMap = userCategoryList.get(i); 
					searchWord += categoryMap.get("category_name").toString();
					if(i < userCategoryList.size()-1){
						searchWord += "+";
					}
				}
				
				mav.addObject("newsCategoryList", newsCategoryList );
				mav.addObject("userCategoryList", userCategoryList );
				mav.addObject("searchWord", searchWord );
				
				RSSFeedParser parser = new RSSFeedParser(
                        "http://newssearch.naver.com/search.naver?where=rss&query="+searchWord);
				Feed feed = parser.readFeed();
				List<FeedMessage> feedList = feed.getMessages(); 
				System.out.println(feed);
				for (FeedMessage message : feed.getMessages()) {
					System.out.println(message);
				}
				mav.addObject("feedList", feedList );
				
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	
		
		return mav;
	}
	
	
	@RequestMapping(value = "/market", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView market(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/premiumanalysis", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView premiumanalysis(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
