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

import kr.co.gerion.service.InterestItemService;
import kr.co.gerion.service.ItemService;
import kr.co.gerion.service.TargetPriceAlarmService;
import kr.co.gerion.utils.ResultApi;
import kr.co.gerion.utils.StringUtilsEx;
import kr.co.gerion.vo.InterestItemVO;

@Controller
@RequestMapping(value="/interest")
public class InterestItemController {

	
	private static final Logger logger = LoggerFactory.getLogger(InterestItemController.class);
	
	
	@Autowired
	private InterestItemService interestItemService;
		
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private TargetPriceAlarmService targetPriceAlarmService;
	
	
	@RequestMapping(value = "/interest", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView interest(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		
		
		try{
			
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			if(userSessionMap != null){
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("userId", userSessionMap.get("user_id").toString());
				List<Map<String, Object>> interestItemList = interestItemService.selectInterestItemList(map);
				
				for(int i = 0; i < interestItemList.size(); i++){
					Map<String, Object> interestItem = interestItemList.get(i); 
					String marketcode = interestItem.get("market_cd").toString();
					String issuecode = interestItem.get("item_srt_cd").toString();
					
					StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode(marketcode, "UTF-8")).replace("{issuecode}", URLEncoder.encode(issuecode, "UTF-8")));
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
		            
		            if(interestItem.get("purchase_price") != null){
		            	double upDownPer = ((Float.parseFloat(trdPrc)-Float.parseFloat(interestItem.get("purchase_price").toString()))/(Float.parseFloat(interestItem.get("purchase_price").toString()))*100);
		            	upDownPer = Math.round(upDownPer*100)/100.0;
		            	interestItem.put("upDownPer", upDownPer);
		            }
		            
		            interestItem.put("trdPrc", StringUtilsEx.changeMoney(trdPrc));				// 현재가
		            interestItem.put("cmpprevddTpCd", obj.get("cmpprevddTpCd").toString());				//1:상한/2:상승/3:보합/4:하한/5:하락/6:기세상한/7:기세상승/8:기세하한/9:기세하락
		            interestItem.put("cmpprevddPrc", StringUtilsEx.changeMoney(obj.get("cmpprevddPrc").toString()));					//cmpprevddPrc			전일대비가격
		            
		            urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(marketcode, "UTF-8")).replace("{issuecode}", URLEncoder.encode(issuecode, "UTF-8")));
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
		            double upDownPer = ((Float.parseFloat(trdPrc)-Float.parseFloat(obj.get("prevddClsprc").toString()))/(Float.parseFloat(obj.get("prevddClsprc").toString()))*100);
		            upDownPer = Math.round(upDownPer*100)/100.0;
		            interestItem.put("cmpprevddPer", upDownPer);//cmpprevddPer			등락율
		            interestItemList.set(i, interestItem);
		            
				}
				
				mav.addObject("interestItemList", interestItemList);
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	

	
	@RequestMapping(value = "/selectInterestItem", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi selectInterestItemByItemSrtCd(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			String itemCd = (String)request.getParameter("itemCd");
			String marketCd = (String)request.getParameter("marketCd");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("itemSrtCd", itemCd);
			map.put("marketCd", marketCd);
			map.put("userId", userSessionMap.get("user_id").toString());
		
			Map<String, Object> interestItem = interestItemService.selectInterestItemByItemSrtCd(map); 
			
			if(interestItem != null){
				result.setResultCode("E001");				//이미 관심종목으로 등록 되어 있으면 관심종목 해제  	
			}

		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	
	
	@RequestMapping(value = "/insertInterestItem", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi insertInterestItem(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			HttpSession session = request.getSession();
			Map userSessionMap = (Map)session.getAttribute("user");
			
			if(userSessionMap != null){
				String itemSrtCd = (String)request.getParameter("itemSrtCd");
				String marketCd = (String)request.getParameter("marketCd");
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("itemSrtCd", itemSrtCd);
				map.put("marketCd", marketCd);
				map.put("userId", userSessionMap.get("user_id").toString());
				Map<String, Object> itemMap = itemService.selectItemByItemSrtCd(map);
				InterestItemVO interestVO = new InterestItemVO();
				interestVO.setAlarmYn("N");
				interestVO.setFreeYn("N");
				String interestItemId = "ITI"+UUID.randomUUID().toString().replaceAll("-", "");
				interestVO.setInterestItemId(interestItemId);
				interestVO.setItemCd(itemMap.get("item_cd").toString());
				interestVO.setItemSrtCd(itemSrtCd);
				interestVO.setItemName(itemMap.get("item_name").toString());
				interestVO.setUserId(userSessionMap.get("user_id").toString());	
				interestItemService.insertInterestItem(interestVO);
			}else{
				result.setResultCode("E002");
			}
			
		 }catch(Exception e){
			 result.setResultCode("E001");
			 e.printStackTrace();
		 }
		
		return result;
	}
	
	@RequestMapping(value = "/deleteInterestItem", method = RequestMethod.POST)
	@ResponseBody
	public ResultApi deleteInterestItem(ModelAndView mav, HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ResultApi result = new ResultApi();
		 
		 try{
			 
			 HttpSession session = request.getSession();
				Map userSessionMap = (Map)session.getAttribute("user");
				
				if(userSessionMap != null){
					String itemSrtCd = (String)request.getParameter("itemSrtCd");
					String marketCd = (String)request.getParameter("marketCd");
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("itemSrtCd", itemSrtCd);
					map.put("marketCd", marketCd);
					map.put("userId", userSessionMap.get("user_id").toString());
					Map<String, Object> itemMap = interestItemService.selectInterestItemByItemSrtCd(map);
					if(itemMap != null){
						interestItemService.deleteInterestItem(itemMap);
					}
					map.put("interestItemId", itemMap.get("interest_item_id").toString());
					//관심종목이 삭제 되면 시세 알림 설정도 삭제 한다.
					targetPriceAlarmService.deleteTargetPriceAlarmList(map);
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
