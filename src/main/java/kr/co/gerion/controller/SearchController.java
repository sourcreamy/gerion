package kr.co.gerion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gerion.Rss.Feed;
import kr.co.gerion.Rss.FeedMessage;
import kr.co.gerion.Rss.RSSFeedParser;
import kr.co.gerion.service.ItemService;
import kr.co.gerion.service.SearchService;
import kr.co.gerion.utils.ResultApi;
import kr.co.gerion.vo.SearchVO;

@Controller
@RequestMapping(value="/search")
public class SearchController {

	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/search", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		
		try{
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			List<Map<String, Object>> searchList = null;
			if(userSessionMap != null){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", userSessionMap.get("user_id").toString());
				searchList = searchService.selectSearchList(map);
			}
			mav.addObject("searchList", searchList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/search-sub", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchSub(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/search-empty", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchEmpty(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	@RequestMapping(value = "/search-result", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchResult(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {

		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			String searchWord = request.getParameter("searchWord").toString();
			
			if(userSessionMap != null){
				Map<String, Object> map = new HashMap<String, Object>();
				//이전에 이미 db에 insert 된경우에는 저장 하지 않는다.
				map.put("userId", userSessionMap.get("user_id").toString());
				map.put("searchWord", searchWord);
				Map<String, Object> searchMap = searchService.selectSearch(map);
				if(searchMap == null){
					SearchVO searchVO = new SearchVO();
					String keywordId = "KWI"+UUID.randomUUID().toString().replaceAll("-", "");
					searchVO.setKeywordId(keywordId);
					searchVO.setKeywordName(searchWord);
					searchVO.setUserId(userSessionMap.get("user_id").toString());
					searchService.insertSearch(searchVO);
				}
				List<Map<String, Object>> itemList = itemService.selectItemListBySearchwordAndItemCd(map);
				
				String itemSrtCd =  "";
				String marketCd =  "";
				
				if(itemList != null && itemList.size() > 0){
					itemSrtCd = itemList.get(0).get("item_srt_cd").toString();			//검색결과가 많아도 기업의 뉴스 페이지로 보내야 하기 때문에....... 
					marketCd = itemList.get(0).get("market_cd").toString();	
				}
				
				//해당 키워드의 뉴스 정보 가져오기
				//http://newssearch.naver.com/search.naver?where=rss&query="+keyword
				RSSFeedParser parser = new RSSFeedParser(
                        "http://newssearch.naver.com/search.naver?where=rss&query="+searchWord);
				Feed feed = parser.readFeed();
				List<FeedMessage> feedList = feed.getMessages(); 
				System.out.println(feed);
				for (FeedMessage message : feed.getMessages()) {
					System.out.println(message);
				}
				mav.addObject("searchWord", searchWord);
				mav.addObject("itemList", itemList);
				mav.addObject("itemListCount", itemList.size());
				mav.addObject("feedList", feedList);
				mav.addObject("feedListCount", feedList.size());
				mav.addObject("itemSrtCd", itemSrtCd);
				mav.addObject("marketCd", marketCd);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/search-result-sub", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView searchResultSub(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/deleteSearchItem", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi deleteSearchItem(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			String keywordId = (String)request.getParameter("keywordId");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("keywordId", keywordId);
			map.put("userId", userSessionMap.get("user_id").toString());
			searchService.deleteSearchItem(map);

		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	
	@RequestMapping(value = "/deleteSearchItemAll", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi deleteSearchItemAll(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("userId", userSessionMap.get("user_id").toString());
			searchService.deleteSearchItemAll(map);

		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
