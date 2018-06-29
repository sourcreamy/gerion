package kr.co.gerion.utils;

import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ParamUtils {

	private static final Logger logger = LoggerFactory.getLogger(ParamUtils.class);
	
	
	
	
	/**
	 * 파라미터 정보를 맵에 담는다.
	 * @param request
	 * @return
	 */
    public static Map<String, Object> getParamToMap(HttpServletRequest request) {
		return getParamToMap(request, false);
	}
    
	/**
	 * 파라미터 정보를 맵에 담는다.
	 * @param request
	 * @param convertParamNameToUpperCase
	 * @return
	 */
    public static Map<String, Object> getParamToMap(HttpServletRequest request, boolean convertParamNameToUpperCase) {
		Enumeration em = request.getParameterNames();
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		while (em.hasMoreElements()) {
			String str = (String) em.nextElement();
			String val = request.getParameter(str);
			if(!StringUtilsEx.isEmpty(val)){
				parametersMap.put((convertParamNameToUpperCase ? str.toUpperCase(): str), new String(val.trim()));
				logger.debug("[param] "+str + " : "	+ val.trim());
			}
		}
		return parametersMap;
	}
	
	/**
	 * queryString 만들기
	 * @param request
	 * @return
	 */
    public static String makeParameterQuery(HttpServletRequest request) {
    	StringBuffer sb = new StringBuffer();
    	String query = "";
    	java.util.Enumeration em = request.getParameterNames();
		while (em.hasMoreElements()) {
			String key = (String) em.nextElement();
			String val = request.getParameter(key);
    		if(key != null && !"".equals(key.trim())){
    			try {
					query = sb.append("&").append(key).append("=").append(URLEncoder.encode(val,  BaseAppConstants.CHARACTER_SET)).toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
		}
		
		return query;
    }
	
	/**
	 * queryString 만들기
	 * @param request
	 * @param paramNames
	 * @return
	 */
    public static String makeParameterQuery(HttpServletRequest request, String[] paramNames) {
    	StringBuffer sb = new StringBuffer();
    	String query = "";
    	String s = null;
    		
	    	for(int i=0, n=0; i<paramNames.length; i++){
	    		s = request.getParameter(paramNames[i]);
	    		if(s != null && !"".equals(s.trim())){
	    			try {
						query = sb.append("&").append(paramNames[i]).append("=").append(URLEncoder.encode(s,  BaseAppConstants.CHARACTER_SET)).toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
	    			n++;
	    		}
	    	}
    	
    	return query;
    }
}
