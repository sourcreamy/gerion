package kr.co.gerion.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.gerion.service.ItemService;
import kr.co.gerion.vo.ItemVO;

@Controller
@RequestMapping(value="/main")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@Autowired
	private ItemService itemService;
	
	
	
	
	@RequestMapping(value = "/getting-started", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

	/*	try{
			//StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/lists".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")));			//종목 리스트
			StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")).replace("{issuecode}", URLEncoder.encode("005930", "UTF-8")));	//주식가격
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
	        System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}

	@RequestMapping(value = "/slider-page", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView sliderPage(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		try{
			
			/*Map<String, Object> map = new HashMap<String, Object>();
	
			map.put("marketCd", "kosdaq");
			List<Map<String, Object>> itemList = itemService.selectItemList(map);
			StringBuilder urlBuilder = null;
			
			ItemVO itemvo = new ItemVO();
			
			for(int i = 0; i < itemList.size(); i++){
				itemvo.init();
				Map<String, Object> itemMap = itemList.get(i); 
				urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemMap.get("item_srt_cd").toString(), "UTF-8")));
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
	            JSONObject jobj = (JSONObject) obj.get("result");
				
	            itemvo.setAdmisuYn(jobj.get("admisuYn").toString());
	            itemvo.setHaltYn(jobj.get("haltYn").toString());
	            itemvo.setIdxIndMidclssCd(jobj.get("idxIndMidclssCd").toString());
	            itemvo.setItemSrtCd(itemMap.get("item_srt_cd").toString());
	            itemvo.setKospiYn(jobj.get("kospiYn").toString());
	            itemvo.setKospi50Yn(jobj.get("kospi50Yn").toString());
	            itemvo.setKospi100Yn(jobj.get("kospi100Yn").toString());
	            itemvo.setListDd(jobj.get("listDd").toString());
	            itemvo.setListShrs(jobj.get("listShrs").toString());
	            itemvo.setLwlmtprc(jobj.get("lwlmtprc").toString());
	            itemvo.setMfindYn(jobj.get("mfindYn").toString());
	            itemvo.setPrevddClsprc(jobj.get("prevddClsprc").toString());
	            itemvo.setSmeYn(jobj.get("smeYn").toString());
	            itemvo.setUplmtprc(jobj.get("uplmtprc").toString());
	            itemvo.setMarketCd(map.get("marketCd").toString());
	            itemService.updateItem(itemvo);
			}*/
			
			
			
			//StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/lists".replace("{marketcode}", URLEncoder.encode("kosdaq", "UTF-8")));			//종목 리스트
			//StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")).replace("{issuecode}", URLEncoder.encode("005930", "UTF-8")));	//주식가격
	        /*URL url = new URL(urlBuilder.toString());
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
	        conn.disconnect();*/
	        //System.out.println(sb.toString());
	       /* 
	        JSONParser jsonParser = new JSONParser();
            JSONObject obj = (JSONObject)jsonParser.parse(sb.toString());
            JSONArray jsonArray = (JSONArray) obj.get("isuLists");
	        
            ItemVO itemvo = new ItemVO();
            for(int i = 0; i < jsonArray.size(); i++){
            	itemvo.init();
            	JSONObject jobj = (JSONObject)jsonArray.get(i);
            	
            	itemvo.setItemSrtCd(jobj.get("isuSrtCd").toString());
            	itemvo.setItemCd(jobj.get("isuCd").toString());
            	itemvo.setItemName(jobj.get("isuKorNm").toString());
            	itemvo.setMarketCd("kosdaq");
            	itemService.insertItem(itemvo);
            }*/
            
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	

	

	
	@RequestMapping(value = "/analysis", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView analysis(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	

	
	
	
	
	@RequestMapping(value = "/excavation", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView excavation(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/home", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView home(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	@RequestMapping(value = "/index", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView index(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value = "/keywords", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView keywords(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/loading", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView loading(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/market-content", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView marketContent(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/noproducts", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView noproducts(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/pa-content", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView paContent(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/portfolio", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView portfolio(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	

	
	
	@RequestMapping(value = "/profile", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView profile(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/purchase-history", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView purchaseHistory(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/recommendedportfolio", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView recommendedportfolio(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	

	
	

	

	
	@RequestMapping(value = "/swing-market", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView swingMarket(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/swing-marketpage", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView swingMarketpage(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/vip", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView vip(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value = "/vvip", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView vvip(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/master-insert", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView masterInsert(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		try{
			
			Map<String, Object> map = new HashMap<String, Object>();
	
			map.put("marketCd", "kosdaq");
			List<Map<String, Object>> itemList = itemService.selectItemList(map);
			StringBuilder urlBuilder = null;
			
			ItemVO itemvo = new ItemVO();
			
			for(int i = 0; i < itemList.size(); i++){
				itemvo.init();
				Map<String, Object> itemMap = itemList.get(i); 
				urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/master".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")).replace("{issuecode}", URLEncoder.encode(itemMap.get("item_srt_cd").toString(), "UTF-8")));
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
	            JSONObject jobj = (JSONObject) obj.get("result");
				
	            itemvo.setAdmisuYn(jobj.get("admisuYn").toString());
	            itemvo.setHaltYn(jobj.get("haltYn").toString());
	            itemvo.setIdxIndMidclssCd(jobj.get("idxIndMidclssCd").toString());
	            itemvo.setItemSrtCd(itemMap.get("item_srt_cd").toString());
	            itemvo.setKospiYn(jobj.get("kospiYn").toString());
	            itemvo.setKospi50Yn(jobj.get("kospi50Yn").toString());
	            itemvo.setKospi100Yn(jobj.get("kospi100Yn").toString());
	            itemvo.setListDd(jobj.get("listDd").toString());
	            itemvo.setListShrs(jobj.get("listShrs").toString());
	            itemvo.setLwlmtprc(jobj.get("lwlmtprc").toString());
	            itemvo.setMfindYn(jobj.get("mfindYn").toString());
	            itemvo.setPrevddClsprc(jobj.get("prevddClsprc").toString());
	            itemvo.setSmeYn(jobj.get("smeYn").toString());
	            itemvo.setUplmtprc(jobj.get("uplmtprc").toString());
	            itemvo.setMarketCd(map.get("marketCd").toString());
	            itemvo.setEps(jobj.get("eps").toString());
	            itemvo.setPer(jobj.get("per").toString());
	            itemvo.setPbr(jobj.get("pbr").toString());
	            itemvo.setBps(jobj.get("bps").toString());
	            itemvo.setDps(jobj.get("dps").toString());
	            itemvo.setDivYd(jobj.get("divYd").toString());
	            itemService.updateItem(itemvo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	@RequestMapping(value = "/item-insert", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView itemInsert(Locale locale,ModelAndView mav, HttpServletRequest request,HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		try{
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("marketCd", "kosdaq");
			
			StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/lists".replace("{marketcode}", URLEncoder.encode(map.get("marketCd").toString(), "UTF-8")));			//종목 리스트
			//StringBuilder urlBuilder = new StringBuilder("https://sandbox-apigw.koscom.co.kr/v2/market/stocks/{marketcode}/{issuecode}/price".replace("{marketcode}", URLEncoder.encode("kospi", "UTF-8")).replace("{issuecode}", URLEncoder.encode("005930", "UTF-8")));	//주식가격
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
	        //System.out.println(sb.toString());
	        
	        JSONParser jsonParser = new JSONParser();
            JSONObject obj = (JSONObject)jsonParser.parse(sb.toString());
            JSONArray jsonArray = (JSONArray) obj.get("isuLists");
	        
            ItemVO itemvo = new ItemVO();
            for(int i = 0; i < jsonArray.size(); i++){
            	itemvo.init();
            	JSONObject jobj = (JSONObject)jsonArray.get(i);
            	
            	itemvo.setItemSrtCd(jobj.get("isuSrtCd").toString());
            	itemvo.setItemCd(jobj.get("isuCd").toString());
            	itemvo.setItemName(jobj.get("isuKorNm").toString());
            	itemvo.setMarketCd(map.get("marketCd").toString());
            	itemService.insertItem(itemvo);
            }
            
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		mav.addObject("serverTime", formattedDate );
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
