package kr.co.gerion.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import kr.co.gerion.service.InterestItemService;
import kr.co.gerion.service.ItemService;
import kr.co.gerion.service.TargetPriceAlarmService;
import kr.co.gerion.utils.ResultApi;
import kr.co.gerion.utils.StringUtilsEx;
import kr.co.gerion.utils.WebUtils;
import kr.co.gerion.vo.TargetPriceAlarmVO;

@Controller
@RequestMapping(value="/company")
public class CompanyController {

	
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private TargetPriceAlarmService targetPriceAlarmService;
	
	@Autowired
	private InterestItemService interestItemService;
	
	@RequestMapping(value = "/company-news", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView companyNews(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = request.getParameter("itemSrtCd").toString();
				String marketCd = request.getParameter("marketCd").toString();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				Map<String, Object> itemMap = itemService.selectItemByItemSrtCd(map);
				mav.addObject("itemMap", itemMap);
				mav.addObject("itemSrtCd", itemSrtCd);
				mav.addObject("marketCd", marketCd);
				
				RSSFeedParser parser = new RSSFeedParser(
                        "http://newssearch.naver.com/search.naver?where=rss&query="+itemMap.get("item_name").toString());
				Feed feed = parser.readFeed();
				List<FeedMessage> feedList = feed.getMessages(); 
				System.out.println(feed);
				for (FeedMessage message : feed.getMessages()) {
					System.out.println(message);
				}
				mav.addObject("feedList", feedList);
				mav.addObject("feedListCount", feedList.size());
				
				
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/company", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView company(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {


try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = request.getParameter("itemSrtCd").toString();
				String marketCd = request.getParameter("marketCd").toString();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				Map<String, Object> itemMap = itemService.selectItemByItemSrtCd(map);
				mav.addObject("itemMap", itemMap);
				
				StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode(marketCd, "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemSrtCd, "UTF-8")));
		        URL url = new URL(urlBuilder.toString());
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("apikey", "l7xx68055723d71e410f922435f66c2edde4");
		        System.out.println("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        JSONParser jsonParser = new JSONParser();
	            JSONObject obj = (JSONObject)jsonParser.parse(sb.toString());
	            obj = (JSONObject) obj.get("result");
	            // JSONArray jsonArray = (JSONArray) obj.get("result");
	            String trdPrc = obj.get("trdPrc").toString();
	            String opnprc = obj.get("opnprc").toString();
	            String accTrdvol = obj.get("accTrdvol").toString();
	            mav.addObject("trdPrc", StringUtilsEx.changeMoney(obj.get("trdPrc").toString()));//trdPrc			현재가
	            mav.addObject("accTrdvol", StringUtilsEx.changeMoney(obj.get("accTrdvol").toString()));//trdvol		 거래량
	            mav.addObject("cmpprevddTpCd", obj.get("cmpprevddTpCd").toString());//cmpprevddTpCd				1:상한/2:상승/3:보합/4:하한/5:하락/6:기세상한/7:기세상승/8:기세하한/9:기세하락
	            mav.addObject("cmpprevddPrc", obj.get("cmpprevddPrc").toString());//cmpprevddPrc			전일대비가격
	            /*double upDownPer = ((Float.parseFloat(obj.get("trdPrc").toString())-Float.parseFloat(obj.get("opnprc").toString()))/(Float.parseFloat(obj.get("opnprc").toString()))*100);
	            upDownPer = Math.round(upDownPer*100)/100.0;
	            mav.addObject("cmpprevddPer", upDownPer);//cmpprevddPer			등락율
*/	            mav.addObject("opnprc", obj.get("opnprc").toString());//opnprc			시가
	            mav.addObject("hgprc", obj.get("hgprc").toString());//hgprc			고가
	            mav.addObject("lwprc", obj.get("lwprc").toString());//lwprc			저가
	            
	             
	            
	            urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemMap.get("item_srt_cd").toString(), "UTF-8")));
				url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("apikey", "l7xx68055723d71e410f922435f66c2edde4");
		        System.out.println("Response code: " + conn.getResponseCode());
		        sb = new StringBuilder();
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        jsonParser = new JSONParser();
	            obj = (JSONObject)jsonParser.parse(sb.toString());
	            obj = (JSONObject) obj.get("result");
	            mav.addObject("eps", obj.get("eps").toString());
	            mav.addObject("per", obj.get("per").toString());
	            mav.addObject("pbr", obj.get("pbr").toString());
	            mav.addObject("bps", obj.get("bps").toString());
	            mav.addObject("dps", obj.get("dps").toString());
	            mav.addObject("divYd", obj.get("divYd").toString());
	            mav.addObject("prevddClsprc", obj.get("prevddClsprc").toString());
	            double upDownPer = ((Float.parseFloat(trdPrc)-Float.parseFloat(obj.get("prevddClsprc").toString()))/(Float.parseFloat(obj.get("prevddClsprc").toString()))*100);
	            upDownPer = Math.round(upDownPer*100)/100.0;
	            mav.addObject("cmpprevddPer", upDownPer);//cmpprevddPer			등락율
	            String listShrs = obj.get("listShrs").toString();
	            Long mc = Long.parseLong(trdPrc)*Long.parseLong(listShrs);
	            String rtnval = StringUtilsEx.convertHangul(String.valueOf(mc));
	            if(rtnval.contains("조")){
	            	rtnval = rtnval.substring(0,rtnval.indexOf("억")+1);
	            }else if(rtnval.contains("억")){
	            	rtnval = rtnval.substring(0,rtnval.indexOf("만")+1);
	            }
	            mav.addObject("rtnval",rtnval);						//시가총액
	            
	            
	            String startDt = WebUtils.getDate(-11);
	            String endDt = WebUtils.getDate(-1);
	            
	            urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/history".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemMap.get("item_srt_cd").toString(), "UTF-8")));
	            urlBuilder.append("?");
	            urlBuilder.append(URLEncoder.encode("trnsmCycleTpCd","UTF-8") + "=" + URLEncoder.encode("D", "UTF-8") + "&");
	            urlBuilder.append(URLEncoder.encode("inqStrtDd","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8") + "&");
	            urlBuilder.append(URLEncoder.encode("inqEndDd","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8") + "&");
	            urlBuilder.append(URLEncoder.encode("reqCnt","UTF-8") + "=" + URLEncoder.encode("20", "UTF-8"));
	            
				url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("apikey", "l7xx68055723d71e410f922435f66c2edde4");
		        System.out.println("Response code: " + conn.getResponseCode());
		        sb = new StringBuilder();
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
	            
		        jsonParser = new JSONParser();
	            obj = (JSONObject)jsonParser.parse(sb.toString());
	            obj = (JSONObject) obj.get("result");
	            JSONArray jsonArray = (JSONArray) obj.get("hisLists");
	            obj = (JSONObject)jsonArray.get(0);
	            
	            String yAccTrdvol = obj.get("accTrdvol").toString();		//전일누적거래량 
	            double accTrdvolPer = ((Float.parseFloat(accTrdvol)-Float.parseFloat(yAccTrdvol))/(Float.parseFloat(yAccTrdvol))*100);
	            accTrdvolPer = Math.round(accTrdvolPer*100)/100.0;
	            mav.addObject("accTrdvolPer",accTrdvolPer);						//전일대비
	            
			}
			
			}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/company-analysis", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView companyAnalysis(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		
		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = request.getParameter("itemSrtCd").toString();
				String marketCd = request.getParameter("marketCd").toString();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				Map<String, Object> itemMap = itemService.selectItemByItemSrtCd(map);
				mav.addObject("itemMap", itemMap);
				mav.addObject("itemSrtCd", itemSrtCd);
				mav.addObject("marketCd", marketCd);
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/company-ticker", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView companyTicker(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = request.getParameter("itemSrtCd").toString();
				String marketCd = request.getParameter("marketCd").toString();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				Map<String, Object> itemMap = itemService.selectItemByItemSrtCd(map);
				mav.addObject("itemMap", itemMap);
				mav.addObject("itemSrtCd", itemSrtCd);
				mav.addObject("marketCd", marketCd);
				
				StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode(marketCd, "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemSrtCd, "UTF-8")));
		        URL url = new URL(urlBuilder.toString());
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("apikey", "l7xx68055723d71e410f922435f66c2edde4");
		        System.out.println("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        StringBuilder sb = new StringBuilder();
		        String line;
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        JSONParser jsonParser = new JSONParser();
	            JSONObject obj = (JSONObject)jsonParser.parse(sb.toString());
	            obj = (JSONObject) obj.get("result");
	            // JSONArray jsonArray = (JSONArray) obj.get("result");
	            String trdPrc = obj.get("trdPrc").toString();
	            String opnprc = obj.get("opnprc").toString();
	            String accTrdvol = obj.get("accTrdvol").toString();
	            mav.addObject("trdPrc", StringUtilsEx.changeMoney(obj.get("trdPrc").toString()));//trdPrc			현재가
	            mav.addObject("accTrdvol", StringUtilsEx.changeMoney(obj.get("accTrdvol").toString()));//trdvol		 거래량
	            mav.addObject("cmpprevddTpCd", obj.get("cmpprevddTpCd").toString());//cmpprevddTpCd				1:상한/2:상승/3:보합/4:하한/5:하락/6:기세상한/7:기세상승/8:기세하한/9:기세하락
	            mav.addObject("cmpprevddPrc", obj.get("cmpprevddPrc").toString());//cmpprevddPrc			전일대비가격
	            /*double upDownPer = ((Float.parseFloat(obj.get("trdPrc").toString())-Float.parseFloat(obj.get("opnprc").toString()))/(Float.parseFloat(obj.get("opnprc").toString()))*100);
	            upDownPer = Math.round(upDownPer*100)/100.0;
	            mav.addObject("cmpprevddPer", upDownPer);//cmpprevddPer			등락율
*/	            mav.addObject("opnprc", obj.get("opnprc").toString());//opnprc			시가
	            mav.addObject("hgprc", obj.get("hgprc").toString());//hgprc			고가
	            mav.addObject("lwprc", obj.get("lwprc").toString());//lwprc			저가
	            
	             
	            
	            urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemMap.get("item_srt_cd").toString(), "UTF-8")));
				url = new URL(urlBuilder.toString());
				conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("apikey", "l7xx68055723d71e410f922435f66c2edde4");
		        System.out.println("Response code: " + conn.getResponseCode());
		        sb = new StringBuilder();
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        while ((line = rd.readLine()) != null) {
		            sb.append(line);
		        }
		        rd.close();
		        conn.disconnect();
		        jsonParser = new JSONParser();
	            obj = (JSONObject)jsonParser.parse(sb.toString());
	            obj = (JSONObject) obj.get("result");
	            mav.addObject("eps", obj.get("eps").toString());
	            mav.addObject("per", obj.get("per").toString());
	            mav.addObject("pbr", obj.get("pbr").toString());
	            mav.addObject("bps", obj.get("bps").toString());
	            mav.addObject("dps", obj.get("dps").toString());
	            mav.addObject("divYd", obj.get("divYd").toString());
	            mav.addObject("prevddClsprc", obj.get("prevddClsprc").toString());
	            double upDownPer = ((Float.parseFloat(trdPrc)-Float.parseFloat(obj.get("prevddClsprc").toString()))/(Float.parseFloat(obj.get("prevddClsprc").toString()))*100);
	            upDownPer = Math.round(upDownPer*100)/100.0;
	            mav.addObject("cmpprevddPer", upDownPer);//cmpprevddPer			등락율
	            
	            if(itemMap.get("interest_item_id") != null){
	            	map.put("interestItemId", itemMap.get("interest_item_id").toString());
	            }
	            mav.addObject("targetPriceAlarmList", targetPriceAlarmService.selectTargetPriceAlarmList(map));
	            
			}
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/insertTargetPriceAlarm", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi insertTargetPriceAlarm(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = request.getParameter("itemSrtCd").toString();
				String marketCd = request.getParameter("marketCd").toString();
				String targetPrice = request.getParameter("targetPrice").toString();
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				
				Map<String, Object> interestItemMap = interestItemService.selectInterestItemByItemSrtCd(map);
				TargetPriceAlarmVO targetAlarmVO = new TargetPriceAlarmVO();	
				targetAlarmVO.setInterestItemId(interestItemMap.get("interest_item_id").toString());
				targetAlarmVO.setItemCd(interestItemMap.get("item_cd").toString());
				targetAlarmVO.setItemName(interestItemMap.get("item_name").toString());
				targetAlarmVO.setItemSrtCd(interestItemMap.get("item_srt_cd").toString());
				targetAlarmVO.setTargetPrice(targetPrice);
				String targetPriceAlarmId = "TPI"+UUID.randomUUID().toString().replaceAll("-", "");
				targetAlarmVO.setTargetPriceAlarmId(targetPriceAlarmId);
				targetAlarmVO.setUserId(userSessionMap.get("user_id").toString());
				targetPriceAlarmService.insertTargetPriceAlarm(targetAlarmVO);
				result.setResultData(targetAlarmVO);
			}else{
				result.setResultCode("E002");
			}

		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	
	@RequestMapping(value = "/deleteTargetPriceAlarm", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi deleteTargetPriceAlarm(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				
				String targetPriceAlarmId = request.getParameter("targetPriceAlarmId").toString();				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("targetPriceAlarmId", targetPriceAlarmId);
				map.put("userId", userSessionMap.get("user_id").toString());
				targetPriceAlarmService.deleteTargetPriceAlarm(map);
				
			}else{
				result.setResultCode("E002");
			}

		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	
	
}
