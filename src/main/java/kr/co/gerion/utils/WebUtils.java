/**
 * 
 */
package kr.co.gerion.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component("webUtils")
public class WebUtils {
	
    @Value("#{appProp['upload.file.ext']}")
    private static String uploadFileExt;
    
    @Value("#{appProp['upload.image.ext']}")
    private static String uploadImageExt;
    
    
    
    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);
	
    /**
     * 업로드 가능한 파일 확장자 체크
     * @param filename
     * @return
     */
	public static boolean isRightFileExt(String filename){
		Pattern pattern = Pattern.compile(".(" + uploadFileExt +")$");
		Matcher matcher = pattern.matcher(filename.toLowerCase());
		if(!matcher.find()){
			return false;
		}
		return true;
	}
	
	
	/**
	 * 업로드 가능한 이미지 확장자 체크
	 * @param filename
	 * @return
	 */
	public static boolean isRightImageFileExt(String filename){
		Pattern pattern = Pattern.compile(".(" + uploadImageExt +")$");
		Matcher matcher = pattern.matcher(filename.toLowerCase());
		if(!matcher.find()){
			return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * javascript의 messagebox로 메세지를 출력 후 지정된 페이지로 리디렉션.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param redirectUrl
	 *            메시지 표시 후 이동할 페이지.
	 */
	public static void messageAndRedirectUrl(HttpServletResponse response,
			String message, String redirectUrl) {
		message(response, message);

		String output = "<META HTTP-EQUIV='REFRESH' CONTENT='0; URL="
				+ redirectUrl + "'>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * javascript의 messagebox로 메세지를 출력 후 이전 페이지로 복귀.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param back
	 *            되돌아갈 단계.
	 */
	public static void messageAndBack(HttpServletResponse response,
			String message, int back) {
		message(response, message);

		String output = "<script language='javascript'>history.go(" + back
				+ ");</script>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}
	
	public static void selfClose(HttpServletResponse response, String message) {

		String output = "<script language='javascript'>alert('"+message+"');self.close();</script>";
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * javascript의 messagebox로 메세지를 출력.
	 * 
	 * @param response
	 *            응답할 HttpServletResponse 객체.
	 * @param message
	 *            출력할 메세지.
	 */
	public static void message(HttpServletResponse response, String message) {
		response.setContentType("text/html; charset=utf-8");
		String output = "<script language='javascript'>history.go(1);alert('" + message
				+ "');</script>";
		try {
			response.getWriter().print(output);
		} catch (IOException e) {
		}
	}

	/**
	 * spring-MVC에서 특정 view 파일을 이용하여 javascript로 메세지 출력 후 지정된 페이지로 리디렉션하는
	 * ModelAndView 객체 반환.
	 * 
	 * @param mav
	 *            응답할 ModelAndView 객체.
	 * @param message
	 *            출력할 메세지.
	 * @param redirectUrl
	 *            메시지 표시 후 이동할 페이지.
	 */
	public static ModelAndView messageAndRedirectUrl(ModelAndView mav,
			String message, String redirect) {
		mav.setViewName("/system/alert_redirect");
		mav.addObject("scriptMsg", message);
		mav.addObject("redirectUrl", redirect);
		return mav;
	}

	/**
	 * request.getQueryString 변형
	 * 
	 * @param request
	 *            HttpServletRequest 객체
	 * @param queryString
	 *            제외될 쿼리스트링 (ex. "nSiteCode,sTab") 콤마로 구분
	 * @return
	 */
	public static String getQueryString(HttpServletRequest request,
			String queryString) {
		Enumeration<String> requestEnum = request.getParameterNames();
		ArrayList<String> requestParamList = new ArrayList<String>();
		String[] queryExt = null;
		String returnValue = "";

		while (requestEnum.hasMoreElements()) {
			requestParamList.add(requestEnum.nextElement());
		}

		try {
			if (queryString != "") {
				queryExt = queryString.split(",");

				if (queryExt.length > 0) {
					for (String query : queryExt) {
						for (int i = 0; i < requestParamList.size(); i++) {
							if (requestParamList.get(i).equals(query))
								requestParamList.remove(i);
						}
					}
				}
			}

			for (int i = (requestParamList.size() - 1); i >= 0; i--) {
				String currentParameter = requestParamList.get(i).toString();
				String currentValue = request.getParameter(currentParameter);
				returnValue = returnValue + currentParameter + "="
						+ currentValue + "&";
			}

			if (returnValue.length() > 0)
				returnValue = returnValue
						.substring(0, returnValue.length() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	/**
	 * 온클릭 했는지 확인 한후 리턴 값 참고 : 파라미터 값 비교후 값이 같으면 값을 리턴
	 * 
	 * @param paramValue
	 * @param compareValue
	 * @param returnValue
	 * @return
	 */
	public static String onClickConfirm(String paramValue, String compareValue,
			String returnValue) {
		String returnString = "";
		try {
			if (paramValue == compareValue || paramValue.equals(compareValue)) {
				returnString = returnValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "";
		}
		return returnString;
	}

	/**
	 * 모바일 브라우저인지 체크하여 리턴한다
	 * @param agent
	 * @return 모바일인 경우 true, 아닌경우 false 리턴한다.
	 */
	public static boolean isPhone(String agent)
	{
		if(agent==null) agent = " ";
		agent = agent.toUpperCase();
		boolean rtB = false;
		String[] phoneBrowser = {"iPhone", "iPod", "BlackBerry", "Android", "Windows CE", "LG", "MOT", "SAMSUNG", "SonyEricsson"};
		if(agent==null) {
			rtB = false;
		}
		else {
			for(int i=0;i<phoneBrowser.length;i++)
			{
				if(agent.matches(".*"+phoneBrowser[i].toUpperCase()+".*"))
				{
					rtB = true;
					break;
				}
			}
		}
		
		return rtB;
	}
	
	/**
	 * 아이폰인지 체크하여 리턴한다
	 * @param agent
	 * @return 아이폰인 경우 true, 아닌경우 false 리턴한다.
	 */
	public static boolean isIPhone(String agent)
	{
		if(agent==null) agent = " ";
		agent = agent.toUpperCase();
		boolean rtB = false;
		String[] phoneBrowser = {"iPhone", "iPod"};
		if(agent==null) {
			rtB = false;
		}
		else {
			for(int i=0;i<phoneBrowser.length;i++)
			{
				if(agent.matches(".*"+phoneBrowser[i].toUpperCase()+".*"))
				{
					rtB = true;
					break;
				}
			}
		}
		
		return rtB;
	}
	
	/**
	 * 현재시간 리턴
	 * @param pattern
	 * @return pattern된 현재날짜
	 */
	public static String getNow(String pattern)
	{
        Date d = new Date();            
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        
        return sdf.format(d);
	}
	
	/**
	 * 
	 * @param start
	 * @return
	 */
	public static String getTimeDiff(String start)
	{

		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
		Date startday=sf.parse(start, new ParsePosition(0));
		long startTime = startday.getTime();

		//현재의 시간 설정	
		Calendar cal=Calendar.getInstance();
		Date endDate=cal.getTime();
		long endTime=endDate.getTime();
			
		long mills= startTime - endTime;
			
		//초으로 변환
		long sec=mills/1000;
		
		return StringUtilsEx.lpad(String.valueOf(sec/3600), 3, '0') + ":" + StringUtilsEx.lpad(String.valueOf(sec % 3600 / 60), 2, '0')  + ":" + StringUtilsEx.lpad(String.valueOf(sec % 3600 % 60), 2, '0');
	}
	
	

	
	/**
	 * iDay 에 입력하신 만큼 빼거나 더한 날짜를 반환 합니다.
	 * @param iDay
	 * @return
	 */
	public static String getDate ( int iDay ) {
		 Calendar temp=Calendar.getInstance ( );
		 temp.add ( Calendar.DAY_OF_MONTH, iDay );
		 int nYear = temp.get ( Calendar.YEAR );
		 int nMonth = temp.get ( Calendar.MONTH ) + 1;
		 int nDay = temp.get ( Calendar.DAY_OF_MONTH );
		 StringBuffer sbDate=new StringBuffer ( );
		 sbDate.append ( nYear );
		 if ( nMonth < 10 ) sbDate.append ( "0" );
		 sbDate.append ( nMonth );
		 if ( nDay < 10 ) sbDate.append ( "0" );
		 sbDate.append ( nDay );
		 return sbDate.toString ( );
	}
	
	/**
	 * iDay 에 입력하신 만큼 빼거나 더한 날짜를 반환 합니다. yyyyMMddHHmmss
	 * @param iDay
	 * @return
	 */
	public static String getDateTime(int iDay)
	{

		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = new Date ( ); 
		Date tomorrow = new Date ( today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24  * iDay) );
		return sdf.format(tomorrow);
	}
	
	
	

	/**
	 * 현재 요일 리턴
	 * @param pattern
	 * @return pattern된 현재날짜
	 */
	public static int getNowWeekNum()
	{
        Date d = new Date(); 
        
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(d);
        
        return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * Data 요일 리턴
	 * @param pattern
	 * @return pattern된 endDt날짜
	 */
	public static int getEndDtNum(int days)
	{
        Date d = new Date(days); 
        
        Calendar cal = Calendar.getInstance() ;
        cal.setTime(d);
        
        return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	
	/**
	 * 랜덤 값 생성
	 * @param type
	 * @param cnt
	 * @return
	 */
	public static String randomValue(String type, int cnt) {
		
		StringBuffer strPwd = new StringBuffer();
		char str[] = new char[1];
		// 특수기호 포함
		if (type.equals("P")) {
		for (int i = 0; i < cnt; i++) {
		str[0] = (char) ((Math.random() * 94) + 33);
		strPwd.append(str);
		}
		// 대문자로만
		} else if (type.equals("A")) {
		for (int i = 0; i < cnt; i++) {
		str[0] = (char) ((Math.random() * 26) + 65);
		strPwd.append(str);
		}
		// 소문자로만
		} else if (type.equals("S")) {
		for (int i = 0; i < cnt; i++) {
		str[0] = (char) ((Math.random() * 26) + 97);
		strPwd.append(str);
		}
		// 숫자형으로
		} else if (type.equals("I")) {
		int strs[] = new int[1];
		for (int i = 0; i < cnt; i++) {
		strs[0] = (int) (Math.random() * 9);
		strPwd.append(strs[0]);
		}
		// 소문자, 숫자형
		} else if (type.equals("C")) {
		Random rnd = new Random();
		for (int i = 0; i < cnt; i++) {
		if (rnd.nextBoolean()) {
		strPwd.append((char) ((int) (rnd.nextInt(26)) + 97));
		} else {
		strPwd.append((rnd.nextInt(10)));
		}
		}
		}
		return strPwd.toString();
	}    

	/**
	 * 생녕월일로 나이 구하기
	 * @param birthday
	 * @return
	 */
	public static int getAgeFromBirthday(Date birthday) {
	    Calendar birth = new GregorianCalendar();
	    Calendar today = new GregorianCalendar();

	    birth.setTime(birthday);
	    today.setTime(new Date());

	    int factor = 0;
	    if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
	        factor = -1;
	    }
	    return today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
	}
	
	
	public static int getAgeFromBirthday(String birthday) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
		int result = 0;
		try {
			result =  getAgeFromBirthday(transFormat.parse(birthday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 숫자에 콤마표현
	 * @param num
	 * @return
	 */
	 public static String toNumFormat(int num) {
		  DecimalFormat df = new DecimalFormat("#,###");
		  return df.format(num);
	 }
	 
	 /**
	 * 금일에 날짜 더하기
	 * @param pattern d
	 * @return yyyyMMdd
	 */
	public static String addDay (String pattern, int d)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, d);
		
		return sdf.format(cal.getTime());
	}
}
