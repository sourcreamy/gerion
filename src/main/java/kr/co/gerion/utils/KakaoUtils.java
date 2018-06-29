package kr.co.gerion.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class KakaoUtils {

	
	
	
	public static JsonNode getAccessToken(String autorize_code,String apiKey, String redirectUri){ 
	    final String RequestUrl = "https://kauth.kakao.com/oauth/token";

	    String RestApiKey = apiKey;						//테스트키
	    String Redirect_URI = redirectUri;
	    
	    final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
	    postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
	    postParams.add(new BasicNameValuePair("client_id", RestApiKey));    // REST API KEY
	    postParams.add(new BasicNameValuePair("redirect_uri", Redirect_URI));    // 리다이렉트 URI
	    postParams.add(new BasicNameValuePair("code", autorize_code));    // 로그인 과정중 얻은 code 값

	    final HttpClient client = HttpClientBuilder.create().build();
	    final HttpPost post = new HttpPost(RequestUrl);
	    JsonNode returnNode = null;
	
	    try {
	      post.setEntity(new UrlEncodedFormEntity(postParams));
	      final HttpResponse response = client.execute(post);
	      final int responseCode = response.getStatusLine().getStatusCode();

	      //JSON 형태 반환값 처리
	      ObjectMapper mapper = new ObjectMapper();
	      returnNode = mapper.readTree(response.getEntity().getContent());

	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	        // clear resources
	    }
	    
	    return returnNode;

	}
	
	
	public static JsonNode getKakaoUserInfo(String autorize_code,String apiKey, String redirectUri) {
		
		
		 final String RequestUrl = "https://kapi.kakao.com/v1/user/me";
		
		// String RestApiKey = apiKey;						
		// String Redirect_URI = redirectUri;
		 	String code = autorize_code; // 로그인 과정중 얻은 토큰 값

		    final HttpClient client = HttpClientBuilder.create().build();
		    final HttpPost post = new HttpPost(RequestUrl);
		    
		    // add header
		    post.addHeader("Authorization", "Bearer " + code);
		    
		    JsonNode returnNode = null;
		    
		    try {
		      final HttpResponse response = client.execute(post);
		      final int responseCode = response.getStatusLine().getStatusCode();

		      //JSON 형태 반환값 처리
		      ObjectMapper mapper = new ObjectMapper();
		      returnNode = mapper.readTree(response.getEntity().getContent());
		      
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    } catch (ClientProtocolException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } finally {
		        // clear resources
		    }
		    return returnNode;
		}


	
	
	public static JsonNode kakaoUserLogout(String autorize_code) {
		
		
		 final String RequestUrl = "https://kapi.kakao.com/v1/user/logout";
		
		  String code = autorize_code; // 로그인 과정중 얻은 토큰 값

		  final HttpClient client = HttpClientBuilder.create().build();
		  final HttpPost post = new HttpPost(RequestUrl);
		    
		    // add header
		   post.addHeader("Authorization", "Bearer " + code);
		   JsonNode returnNode = null;
		    
		    try {
		      final HttpResponse response = client.execute(post);
		      final int responseCode = response.getStatusLine().getStatusCode();

		      //JSON 형태 반환값 처리
		      ObjectMapper mapper = new ObjectMapper();
		      returnNode = mapper.readTree(response.getEntity().getContent());
		      
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    } catch (ClientProtocolException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    } finally {
		        // clear resources
		    }
		    return returnNode;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
