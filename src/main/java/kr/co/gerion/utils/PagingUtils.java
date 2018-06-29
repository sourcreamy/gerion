package kr.co.gerion.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PagingUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(PagingUtils.class);
	
	
	/**
	 * 페이지 정보를 셋팅한다.
	 * @param request
	 * @return Map
	 */
	public static Map<String,Object> setPageing(HttpServletRequest request, int total, Map<String,Object>  paramMap){

		int cPage = StringUtilsEx.parseInt(request.getParameter("cPage"), 1);
		int pageNum = BaseAppConstants.NUM_OF_PAGES;
		
		//String deviceType = (String)request.getSession().getAttribute("deviceType");
		//if("mobile".equals(deviceType)){
		//	pageNum = 5;
		//}
		if(request.getRequestURI().indexOf("mobile") > -1){
			pageNum = 5;
        }else{
            if(request.getRequestURI().indexOf("admin") > -1){
	            if(WebUtils.isPhone(request.getHeader("User-Agent"))){
	            	pageNum = 5;
	            }
            }
        }
		
		try{
			
		  if(request.getRequestURL().indexOf("/play/game-list-end.do") != -1){
			  paramMap = setPageInfo(cPage, total, BaseAppConstants.NUM_OF_ROWS_FOR_END_LIST, pageNum, paramMap);	  
		  }else if(request.getRequestURL().indexOf("/play/getPlayerList-bs.do") != -1){
			  paramMap = setPageInfo(cPage, total, BaseAppConstants.NUM_OF_ROWS_FOR_PLAYER_LIST, pageNum, paramMap);
          }else{
        	  paramMap = setPageInfo(cPage, total, BaseAppConstants.NUM_OF_ROWS, pageNum, paramMap);
		  }
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		return paramMap;
	}
	
	
	public static Map<String,Object> setPageing(HttpServletRequest request, int total, int numOfRows, int numOfPages, Map<String,Object>  paramMap){

		int cPage = StringUtilsEx.parseInt(request.getParameter("cPage"), 1);
		int pageNum = numOfPages;
		
		//String deviceType = (String)request.getSession().getAttribute("deviceType");
		//if("mobile".equals(deviceType)){
		//	pageNum = 5;
		//}
		if(request.getRequestURI().indexOf("mobile") > -1){
			pageNum = 5;
        }
		
		try{
			paramMap = setPageInfo(cPage, total, numOfRows, pageNum, paramMap);
		}catch(Exception e ){
			e.printStackTrace();
		}
		return paramMap;
	} 
	
	
	
    public static Map<String, Object>  setPageInfo(int cPage, int total, int numOfRows, int numOfPages, Map<String,Object>  paramMap) {

	    int startPage = 1;
	    int endPage = 1;
	    int totalPage = 1;
        int startRownum =  ((cPage-1) * numOfRows);
        //int startRownum =  ((cPage-1) * numOfRows) + 1;
        int endRownum = startRownum + numOfRows - 1;

        if ( total > 0) {   
            totalPage = total / numOfRows;
            if( (total % numOfRows) > 0 ) {
                totalPage += 1;
            }
            startPage = ((cPage - 1) / numOfPages) * numOfPages + 1;
            endPage = (((startPage - 1) + numOfPages) / numOfPages) * numOfPages;

            // 총페이지수가 계산된 마지막 페이지 번호보다 작을 경우 총 페이지수가 마지막 페이지 번호가 됨
            if(totalPage <= endPage) {
                endPage = totalPage;
            }
        } else {
            totalPage = 1;
            startPage = 1;
            endPage = 1;
        } 
        
        paramMap.put("cPage", cPage);
        paramMap.put("numOfRows", numOfRows);
        paramMap.put("numOfPages", numOfPages);
        paramMap.put("startPage", startPage);
        paramMap.put("endPage", endPage);
        paramMap.put("totalPage", totalPage);
        paramMap.put("total", total);
        paramMap.put("startRownum", startRownum);
        paramMap.put("endRownum", endRownum);

        return  paramMap; 
    }
	
	
}
