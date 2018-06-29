package kr.co.gerion.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class StringUtils {
	
	private static String charSet = "UTF-8";
	
	private StringUtils() {
	}
	
    public static String replaceAll(String text, String oldChar, String newChar) {
        String newText = text;
        if (text != null) {
            StringBuffer sb = new StringBuffer((int)(text.length() * 1.5));
            int index = 0;
            while ( (index = text.indexOf(oldChar)) > -1) {
                sb.append(text.substring(0, index));
                sb.append(newChar);
                if (index + oldChar.length() < text.length()) {
                    text = text.substring(index + oldChar.length());    
                } else {
                    text = "";
                    break;
                }
            }
            sb.append(text);
            newText = sb.toString();
            
        }
        return newText;
    }

	public static String crop(String source, int length, String tail, String charset) throws UnsupportedEncodingException {
		if (source == null) return null;
		String result = source;
		int sLength = 0;
		int bLength = 0;
		char c;
		
		if ( result.getBytes(charset).length > length) {
		    length = length - tail.length();
			while ( (bLength + 1) <= length) {
				c = result.charAt(sLength);
				bLength++;
				sLength++;
				if (c > 127) bLength++;
			}
			result = result.substring(0, sLength) + tail;
		}
		return result;
	}

	public static String crop(String source, int length, String tail) {
		if (source == null) return null;
		
		String result = source;
		int sLength = 0;
		int bLength = 0;
		char c;
		
		if ( result.getBytes().length > length) {
		    length = length - tail.length();
			while ( (bLength + 1)  <= length) {
				c = result.charAt(sLength);
				bLength++;
				sLength++;
				if (c > 127) bLength++;
			}
			result = result.substring(0, sLength) + tail;
		}
		return result;
		
	}
	
	public static String htmlCrop(String str, int length, String tail) {
		StringBuffer result = new StringBuffer();

		int remain = length;
		int position = 0;
		int bIndex = -1;
		int eIndex = -1;
		String temp = str;
		
		while (position < temp.length()) {
			bIndex = temp.indexOf("<");
			eIndex = temp.indexOf(">", bIndex);
			
			if (bIndex > -1) {
				if (remain > 0) {
					result.append(crop(temp.substring(0, bIndex), remain, tail));
				}
				if (bIndex < eIndex) {
					position = eIndex + 1;
					result.append(temp.substring(bIndex, position));
					temp = temp.substring(position);
				} else {
					if (remain > 0) {
						result.append(crop(temp, remain, tail));
						temp = "";
					}
				}	
			} else {
				if (remain > 0) {
					result.append(crop(temp, remain, tail));
						temp = "";
				}
				position = temp.length();
			}
		}

		if (remain > 0) {
			result.append(crop(temp, remain, tail));
		}
		
		return result.toString();
	}

	public static String[] toStringArray(String str, String delimiter) {
        String[] result = null;
        if (str != null) {
            TokenizerUtil t = new TokenizerUtil(str, delimiter);
            result = new String[t.countTokens()];
            for( int i = 0; t.hasMoreTokens(); i++) {
                result[i] = t.nextToken();
            }            
        }
		return result;
	}

	public static int[] toIntArray(String str, String delimiter, int defaultIntValue) {
		TokenizerUtil t = new TokenizerUtil(str, delimiter);
		int[] result = new int[t.countTokens()];
		for( int i = 0; t.hasMoreTokens(); i++) {
			result[i] = TypeConvertUtil.convertInt(t.nextToken(), defaultIntValue);
		}
		return result;
	}

	public static String encode(String s) 	{
		return encode(s, charSet) ;
	}

	public static String encode(String s, String charset) 	{
		if (charset == null || "8859_1".equals(charset)) return s;
		String out = null;
		if (s == null ) return null;
		
		try { 
			out = new String(s.getBytes("8859_1"), charset);
		} 	catch(UnsupportedEncodingException ue) {
			out = new String(s);
		}
		return out;
	}	

	public static String decode(String s) 	{
		return decode(s, charSet) ;
	}

	public static String decode(String s, String charset) 	{
		if (charset == null || "8859_1".equals(charset)) return s;
		String out = null;
		if (s == null ) return null;
		try { 
			out = new String(s.getBytes(charset), "8859_1");
		} 	catch(UnsupportedEncodingException ue) {
			out = new String(s);
		}
		return out;
	}
	

	public static boolean isNull(String value) {
		if(value != null && !value.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isEmpty(String value) {
		if(value != null && !value.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isEmpty(Object obj) {
		if(obj != null){
			String value = obj.toString();
			if(value != null && !value.trim().equals("")) {
				return false;
			} else {
				return true;
			}
		}else{
			return true;
		}
	}
	
	public static Object defaultSet(Object obj, Object value) {
		if(isEmpty(obj)){
			obj = value;
		}
		return obj;
	}
	
	
	public static String makeRandomString(int strLength)
	{

		String result = "";
		String letter[] = {"A","B","C","D","E","F","G","H","I","J","K","M","N","P","Q","R","S","T","U","V","W","X","Y","2","3","4","5","6","7","8","9"};
		Random rn = new Random();
		
		for(int i=0; i<strLength; i++)
		{
			result = result + letter[rn.nextInt(letter.length)];
		}
		
		return result;
	}
	
	/**
	 * string split, godbasic[2010.03.09]
	 * @param sourceString
	 * @param token
	 * @return
	 */
	public static String[] split( String sourceString, String token) {
		String[] strData = sourceString.split("[" + token + "]");
		return strData;
	}
	
	/**
	 * parameter -> map, godbasic[2010.03.09]
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request){
		Map<String, String> parameterMap = new HashMap<String, String>();
		Enumeration<String> enums = request.getParameterNames();
		while(enums.hasMoreElements()){
			String paramName = (String)enums.nextElement();
			String[] parameters = request.getParameterValues(paramName);
			parameterMap.put(paramName, parameters[0]);
		}
		return parameterMap; 
	}
	
	public static Map<String, String> getAjaxParameterMap(HttpServletRequest request){
		Map<String, String> parameterMap = new HashMap<String, String>();
		Enumeration<String> enums = request.getParameterNames();
		String[] paramNames = enums.nextElement().split("&");
		for (String str : paramNames) {
			String[] param = str.split("=");
			if(param.length == 2 )parameterMap.put(param[0], param[1]);
		}
		return parameterMap; 
	}
	
	public static String encodeKor(String param){
		try {
			if(isNull(param)) return "";
			return URLEncoder.encode(param, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static String decodeKor(String param){
		try {
			if(isNull(param)) return "";
			return URLDecoder.decode(param, "euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public static String numberFormat(String str, String format){
	    DecimalFormat df = new DecimalFormat(format);//("#,##0.00");
	    return df.format(TypeConvertUtil.convertDouble(str, 0));
	}
	/**
	 * 문자열 길이 체크
	 * @param str
	 * @param length
	 * @return
	 */
	public static boolean checkLength(String str, int length){
	   if(isEmpty(str)) return false;
	   if(str.length() ==length ){
		   return true;
	   }else{
		   return false;
	   }
	}
}
